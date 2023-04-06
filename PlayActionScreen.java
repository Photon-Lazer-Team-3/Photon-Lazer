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

import java.util.ArrayList;

public class PlayActionScreen extends JFrame
{
	JFrame actionFrame;
	//Dimension screenSize;
	
	private static int seconds = 0;
	private static int minutes = 6;
	private static JLabel timeLabel;
	private Timer timer;
	
	//private Player redTeam[];
	//private Player greenTeam[];
	
	//JLabel [] redLabels = new JLabel[15];
	//JLabel [] greenLabels = new JLabel[15];
	JLabel labelHeader;
	
	JLabel redLabelHeader, greenLabelHeader;
	JLabel greenTeamScore;
	JLabel redTeamScore;
	
	playAudio audioFile = new playAudio();
	
	private ArrayList<Player> redTeam = new ArrayList<Player>();
	private ArrayList<Player> greenTeam = new ArrayList<Player>();
	private ArrayList<JLabel> redTeamLabels = new ArrayList<JLabel>();
	private ArrayList<JLabel> greenTeamLabels = new ArrayList<JLabel>();
	private ArrayList<JLabel> greenTeamScores = new ArrayList<JLabel>();
	private ArrayList<JLabel> redTeamScores = new ArrayList<JLabel>();
	
	public PlayActionScreen(PlayerEntryScreen screen)
	{
		// Adds title to the frame
		actionFrame = new JFrame("Play Action Terminal");
		
		actionFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = (int)screenSize.getWidth();
		int screenHeight = (int)screenSize.getHeight();
		actionFrame.setSize(screenWidth, screenHeight);

		//Declare screen positions of jlabels
		int redLabelXPos = (screenWidth / 55);
		int greenLabelXPos = ((21 * screenWidth) / 32);
		int labelYPos = (screenHeight / 16) - 60;

		int timeLabelXPos = (screenWidth / 2) - 25;
		int timeLabelYPos = (screenHeight / 16) - 40;
		
		//Create team headers
		setupHeader(redTeam, actionFrame, redLabelXPos, labelYPos);
		setupHeader(greenTeam, actionFrame, greenLabelXPos, labelYPos);
		
		// Creates the game timer
		timeLabel = new JLabel(String.format("%02d:%02d", minutes, seconds));
		timeLabel.setFont(new Font("Verdana", Font.PLAIN, 25));
		
		timeLabel.setBounds(timeLabelXPos, timeLabelYPos, 300, 40);
		timeLabel.setForeground(Color.WHITE);
		actionFrame.add(timeLabel);
		
		actionFrame.add(timeLabel);
		gameTimer();
		
		// Adds Players to the Team ArrayLists
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
		
		//Adds Player Labels to the Play Action Screen
		addPlayerLabels(redTeam, redLabelXPos, labelYPos, redTeamLabels, redTeamScores);
		addPlayerLabels(greenTeam, greenLabelXPos, labelYPos, greenTeamLabels, greenTeamScores);

		actionFrame.setLayout(null);
		actionFrame.setVisible(true);
		
		// Sets the windows background color to black
		actionFrame.getContentPane().setBackground(Color.BLACK);
		
		playAudioTrack();
	}
	
	//Create team headers
	private void setupHeader(ArrayList<Player> team, JFrame actionFrame, int labelXPos, int labelYPos)
	{
		String teamName = "";
		Color headerColor = null;
		int width = 500; //450; //420; //280;
		int height = 40;

		if(team == redTeam) {
			teamName = "Red Team";
			headerColor = Color.RED;
		}

		if(team == greenTeam) {
			teamName = "Green Team";
			headerColor = Color.GREEN;
		}

		//Display team names
		labelHeader = new JLabel(teamName, SwingConstants.CENTER);
		labelHeader.setBounds(labelXPos, labelYPos, width, height);
		labelHeader.setForeground(headerColor);
		
		labelHeader.setFont(new Font("Verdana", Font.BOLD, 20));
		
		Border border = BorderFactory.createLineBorder(Color.WHITE, 1);
		labelHeader.setBorder(border);
		actionFrame.add(labelHeader);

		//Display team scores
		int score = cumulativeTeamScore(team);
		JLabel scoreDisplay = new JLabel(Integer.toString(score), SwingConstants.CENTER);
		scoreDisplay.setBounds(labelXPos, labelYPos + 40, width, height);
		scoreDisplay.setForeground(headerColor);
		
		scoreDisplay.setFont(new Font("Verdana", Font.BOLD, 30));
		
		scoreDisplay.setBorder(border);
		actionFrame.add(scoreDisplay);
	}

	private void addPlayerLabels(ArrayList<Player> team, int labelXPos, int labelYPos, ArrayList<JLabel> teamLabels, ArrayList<JLabel> teamScores) {
		for (Player player : team)
		{
			JLabel label = new JLabel(player.getcodeName(), SwingConstants.CENTER);
			label.setBounds(labelXPos, labelYPos + 100 + (teamLabels.size() * 40), 250, 40); //210, 40); //140, 40); //, 280, 40);
			label.setVisible(true);
			label.setForeground(Color.WHITE);
			
			label.setFont(new Font("Verdana", Font.PLAIN, 12));	//12 //13 //14 //15
			
			label.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
			teamLabels.add(label);
			actionFrame.add(label);
			
			
			JLabel score = new JLabel(Integer.toString(player.getScore()), SwingConstants.CENTER);
			score.setBounds(labelXPos + 250, labelYPos + 100 + (teamScores.size() * 40), 250, 40); //210, 40); //140, 40);
			score.setVisible(true);
			score.setForeground(Color.WHITE);
			
			score.setFont(new Font("Verdana", Font.BOLD, 14));		//15
			
			score.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
			teamScores.add(score);
			actionFrame.add(score);
		}
	}

	private int cumulativeTeamScore(ArrayList<Player> team)
	{
		int cumScore = 0;
		if(team != null)
		{
			for(int i = 0; i < team.size(); i++) //.length; i++)
			{
				cumScore += team.get(i).getScore(); //[i].getScore();
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
					
					updatePlayers();
					//updatePlayers(redTeam, redLabelXPos, redLabelYPos, redTeamLabels, redTeamScore);
					//updatePlayers(greenTeam, greenLabelXPos, greenLabelYPos, greenTeamLabels, greenTeamScore);
				}
				
				// New If-Else Below:
				if(cumulativeTeamScore(redTeam) > cumulativeTeamScore(greenTeam))
				{
					redTeamScore.setVisible(true);
					redTeamScore.setVisible(false);
				}
				else if(cumulativeTeamScore(redTeam) < cumulativeTeamScore(greenTeam))
				{
					greenTeamScore.setVisible(true);
					greenTeamScore.setVisible(false);
				}
				else
				{
					// redTeamScore.setVisible(true);
					// greenTeamScore.setVisible(true);
				}
				
				// Checks if minutes and seconds are zero
				if (minutes == 0 && seconds == 0)
				{
					// Stops the timer if minutes and seconds are zero
					timer.stop();
					
					// Stops the audio file once the timer reaches zero
					audioFile.playCompleted = true;
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
	
	private void playAudioTrack()
	{
		//playAudio player = new playAudio();
		int audioFileInteger = audioFile.generateRandomInteger();
		
		String audioFilePath = "Track0" + audioFileInteger + ".wav";
		//playAudio player = new playAudio();
		audioFile.play(audioFilePath);
	}

	// From Joseph: THIS UPDATE METHOD WAS NOT WORKING FOR ME.
	// public void updatePlayers()
	// {
		// greenTeamScore.setText(Integer.toString(cumulativeTeamScore(greenTeam)));
		// redTeamScore.setText(Integer.toString(cumulativeTeamScore(redTeam)));
		// for(JLabel label : redTeamLabels)
		// {
			// label.paintImmediately(label.getVisibleRect());
		// }
		// for(JLabel label : redTeamScores)
		// {
			// label.paintImmediately(label.getVisibleRect());
		// }
		// for(JLabel label : greenTeamLabels)
		// {
			// label.paintImmediately(label.getVisibleRect());
		// }
		// for(JLabel label : greenTeamScores)
		// {
			// label.paintImmediately(label.getVisibleRect());
		// }
		// return;
	// }
	
	//----------------BEN'S NEW AND IMPROVED updatePlayers() FUNCTION----------------//
	/*public void updatePlayers(ArrayList<Player> team, int labelXPos, int labelYPos, ArrayList<JLabel> teamLabels, ArrayList<JLabel> teamScore) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = (int)screenSize.getWidth();
		int screenHeight = (int)screenSize.getHeight();
		actionFrame.setSize(screenWidth, screenHeight);

		// Retrieves Code Names and Scores
		for(int i = 0; i < team.size(); i++) {
			teamLabels.get(i).setText(team.get(i).getcodeName());
			teamScores.get(i).setText(Integer.toString(team.get(i).getScore()));
		}

		// Ensures no duplicate labels for players' code names are created
		for(JLabel label : teamLabels)
		{
			label.setVisible(false);
			actionFrame.remove(label);
		}
		teamLabels.clear();

		// Updates Code Name for Green Team Players
		for(Player player : team)
		{
			JLabel label = new JLabel(player.getcodeName(), SwingConstants.CENTER);
			label.setBounds(labelXPos, labelYPos + 100 + (teamLabels.size() * 40), 250, 40);		//140, 40);
			
			label.setForeground(Color.WHITE);
			
			label.setFont(new Font("Verdana", Font.PLAIN, 12));
			
			Border border = BorderFactory.createLineBorder(Color.WHITE, 1);
			label.setBorder(border);
			
			label.setVisible(true);
			label.paintImmediately(label.getVisibleRect());
			actionFrame.add(label);
			teamLabels.add(label);
		}

		// Ensures No Duplicate Labels for Green Team Players' Scores are Created
		for(JLabel label : teamScores)
		{
			label.setVisible(false);
			actionFrame.remove(label);
		}
		teamScores.clear();
		
		// Updates player scores
		for(Player player : team)
		{
			JLabel label = new JLabel(Integer.toString(player.getScore()), SwingConstants.CENTER);
			label.setBounds(labelXPos + 250, labelYPos + 100 + (teamScores.size() * 40), 250, 40);
			label.setVisible(true);
			
			label.setForeground(Color.WHITE);
			
			label.setFont(new Font("Verdana", Font.BOLD, 14));
			
			Border border = BorderFactory.createLineBorder(Color.WHITE, 1);
			label.setBorder(border);
			
			label.paintImmediately(label.getVisibleRect());
			actionFrame.add(label);
			teamScores.add(label);
		}

		actionFrame.revalidate();
		actionFrame.repaint();
	}*/

	public void updatePlayers()
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = (int)screenSize.getWidth();
		int screenHeight = (int)screenSize.getHeight();
		actionFrame.setSize(screenWidth, screenHeight);
		
		// Position of the Red Team Player Column(s)
		int redLabelXPos = (screenWidth / 55);				//(screenWidth / 32); //(screenWidth / 8);
		int redLabelYPos = (screenHeight / 16) - 60;
		
		// Position of the Green Team Player Columns
		int greenLabelXPos = ((21 * screenWidth) / 32);			//((11 * screenWidth) / 16);
		int greenLabelYPos = (screenHeight / 16) - 60;
		
		// Retrieves Code Names and Scores for Green Team Players
		for(int i = 0; i < greenTeam.size(); i++) {
			greenTeamLabels.get(i).setText(greenTeam.get(i).getcodeName());
			greenTeamScores.get(i).setText(Integer.toString(greenTeam.get(i).getScore()));
		}
		
		// Retrieves Code Names and Scores for Red Team Players
		for(int i = 0; i < redTeam.size(); i++)
		{
			redTeamLabels.get(i).setText(redTeam.get(i).getcodeName());
			redTeamScores.get(i).setText(Integer.toString(redTeam.get(i).getScore()));
		}
		
		// Ensures No Duplicate Labels for Green Team Players' Code Names are Created
		for(JLabel label : greenTeamLabels)
		{
			label.setVisible(false);
			actionFrame.remove(label);
		}
		greenTeamLabels.clear();
		
		// Updates Code Name for Green Team Players
		for(Player player : greenTeam)
		{
			JLabel label = new JLabel(player.getcodeName(), SwingConstants.CENTER);
			label.setBounds(greenLabelXPos, greenLabelYPos + 100 + (greenTeamLabels.size() * 40), 250, 40);		//140, 40);
			
			label.setForeground(Color.WHITE);
			
			label.setFont(new Font("Verdana", Font.PLAIN, 12));
			
			Border border = BorderFactory.createLineBorder(Color.WHITE, 1);
			label.setBorder(border);
			
			label.setVisible(true);
			label.paintImmediately(label.getVisibleRect());
			actionFrame.add(label);
			greenTeamLabels.add(label);
		}
		
		// Ensures No Duplicate Labels for Red Team Players' Code Names are Created
		for(JLabel label : redTeamLabels)
		{
			label.setVisible(false);
			actionFrame.remove(label);
		}
		redTeamLabels.clear();
		
		// Updates Code Name for Red Team Players
		for(Player player : redTeam)
		{
			JLabel label = new JLabel(player.getcodeName(), SwingConstants.CENTER);
			label.setBounds(redLabelXPos, redLabelYPos + 100 + (redTeamLabels.size() * 40), 250, 40);
			label.setVisible(true);
			
			label.setForeground(Color.WHITE);
			
			label.setFont(new Font("Verdana", Font.PLAIN, 12));
			
			Border border = BorderFactory.createLineBorder(Color.WHITE, 1);
			label.setBorder(border);
			
			label.paintImmediately(label.getVisibleRect());
			actionFrame.add(label);
			redTeamLabels.add(label);
		}
		
		// Ensures No Duplicate Labels for Green Team Players' Scores are Created
		for(JLabel label : greenTeamScores)
		{
			label.setVisible(false);
			actionFrame.remove(label);
		}
		greenTeamScores.clear();
		
		// Updates Scores for Green Team Players
		for(Player player : greenTeam)
		{
			JLabel label = new JLabel(Integer.toString(player.getScore()), SwingConstants.CENTER);
			label.setBounds(greenLabelXPos + 250, greenLabelYPos + 100 + (greenTeamScores.size() * 40), 250, 40);
			label.setVisible(true);
			
			label.setForeground(Color.WHITE);
			
			label.setFont(new Font("Verdana", Font.BOLD, 14));
			
			Border border = BorderFactory.createLineBorder(Color.WHITE, 1);
			label.setBorder(border);
			
			label.paintImmediately(label.getVisibleRect());
			actionFrame.add(label);
			greenTeamScores.add(label);
		}
		
		// Ensures No Duplicate Labels for Red Team Players' Scores are Created
		for(JLabel label : redTeamScores)
		{
			label.setVisible(false);
			actionFrame.remove(label);
		}
		redTeamScores.clear();
		
		// Updates Scores for Red Team Players
		for(Player player : redTeam)
		{
			JLabel label = new JLabel(Integer.toString(player.getScore()), SwingConstants.CENTER);
			label.setBounds(redLabelXPos + 250, redLabelYPos + 100 + (redTeamScores.size() * 40), 250, 40);
			label.setVisible(true);
			
			label.setForeground(Color.WHITE);
			
			label.setFont(new Font("Verdana", Font.BOLD, 14));
			
			Border border = BorderFactory.createLineBorder(Color.WHITE, 1);
			label.setBorder(border);
			
			label.paintImmediately(label.getVisibleRect());
			actionFrame.add(label);
			redTeamScores.add(label);
		}
		
		actionFrame.revalidate();
		actionFrame.repaint();
}

	//Not really used at all
	/*public void printPlayers()
	{
		for(Player player : redTeam)
		{
			System.out.println(player);
		}
		for(Player player : greenTeam)
		{
			System.out.println(player);
		}
	}*/
	
	//Testing the Play Action Screen
	public static void main(String[] args)
	{
		//PlayerEntryScreen screen = new PlayerEntryScreen();
		
		// ORIGINAL TEST
		//new PlayActionScreen(new PlayerEntryScreen());		//();
		
		// Hard-Coded Test Cases for Play Action Screen and Player Entry Screen
		PlayerEntryScreen screen = new PlayerEntryScreen();
		
		screen.redText[1].setText("AlexPrill999");
		screen.redText[3].setText("AndrewMurphster420");
		screen.redText[5].setText("SirJoseph167");
		screen.redText[7].setText("testlimitsinalllowercaseletter");		// Fits 30 lowercase letter
		screen.redText[9].setText("beerAndPizza42");
		screen.redText[11].setText("p1nballw1zard");
		screen.redText[13].setText("MinneSolar");
		screen.redText[15].setText("geeks5geeks.org");
		screen.redText[17].setText("A* Platinum");
		screen.redText[19].setText("Player10");
		screen.redText[21].setText("Player11");
		screen.redText[23].setText("Player12");
		screen.redText[25].setText("Player13");
		screen.redText[27].setText("Player14");
		screen.redText[29].setText("Player15");
		
		screen.greenText[1].setText("BenFletcherHonda");
		screen.greenText[3].setText("ParkerGentHerDone69");
		screen.greenText[5].setText("JimStrother404");
		screen.greenText[7].setText("TESTTHELIMITSWITHALLCAPITALLET");		//Fits 30 Capital Letters
		screen.greenText[9].setText("DarkestWingDuck");
		screen.greenText[11].setText("Steven Lynch");
		screen.greenText[13].setText("PingPeng1010");
		screen.greenText[15].setText("MapWhoPlaysGuyGames");
		screen.greenText[17].setText("SaulCaller505");
		screen.greenText[19].setText("Player25");
		screen.greenText[21].setText("Player26");
		screen.greenText[23].setText("Player27");
		screen.greenText[25].setText("Player28");
		screen.greenText[27].setText("Player29");
		screen.greenText[29].setText("Player30");
		
		PlayActionScreen dew = new PlayActionScreen(screen);
	}
}
