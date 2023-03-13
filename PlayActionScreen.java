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
import java.util.ArrayList;
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
	

	private ArrayList<Player> redTeam = new ArrayList<Player>();
	private ArrayList<Player> greenTeam = new ArrayList<Player>();
	private ArrayList<JLabel> redTeamLabels = new ArrayList<JLabel>();
	private ArrayList<JLabel> greenTeamLabels = new ArrayList<JLabel>();
	private ArrayList<JLabel> greenTeamScores = new ArrayList<JLabel>();
	private ArrayList<JLabel> redTeamScores = new ArrayList<JLabel>();






	
	JLabel redLabelHeader, greenLabelHeader;


	JLabel greenTeamScore;
	JLabel redTeamScore;

	
	public PlayActionScreen(PlayerEntryScreen screen)	//()
	{
		// Adds title to the frame
		actionFrame = new JFrame("Play Action Terminal");
		
		actionFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = (int)screenSize.getWidth();
		int screenHeight = (int)screenSize.getHeight();
		actionFrame.setSize(screenWidth, screenHeight);
		
		// Creates red team name header
		redLabelHeader = new JLabel("Red Team", SwingConstants.CENTER);
		
		int redLabelXPos = (screenWidth / 8);
		int redLabelYPos = (screenHeight / 16) - 40;
		
		redLabelHeader.setBounds(redLabelXPos, redLabelYPos, 280, 40);		// 220, 37
		redLabelHeader.setForeground(Color.RED);
		Border border = BorderFactory.createLineBorder(Color.WHITE, 1);
		redLabelHeader.setBorder(border);
		actionFrame.add(redLabelHeader);


		//Red team score and players
		redTeamScore = new JLabel("Score", SwingConstants.CENTER);
		redTeamScore.setBounds(redLabelXPos, redLabelYPos+25, 280, 40);
		redTeamScore.setForeground(Color.RED);
		actionFrame.add(redTeamScore);
		
		// Creates green team name header
		greenLabelHeader = new JLabel("Green Team", SwingConstants.CENTER);

		
		int greenLabelXPos = ((11 * screenWidth) / 16);
		int greenLabelYPos = (screenHeight / 16) - 40;
		
		greenLabelHeader.setBounds(greenLabelXPos, greenLabelYPos, 280, 40);		// 220, 37
		greenLabelHeader.setForeground(Color.GREEN);
		Border border2 = BorderFactory.createLineBorder(Color.WHITE, 1);
		greenLabelHeader.setBorder(border2);
		actionFrame.add(greenLabelHeader);


		//Creeate green team score and players
		greenTeamScore = new JLabel("score", SwingConstants.CENTER);
		greenTeamScore.setBounds(greenLabelXPos, greenLabelYPos+25, 280, 40);
		greenTeamScore.setForeground(Color.GREEN);
		actionFrame.add(greenTeamScore);

		
		// Creates the game timer
		timeLabel = new JLabel(String.format("%02d:%02d", minutes, seconds));
		timeLabel.setFont(new Font("Verdana", Font.PLAIN, 25));
		
		int timeLabelXPos = (screenWidth / 2) - 25;
		int timeLabelYPos = (screenHeight / 16) - 40;
		
		timeLabel.setBounds(timeLabelXPos, timeLabelYPos, 300, 40); //220, 37
		timeLabel.setForeground(Color.WHITE);
		actionFrame.add(timeLabel);
		
		actionFrame.add(timeLabel);

		//gameTimer();

		//Green teams starting score
		greenTeamScore = new JLabel("greenTeamScore", SwingConstants.CENTER);
		greenTeamScore.setBounds(greenLabelXPos, greenLabelYPos +20, 200, 40);
		actionFrame.add(greenTeamScore);
		
		
		for(int i =1; i < 30; i+=2)
		{
			if(!screen.redText[i].getText().equals(""))
			{
				redTeam.add(new Player(screen.redText[i].getText()));
			}
			if(!screen.greenText[i].getText().equals(""))
			{
				greenTeam.add(new Player(screen.greenText[i].getText()));
			}
		}
		
		//adds player Labels to the actionScreen
		for(Player player : greenTeam)
		{
			greenTeamLabels.add(new JLabel(player.getcodeName(), SwingConstants.CENTER));
			greenTeamScores.add(new JLabel(Integer.toString(player.getScore()), SwingConstants.CENTER));
		}	
		for(Player player : redTeam)
		{
			redTeamLabels.add(new JLabel(player.getcodeName(), SwingConstants.CENTER));
			redTeamScores.add(new JLabel(Integer.toString(player.getScore()), SwingConstants.CENTER));

		}	
		int redYOffSet = 0;
		for(JLabel label : redTeamLabels)
		{
			label.setBounds(redLabelXPos, redLabelYPos + 100 + redYOffSet, 280, 40);
			redYOffSet += 20;
			label.setVisible(true);
			label.paintImmediately(label.getVisibleRect());
			actionFrame.add(label);

		}
		redYOffSet = 0;
		for(JLabel label : redTeamScores)
		{
			label.setBounds(redLabelXPos + 20, redLabelYPos + 100 + redYOffSet, 280, 40);
			redYOffSet += 20;
			label.setVisible(true);
			label.paintImmediately(label.getVisibleRect());
			actionFrame.add(label);
		}
		int greenY = 0;
		for(JLabel label : greenTeamLabels)
		{
			label.setBounds(greenLabelXPos, greenLabelYPos + 100 + greenY, 280, 40);
			greenY += 20;
			label.setVisible(true);
			label.paintImmediately(label.getVisibleRect());
			actionFrame.add(label);
		}
		greenY = 0;
		for(int i = 0; i < greenTeamScores.size(); i++)
		{
			
			greenTeamScores.get(i).setBounds(greenLabelXPos + 20, greenLabelYPos + 100 + greenY, 280, 40);
			greenY += 20;
			greenTeamScores.get(i).setVisible(true);
			greenTeamScores.get(i).paintImmediately(greenTeamScores.get(i).getVisibleRect());
			actionFrame.add(greenTeamScores.get(i));
		}


	
		


		//Add player lables to the PlayActionScreen
		

		actionFrame.setLayout(null);
		actionFrame.setVisible(true);
		
		// Sets the windows background color to black
		actionFrame.getContentPane().setBackground(Color.BLACK);
	}


	private int cumulativeTeamScore(ArrayList<Player> team) {
		int cumScore = 0;
		if(team != null) {
			for(int i = 0; i < team.size(); i++) {
				cumScore += team.get(i).getScore();
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

					updatePlayers();

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
	

	public void updatePlayers()
	{
		greenTeamScore.setText(Integer.toString(cumulativeTeamScore(greenTeam)));
		redTeamScore.setText(Integer.toString(cumulativeTeamScore(redTeam)));
		for(JLabel lable : redTeamLabels)
		{
			lable.paintImmediately(lable.getVisibleRect());

		}
		for(JLabel lable : redTeamScores)
		{
			lable.paintImmediately(lable.getVisibleRect());

		}
		for(JLabel lable : greenTeamLabels)
		{
			lable.paintImmediately(lable.getVisibleRect());
		}
		for(JLabel lable : greenTeamScores)
		{
			lable.paintImmediately(lable.getVisibleRect());
		}
	}
	
	public void printPlayers()
	{
		for(Player player : redTeam)
		{
			System.out.println(player);
		}
	}
	

	
	
	// Testing the Play Action Screen
	/* 
	public static void main(String[] args)
	{
		PlayerEntryScreen screen = new PlayerEntryScreen();
		screen.greenText[1].setText("FLUX");
		screen.redText[1].setText("BUG");
		screen.redText[0].setText("DUG");
		screen.redText[5].setText("LUG");
		PlayActionScreen dew = new PlayActionScreen(screen);


	}
	*/

}
