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
//import javax.swing.*;

public class PlayerEntryScreen extends JFrame implements ActionListener
{
	JFrame entryFrame;
	JTextField [] redText = new JTextField[30];
	JTextField [] greenText = new JTextField[30];
	boolean [] greenTextUpdate = new boolean[30];
	boolean [] redTextUpdate = new boolean[30];
	
	JLabel [] redLabels = new JLabel[15];
	JLabel [] greenLabels = new JLabel[15];
	JLabel redLabelHeader, greenLabelHeader, timer;
	
	JButton edit, start;

	
	// Added by Joseph Telford --> 2/18/2023 at 2:56PM
	Dimension screenSize;
	
	public PlayerEntryScreen()
	{
		// Adds title to the frame
		entryFrame = new JFrame("Player Entry Terminal");
		for(int i = 0; i < 30; i++)
		{
			redTextUpdate[i] = false;
			greenTextUpdate[i] = false;
		}
		
		entryFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		// Sets the window size
		// Next four lines added by Joseph Telford --> 2/18/2023 at 2:56PM
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = (int)screenSize.getWidth();
		int screenHeight = (int)screenSize.getHeight();
		entryFrame.setSize(screenWidth, screenHeight);
		
		// Creates red team name header
		redLabelHeader = new JLabel("Red Team", SwingConstants.CENTER);
		
		int redLabelXPos = (screenWidth / 8);
		int redLabelYPos = (screenHeight / 16) - 40;
		
		redLabelHeader.setBounds(redLabelXPos, redLabelYPos, 280, 40);
		redLabelHeader.setForeground(Color.RED);
		Border border = BorderFactory.createLineBorder(Color.WHITE, 1);
		redLabelHeader.setBorder(border);
		entryFrame.add(redLabelHeader);
		
		// Creates green team name header
		greenLabelHeader = new JLabel("Green Team", SwingConstants.CENTER);
		
		int greenLabelXPos = ((11 * screenWidth) / 16);
		int greenLabelYPos = (screenHeight / 16) - 40;
		
		greenLabelHeader.setBounds(greenLabelXPos, greenLabelYPos, 280, 40);
		greenLabelHeader.setForeground(Color.GREEN);
		Border border2 = BorderFactory.createLineBorder(Color.WHITE, 1);
		greenLabelHeader.setBorder(border2);
		entryFrame.add(greenLabelHeader);
		
		// Creates timer header
		timer = new JLabel("30", SwingConstants.CENTER);
		
		int timerXPos = (screenWidth / 2) - 25;
		int timerYPos = (screenHeight / 16) - 40;
		
		timer.setFont(new Font("Verdana", Font.PLAIN, 25));
		
		timer.setBounds(timerXPos, timerYPos, 40, 40);
		timer.setForeground(Color.WHITE);
		Border border3 = BorderFactory.createLineBorder(Color.WHITE, 1);
		greenLabelHeader.setBorder(border3);
		entryFrame.add(timer);
		
		// Creates and adds red team textboxes
		createRedTextbox();
		
		// Creates and adds red team labels
		createRedLabels();
		
		// Creates and adds green team textboxes
		createGreenTextbox();
		
		// Creates and adds green team labels
		createGreenLabels();
		
		// Adds edit button
		editButton();
		
		// Adds start button
		startButton();
		
		//entryFrame.setSize(900,850);
		entryFrame.setLayout(null);
		entryFrame.setVisible(true);
		
		// Sets the windows background color to black
		entryFrame.getContentPane().setBackground(Color.BLACK);
		int i = 1;
	}

	public void timerUpdate()
	{
		long startTime = System.currentTimeMillis();
		while(true)
		{
			long elapsedTime = System.currentTimeMillis() - startTime;
			long elapsedSeconds = elapsedTime / 1000;
			long secondsDisplay = elapsedSeconds % 60;
			long elapsedMinutes = elapsedSeconds / 60;
			timer.setText(String.valueOf(30 - elapsedSeconds));
			timer.paintImmediately(timer.getVisibleRect());
			if(elapsedSeconds == 30)
				System.exit(0);
		}
	}

	public void createRedTextbox()
	{
		// Added by Joseph Telford
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = (int)screenSize.getWidth();
		int screenHeight = (int)screenSize.getHeight();
		// Updated by Joseph Telford
		int x = screenWidth / 8; // Initial x position
		int y = screenHeight / 16; // Initial y position
		
		for (int i = 0; i < 30; i++)
		{
			redText[i] = new JTextField();
			redText[i].setBounds(x, y, 140, 40);
			redText[i].setEnabled(false);

			if (i % 2 == 0)
			{
				x = (screenWidth / 8) + 140;
			}
			else
			{
				x = screenWidth / 8;
				y += 40;
			}
			entryFrame.add(redText[i]);
		}
	}

	public void createGreenTextbox()
	{
		// Added by Joseph Telford
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = (int)screenSize.getWidth();
		int screenHeight = (int)screenSize.getHeight();
		// Updated by Joseph Telford
		int x = (11 * screenWidth) / 16; // Initial x position
		int y = screenHeight / 16; // Initial y position
		
		for (int i = 0; i < 30; i++)
		{
			greenText[i] = new JTextField();
			greenText[i].setBounds(x, y, 140, 40);
			greenText[i].setEnabled(false);

			if (i % 2 == 0)
			{
				x = ((11 * screenWidth) / 16) + 140;
			}
			else
			{
				x = (11 * screenWidth) / 16;
				y += 40;						// y += 35 was causing overlap issue on Windows
			}
			entryFrame.add(greenText[i]);
		}
	}

	public void createRedLabels()
	{
		// Added by Joseph Telford
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = (int)screenSize.getWidth();
		int screenHeight = (int)screenSize.getHeight();
		// Updated by Joseph Telford
		int x = (screenWidth / 8) - 35; // Initial x position
		int y = screenHeight / 16; // Initial y position
		
		for (int i = 0; i < 15; i++)
		{
			int number = i + 1;
			String playerNum = Integer.toString(number);
			redLabels[i] = new JLabel(playerNum);
			redLabels[i].setBounds(x, y, 15, 40);
			redLabels[i].setForeground(Color.RED);
			y += 40;
			entryFrame.add(redLabels[i]);
		}
	}

	public void createGreenLabels()
	{
		// Added by Joseph Telford
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = (int)screenSize.getWidth();
		int screenHeight = (int)screenSize.getHeight();
		// Updated by Joseph Telford
		int x = ((11 * screenWidth) / 16) + 315; // Initial x position
		int y = screenHeight / 16; // Initial y position
		
		for (int i = 0; i < 15; i++)
		{
			int number = i + 1;
			String playerNum = Integer.toString(number);
			greenLabels[i] = new JLabel(playerNum);
			greenLabels[i].setBounds(x, y, 15, 40);
			greenLabels[i].setForeground(Color.GREEN);
			y += 40;
			entryFrame.add(greenLabels[i]);
		}
	}

	public void editButton()
	{
		// Added by Joseph Telford
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = (int)screenSize.getWidth();
		int screenHeight = (int)screenSize.getHeight();
		// Updated by Joseph Telford
		int editButtonXPos = (screenWidth / 2) - 50 - 75;
		int editButtonYPos = ((25 * screenHeight) / 32);
		
		// Creates edit button
		edit = new JButton("Edit Game");
		edit.setBounds(editButtonXPos,editButtonYPos,100,100);
		// Add action listener to edit button
		edit.addActionListener(this);
		entryFrame.add(edit);
	}

	public void startButton()
	{
		// Added by Joseph Telford
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = (int)screenSize.getWidth();
		int screenHeight = (int)screenSize.getHeight();
		// Updated by Joseph Telford
		int startButtonXPos = (screenWidth / 2) - 50 + 75;
		int startButtonYPos = ((25 * screenHeight) / 32);
		
		// Creates edit button
		start = new JButton("Start Game");
		start.setBounds(startButtonXPos,startButtonYPos,100,100);
		// Add action listener to edit button
		start.addActionListener(this);
		entryFrame.add(start);
	}

	// When button is clicked allow input in text fields
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == edit)
		{
			for (int i = 0; i < 30; i++)
			{
				redText[i].setEnabled(true);
			}
			
			for (int i = 0; i < 30; i++)
			{
				greenText[i].setEnabled(true);
			}
		}
	   
		if (e.getSource() == start)
		{
			timerUpdate();
		}
	}
	
	// // Testing the Player Entry Screen
	// public static void main(String[] args)
	// {
		// new PlayerEntryScreen();
	// }
}
