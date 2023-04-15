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

//import java.awt.Dimension;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

import java.util.ArrayList;

public class PlayActionScreen extends JFrame
{
	private JFrame actionFrame;
	//Dimension screenSize;
	
	private static int seconds = 0;
	private static int minutes = 6;
	private static JLabel timeLabel;
	private Timer timer;
	
	private JLabel gameTrafficLabel;
	
	private JTextArea eventTextArea;
	private JScrollPane scrollPane;
	
	//private Player redTeam[];
	//private Player greenTeam[];
	
	//JLabel [] redLabels = new JLabel[15];
	//JLabel [] greenLabels = new JLabel[15];
	private JLabel labelHeader;
	
	private JLabel redLabelHeader, greenLabelHeader;
	private JLabel greenTeamScore;
	private JLabel redTeamScore;
	
	private playAudio audioFile = new playAudio();
	
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
		
		//Create team headers
		setupHeader(actionFrame, screenWidth, screenHeight, 'r', redTeam);
		setupHeader(actionFrame, screenWidth, screenHeight, 'g', greenTeam);
		
		// Creates the game timer
		timeLabel = new JLabel(String.format("%02d:%02d", minutes, seconds));
		timeLabel.setFont(new Font("Verdana", Font.PLAIN, 25));
		
		int timeLabelXPos = (screenWidth / 2) - 25;
		int timeLabelYPos = (screenHeight / 16) - 40;
		
		timeLabel.setBounds(timeLabelXPos, timeLabelYPos, 300, 40);
		timeLabel.setForeground(Color.WHITE);
		actionFrame.add(timeLabel);
		
		// Creates JLabel for Game Events
		gameTrafficLabel = new JLabel();
		
		int gameTrafficLabelXPos = ((51 * screenWidth) / 128) - 60;
		int gameTrafficLabelYPos = (screenHeight / 16);
		
		gameTrafficLabel.setBounds(gameTrafficLabelXPos, gameTrafficLabelYPos, 425, 640);
		gameTrafficLabel.setForeground(Color.WHITE);
		gameTrafficLabel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
		actionFrame.add(gameTrafficLabel);
		
		// Creates JTextArea to display Game Events and connects a JScrollPane to view all Game Events
		eventTextArea = new JTextArea("");
		eventTextArea.setEditable(false);
		eventTextArea.setLineWrap(true);
		eventTextArea.setWrapStyleWord(true);
		
		eventTextArea.setAlignmentX(Component.CENTER_ALIGNMENT);
		eventTextArea.setAlignmentY(Component.CENTER_ALIGNMENT);
		eventTextArea.setForeground(Color.WHITE);
		eventTextArea.setBackground(Color.BLACK);
		eventTextArea.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
		eventTextArea.setBounds(gameTrafficLabel.getBounds());
		eventTextArea.setFont(new Font("Verdana", Font.PLAIN, 14));
		actionFrame.add(eventTextArea);
		
		scrollPane = new JScrollPane(eventTextArea);
		scrollPane.setBounds(gameTrafficLabel.getBounds());
		scrollPane.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
		actionFrame.add(scrollPane);
		
		// Adds Players to the Team ArrayLists
		for(int i =1; i < 30; i+=2)
		{
			if(!screen.getRedText(i).equals(""))
			{
				redTeam.add(new Player(screen.getRedText(i)));
			}
			if(!screen.getGreenText(i).equals(""))
			{
				greenTeam.add(new Player(screen.getGreenText(i)));
			}
		}
		
		int redLabelXPos = (screenWidth / 55);
		int redLabelYPos = (screenHeight / 16) - 60;
		
		int greenLabelXPos = ((21 * screenWidth) / 32);
		int greenLabelYPos = (screenHeight / 16) - 60;
		
		//Adds Player Labels to the Action Screen
		for (Player player : redTeam)
		{
			JLabel redLabel = new JLabel(player.getcodeName(), SwingConstants.CENTER);
			redLabel.setBounds(redLabelXPos, redLabelYPos + 100 + (redTeamLabels.size() * 40), 250, 40);
			redLabel.setVisible(true);
			redLabel.setForeground(Color.WHITE);
			
			redLabel.setFont(new Font("Verdana", Font.PLAIN, 12));
			
			redLabel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
			redTeamLabels.add(redLabel);
			actionFrame.add(redLabel);
			
			JLabel redScore = new JLabel(Integer.toString(player.getScore()), SwingConstants.CENTER);
			redScore.setBounds(redLabelXPos + 250, redLabelYPos + 100 + (redTeamScores.size() * 40), 250, 40);
			redScore.setVisible(true);
			redScore.setForeground(Color.WHITE);
			
			redScore.setFont(new Font("Verdana", Font.BOLD, 14));
			
			redScore.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
			redTeamScores.add(redScore);
			actionFrame.add(redScore);
		}
		
		for (Player player : greenTeam)
		{
			JLabel greenLabel = new JLabel(player.getcodeName(), SwingConstants.CENTER);
			greenLabel.setBounds(greenLabelXPos, greenLabelYPos + 100 + (greenTeamLabels.size() * 40), 250, 40);
			greenLabel.setVisible(true);
			greenLabel.setForeground(Color.WHITE);
			
			greenLabel.setFont(new Font("Verdana", Font.PLAIN, 12));
			
			greenLabel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
			greenTeamLabels.add(greenLabel);
			actionFrame.add(greenLabel);
			
			
			JLabel greenScore = new JLabel(Integer.toString(player.getScore()), SwingConstants.CENTER);
			greenScore.setBounds(greenLabelXPos + 250, greenLabelYPos + 100 + (greenTeamScores.size() * 40), 250, 40);
			greenScore.setVisible(true);
			greenScore.setForeground(Color.WHITE);
			
			greenScore.setFont(new Font("Verdana", Font.BOLD, 14));
			
			greenScore.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
			greenTeamScores.add(greenScore);
			actionFrame.add(greenScore);
		}
		
		//Add player lables to the PlayActionScreen
		actionFrame.setLayout(null);
		actionFrame.setVisible(true);
		
		// Sets the windows background color to black
		actionFrame.getContentPane().setBackground(Color.BLACK);
		
		gameTimer();
		
		playAudioTrack();
		
		UDPServer();
	}

	public void UDPServer()
	{
		// Step 1 : Create a socket to listen at port 7501
		try
		{
			DatagramSocket UDPServerSocket = new DatagramSocket(7501);
			System.out.println("UDP Server up and listening");
			
			byte[] receive = new byte[1024];
			DatagramPacket DataPacketReceive = null;
			
			int numEvents = 0;
			
			while (true)
			{
				// DatagramPacket to receive the data.
				DataPacketReceive = new DatagramPacket(receive, receive.length);
				
				// Receive the data in byte buffer.
				UDPServerSocket.receive(DataPacketReceive);
				String sentence = new String(DataPacketReceive.getData(), 0, DataPacketReceive.getLength());
				sentence = sentence + "\n";
				
				// Debug Statement
				//System.out.println(sentence);
				
				appendText(sentence);
				eventTextArea.paintImmediately(eventTextArea.getVisibleRect());
				
				updatePlayerScore(sentence);
				
				// Debug Statement
				//System.out.println("Sentence Printed!");
				
				numEvents += 1;
				
				if (numEvents == receive.length)
				{
					break;
				}
				if (audioFile.playCompleted == true)
				{
					UDPServerSocket.close();
					break;
				}
				
			}
		}
		catch (SocketException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	private void updatePlayerScore(String sentence)
	{
		String[] words = sentence.split("\\s+");
		String playerName = words[0];
		
		for (Player player : redTeam)
		{
			if (player.getcodeName().equals(playerName))
			{
				player.incrementScore(10);
				
				int redScore = cumulativeTeamScore(redTeam);
				
				redTeamScore.setText(Integer.toString(redScore));
				return;
			}
		}
		
		for (Player player : greenTeam)
		{
			if (player.getcodeName().equals(playerName))
			{
				player.incrementScore(10);
				
				int greenScore = cumulativeTeamScore(greenTeam);
				
				greenTeamScore.setText(Integer.toString(greenScore));
				return;
			}
		}
	}

	private void flashScore(JLabel label) throws InterruptedException
	{
		Color originalColor = label.getForeground();
		Color flashColor = Color.WHITE;
		int flashDuration = 300; // in milliseconds
		
		Timer timer = new Timer(flashDuration, new ActionListener()
		{
			private boolean flash = false;
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				flash = !flash;
				label.setForeground(flash ? flashColor : originalColor);
				
				if (!flash)
				{
					((Timer) e.getSource()).stop();
				}
			}
		});
		
		timer.start();
	}

	private int cumulativeTeamScore(ArrayList<Player> team)
	{
		int cumScore = 0;
		if(team != null)
		{
			for(int i = 0; i < team.size(); i++)
			{
				cumScore += team.get(i).getScore();
			}
		}
		
		// Debug Statements
		//System.out.println("Cumulative Score for : " + cumScore);
		
		return cumScore;
	}
	
	// From Joseph: Do not remove this method
	private void appendText(String text)
	{
		eventTextArea.append(text + "\n");
	}

	//Create team headers
	private void setupHeader(JFrame actionFrame, int screenWidth, int screenHeight, char color, ArrayList<Player> team)
	{
		String teamName = "";
		Color headerColor = null;
		int labelXPos = 0;
		int labelYPos = (screenHeight / 16) - 40;
		int width = 500;
		int height = 40;
		
		if(color == 'r')
		{
			teamName = "Red Team";
			headerColor = Color.RED;
			labelXPos = (screenWidth / 55);
			
			// From Joseph: These lines of code for Team Score work. Do not remove...?
			int score = cumulativeTeamScore(team);
			redTeamScore = new JLabel(Integer.toString(score), SwingConstants.CENTER);
			redTeamScore.setBounds(labelXPos, labelYPos + 40, width, height);
			redTeamScore.setForeground(headerColor);
			
			redTeamScore.setFont(new Font("Verdana", Font.BOLD, 30));
			Border border = BorderFactory.createLineBorder(Color.WHITE, 1);
			
			redTeamScore.setBorder(border);
			actionFrame.add(redTeamScore);
			
		}
		if(color == 'g')
		{
			teamName = "Green Team";
			headerColor = Color.GREEN;
			labelXPos = ((21 * screenWidth) / 32);
			
			// From Joseph: These lines of code for Team Score work. Do not remove...?
			int score = cumulativeTeamScore(team);
			greenTeamScore = new JLabel(Integer.toString(score), SwingConstants.CENTER);
			greenTeamScore.setBounds(labelXPos, labelYPos + 40, width, height);
			greenTeamScore.setForeground(headerColor);
			
			greenTeamScore.setFont(new Font("Verdana", Font.BOLD, 30));
			Border border = BorderFactory.createLineBorder(Color.WHITE, 1);
			
			greenTeamScore.setBorder(border);
			actionFrame.add(greenTeamScore);
			
		}

		//Display team names
		labelHeader = new JLabel(teamName, SwingConstants.CENTER);
		labelHeader.setBounds(labelXPos, labelYPos, width, height);
		labelHeader.setForeground(headerColor);
		
		labelHeader.setFont(new Font("Verdana", Font.BOLD, 20));
		
		Border border = BorderFactory.createLineBorder(Color.WHITE, 1);
		labelHeader.setBorder(border);
		actionFrame.add(labelHeader);
		
		// //Display team scores
		// int score = cumulativeTeamScore(team);
		// scoreDisplay = new JLabel(Integer.toString(score), SwingConstants.CENTER);
		// scoreDisplay.setBounds(labelXPos, labelYPos + 40, width, height);
		// scoreDisplay.setForeground(headerColor);
		
		// scoreDisplay.setFont(new Font("Verdana", Font.BOLD, 30));
		
		// scoreDisplay.setBorder(border);
		// actionFrame.add(scoreDisplay);
	}

	public void gameTimer()
	{
		long startTime = System.currentTimeMillis(); // get the start time
		
		// Creates the timer to update the display
		timer = new Timer(1000, new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					// Calculate the elapsed time in seconds
					long elapsedTime = (System.currentTimeMillis() - startTime) / 1000;
					long remainingTime = 360 - elapsedTime;
					
					// Decrement the seconds and minutes
					seconds = (int) remainingTime % 60;
					minutes = (int) remainingTime / 60;
					
					updatePlayers();
					
					// New If-Else Below:
					if(cumulativeTeamScore(redTeam) > cumulativeTeamScore(greenTeam))
					{
						flashScore(redTeamScore);
					}
					else if(cumulativeTeamScore(redTeam) < cumulativeTeamScore(greenTeam))
					{
						flashScore(greenTeamScore);
					}
					else
					{
					}
					
					// Checks if minutes and seconds are zero
					if (remainingTime <= 0)
					{
						// Stops the timer if minutes and seconds are zero
						timer.stop();
						
						// Stops the audio file once the timer reaches zero
						audioFile.playCompleted = true;
						audioFile.stop();
					}
					// Sets the text for the game timer
					timeLabel.setText(String.format("%02d:%02d", minutes, seconds));
					}
				catch (InterruptedException exception)
				{
					exception.printStackTrace();
				}
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
		audioFile.play(audioFilePath);
	}


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


	public void printPlayers()
	{
		for(Player player : redTeam)
		{
			System.out.println(player);
		}
		for(Player player : greenTeam)
		{
			System.out.println(player);
		}
	}


	// //Testing the Play Action Screen
	public static void main(String[] args)
	{
		// Hard-Coded Test Cases for Play Action Screen and Player Entry Screen
		PlayerEntryScreen screen = new PlayerEntryScreen();
		
		screen.setRedText(1, "AlexPrill999");
		screen.setRedText(3, "AndrewMurphster420");
		screen.setRedText(5, "SirJoseph167");
		screen.setRedText(7, "testlimitsinalllowercaseletter");		// Fits 30 lowercase letter
		// screen.redText[9].setText("Player5");
		// screen.redText[11].setText("Player6");
		// screen.redText[13].setText("Player7");
		// screen.redText[15].setText("Player8");
		// screen.redText[17].setText("Player9");
		// screen.redText[19].setText("Player10");
		// screen.redText[21].setText("Player11");
		// screen.redText[23].setText("Player12");
		// screen.redText[25].setText("Player13");
		// screen.redText[27].setText("Player14");
		// screen.redText[29].setText("Player15");
		
		screen.setGreenText(1, "BenFletcherHonda");
		screen.setGreenText(3, "ParkerGentHerDone69");
		screen.setGreenText(5, "JimStrother404");
		screen.setGreenText(7, "TESTTHELIMITSWITHALLCAPITALLET");		//Fits 30 Capital Letters
		// screen.greenText[9].setText("Player20");
		// screen.greenText[11].setText("Player21");
		// screen.greenText[13].setText("Player22");
		// screen.greenText[15].setText("Player23");
		// screen.greenText[17].setText("Player24");
		// screen.greenText[19].setText("Player25");
		// screen.greenText[21].setText("Player26");
		// screen.greenText[23].setText("Player27");
		// screen.greenText[25].setText("Player28");
		// screen.greenText[27].setText("Player29");
		// screen.greenText[29].setText("Player30");
		
		PlayActionScreen actionScreen = new PlayActionScreen(screen);
	}
}