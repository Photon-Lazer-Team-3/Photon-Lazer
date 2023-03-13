import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AbstractDocument.DefaultDocumentEvent;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.SQLException;
import java.awt.Dimension;
import java.awt.Toolkit;

import java.awt.Font;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PlayActionScreen extends JFrame
{
	JFrame actionFrame;
	//Dimension screenSize;
	
	private static int seconds = 0;
	private static int minutes = 6;
	private static JLabel timeLabel;
	private Timer timer;
	
	private Player redTeam[];
	private Player greenTeam[];
	
	JLabel [] redLabels = new JLabel[15];
	JLabel [] greenLabels = new JLabel[15];
	JLabel labelHeader;
	
	public PlayActionScreen(PlayerEntryScreen screen)	//()
	{
		// Adds title to the frame
		actionFrame = new JFrame("Play Action Terminal");
		
		actionFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = (int)screenSize.getWidth();
		int screenHeight = (int)screenSize.getHeight();
		actionFrame.setSize(screenWidth, screenHeight);

		//Create team headers
		setupHeader(actionFrame, screenWidth, screenHeight, 'r', redTeam);
		setupHeader(actionFrame, screenWidth, screenHeight, 'g', greenTeam);
		
		// Creates the game timer
		timeLabel = new JLabel(String.format("%02d:%02d", minutes, seconds));
		timeLabel.setFont(new Font("Verdana", Font.PLAIN, 25));
		
		int timeLabelXPos = (screenWidth / 2) - 25;
		int timeLabelYPos = (screenHeight / 16) - 40;
		
		timeLabel.setBounds(timeLabelXPos, timeLabelYPos, 300, 40); //220, 37
		timeLabel.setForeground(Color.WHITE);
		actionFrame.add(timeLabel);
		
		actionFrame.add(timeLabel);
		gameTimer();
		
		//Adds players from the entry screen to the Teams
		redTeam = new Player[15];
		greenTeam = new Player[15];
		
		for(int i = 1; i < 30; i+=2)
		{
			if(!screen.redText[i].equals(""))
			{
				addPlayer(new Player(screen.redText[i].getText()), redTeam);
			}
			if(!screen.greenText[i].equals(""))
			{
				addPlayer(new Player(screen.greenText[i].getText()), greenTeam);
			}
		}
		
		actionFrame.setLayout(null);
		actionFrame.setVisible(true);
		
		// Sets the windows background color to black
		actionFrame.getContentPane().setBackground(Color.BLACK);
	}

	//Create team headers
	private void setupHeader(JFrame actionFrame, int screenWidth, int screenHeight, char color, Player [] team) {
		String teamName = "";
		Color headerColor = null;
		int labelXPos = 0;
		int labelYPos = (screenHeight / 16) - 40;
		int width = 280;
		int height = 40;

		if(color == 'r') {
			teamName = "Red Team";
			headerColor = Color.RED;
			labelXPos = (screenWidth / 8);
		}
		if(color == 'g') {
			teamName = "Green Team";
			headerColor = Color.GREEN;
			labelXPos = ((11 * screenWidth) / 16);
		}

		//Display team names
		labelHeader = new JLabel(teamName, SwingConstants.CENTER);
		labelHeader.setBounds(labelXPos, labelYPos, width, height);
		labelHeader.setForeground(headerColor);
		Border border = BorderFactory.createLineBorder(Color.WHITE, 1);
		labelHeader.setBorder(border);
		actionFrame.add(labelHeader);

		//Display team scores
		int score = cumulativeTeamScore(team);
		JLabel scoreDisplay = new JLabel(Integer.toString(score), SwingConstants.CENTER);
		scoreDisplay.setBounds(labelXPos, labelYPos + 40, width, height);
		scoreDisplay.setForeground(headerColor);
		scoreDisplay.setFont(new Font("Verdana", Font.PLAIN, 36));
		actionFrame.add(scoreDisplay);
	}

	private int cumulativeTeamScore(Player [] team) {
		int cumScore = 0;
		if(team != null) {
			for(int i = 0; i < team.length; i++) {
				cumScore += team[i].getScore();
			}
		}
		return cumScore;
	}
	
	public void gameTimer()
	{
		// Creates the timer to update the display
		timer = new Timer(1000, new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				// Decrement the seconds and minutes
				seconds--;
				if (seconds < 0)
				{
					seconds = 59;
					minutes--;
				}
				
				// Checks if minutes and seconds are zero
				if (minutes == 0 && seconds == 0)
				{
					// Stops the timer if minutes and seconds are zero
					timer.stop();
				}
				
				// Sets the text for the game timer
				timeLabel.setText(String.format("%02d:%02d", minutes, seconds));
			}
		});
		// Starts the game timer
		timer.start();
	}
	
	private void addPlayer(Player player, Player [] team)
	{
		for(int i = 0; i < team.length; i++)
		{
			if(team[i] == null)
			{
				team[i] = player;
			}
		}
	}
	
	// Testing the Play Action Screen
	public static void main(String[] args)
	{
		//PlayerEntryScreen screen = new PlayerEntryScreen();
		new PlayActionScreen(new PlayerEntryScreen());		//();
	}
}
