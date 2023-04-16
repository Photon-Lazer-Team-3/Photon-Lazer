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
	private JFrame entryFrame;
	private ModifiedTextField [] redText = new ModifiedTextField[30];
	private ModifiedTextField [] greenText = new ModifiedTextField[30];
	private boolean [] greenTextUpdate = new boolean[30];
	private boolean [] redTextUpdate = new boolean[30];
	
	private JLabel [] redLabels = new JLabel[15];
	private JLabel [] greenLabels = new JLabel[15];
	private JLabel redLabelHeader, greenLabelHeader, timer;
	
	private JButton edit, start;

	
	// Added by Joseph Telford --> 2/18/2023 at 2:56PM
	private Dimension screenSize;
	Database db;
	
	public PlayerEntryScreen() throws Exception
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

		redLabelHeader = new JLabel("Red Team", SwingConstants.CENTER);
		greenLabelHeader = new JLabel("Green Team", SwingConstants.CENTER);

		int redLabelXPos = (screenWidth / 8);
		int greenLabelXPos = ((11 * screenWidth) / 16);
		int labelYPos = (screenHeight / 16) - 40;
		
		createTeamHeader(redLabelHeader, redLabelXPos, labelYPos, Color.RED);
		createTeamHeader(greenLabelHeader, greenLabelXPos, labelYPos, Color.GREEN);
		
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
		
		createTextBox(redText, redLabelXPos);
		createTextBox(greenText, greenLabelXPos);

		createLabels(redLabels, redLabelXPos - 35, Color.RED);
		createLabels(greenLabels, greenLabelXPos + 315, Color.GREEN);
		
		// Adds edit button
		editButton();
		
		// Adds start button
		startButton();
		
		//entryFrame.setSize(900,850);
		entryFrame.setLayout(null);
		entryFrame.setVisible(true);
		
		// Sets the windows background color to black
		entryFrame.getContentPane().setBackground(Color.BLACK);
		

		db = new Database();
	}

	public void createTeamHeader(JLabel labelHeader, int labelXPos, int labelYPos, Color labelColor) {
		labelHeader.setBounds(labelXPos, labelYPos, 280, 40);
		labelHeader.setForeground(labelColor);
		Border border = BorderFactory.createLineBorder(Color.WHITE, 1);
		labelHeader.setBorder(border);
		entryFrame.add(labelHeader);
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
			timer.setText(String.valueOf(2 - elapsedSeconds));
			timer.paintImmediately(timer.getVisibleRect());
			if(elapsedSeconds == 2)
			{
				entryFrame.setVisible(false);
				return;
			}
		}
	}

	public void createTextBox(ModifiedTextField [] playerText, int playerXPos) {
		// Added by Joseph Telford
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenHeight = (int)screenSize.getHeight();
		// Updated by Joseph Telford
		int x = playerXPos; // Initial x position
		int y = screenHeight / 16; // Initial y position
		
		for (int i = 0; i < 30; i++)
		{
			playerText[i] = new ModifiedTextField(i);
			//lksdjfklsdfj
			playerText[i].setBounds(x, y, 140, 40);
			playerText[i].setEnabled(false);

			if (i % 2 == 0) {
				x += 140;
			}
			else {
				x = playerXPos;
				y += 40;
			}
			entryFrame.add(playerText[i]);
		}
	}

	public void createLabels(JLabel [] teamLabels, int playerXPos, Color teamColor) {
		// Added by Joseph Telford
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = (int)screenSize.getWidth();
		int screenHeight = (int)screenSize.getHeight();
		// Updated by Joseph Telford
		int x = playerXPos; // Initial x position
		int y = screenHeight / 16; // Initial y position
		
		for (int i = 0; i < 15; i++) {
			int number = i + 1;
			String playerNum = Integer.toString(number);
			teamLabels[i] = new JLabel(playerNum);
			teamLabels[i].setBounds(x, y, 15, 40);
			teamLabels[i].setForeground(teamColor);
			y += 40;
			entryFrame.add(teamLabels[i]);
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

	//This will go over everything and check for updates and do other things
	public void update() throws NumberFormatException, SQLException
	{
		for(int i = 0; i < 30; i+=2)
		{
			if(redText[i].isUpdated())
			{
				if(db.idExist(Integer.parseInt(redText[i].getText())))
					{
						redText[i+1].setText(db.getCodeName(Integer.parseInt(redText[i].getText())));
					}
					else
					{
						if(redText[i+1].isUpdated())
						{
							db.insertPlayer(Integer.parseInt(redText[i].getText()), redText[i+1].getText());
						}
					}
			}
		}
		for(int i = 0; i < 30; i+=2)
		{
			if(greenText[i].isUpdated())
			{
				if(db.idExist(Integer.parseInt(greenText[i].getText())))
					{
						greenText[i+1].setText(db.getCodeName(Integer.parseInt(greenText[i].getText())));
					}
					else
					{
						if(greenText[i+1].isUpdated())
						{
							db.insertPlayer(Integer.parseInt(greenText[i].getText()), greenText[i+1].getText());
						}
					}
			}
		}
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
			//PlayActionScreen actionScreen = new PlayActionScreen(this);
			//actionScreen.setVisible(true);
			entryFrame.dispose();
		}
	}
	public String getGreenText(int i)
	{
		return greenText[i].getText();
	}
	public String getRedText(int i)
	{
		return redText[i].getText();
	}

	public void setRedText(int i, String text)
	{
		this.redText[i].setText(text);
	}

	public void setGreenText(int i, String text)
	{
		this.greenText[i].setText(text);
	}

	
	
	// Testing the Player Entry Screen
	public static void main(String[] args) throws Exception
	{
		PlayerEntryScreen screen = new PlayerEntryScreen();

		while(true)
		{
			screen.update();
		}
	}
}