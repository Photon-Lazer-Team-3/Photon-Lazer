
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
	
	private JLabel [] redLabels = new JLabel[15];
	private JLabel [] greenLabels = new JLabel[15];
	private JLabel redLabelHeader, greenLabelHeader, timer;
	
	private JButton edit, start;
	
	Dimension screenSize;
	Database db;
	
	public PlayerEntryScreen() throws Exception
	{
		// Adds title to the frame
		entryFrame = new JFrame("Player Entry Terminal");
		

		
		entryFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		// Sets the window size
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = (int)screenSize.getWidth();
		int screenHeight = (int)screenSize.getHeight();
		entryFrame.setSize(screenWidth, screenHeight);
		
		// Creates red team name header
		redLabelHeader = new JLabel("Red Team", SwingConstants.CENTER);
		
		int redLabelXPos = (screenWidth / 32) + 35;		//(screenWidth / 8);
		int redLabelYPos = (screenHeight / 16) - 40;
		
		redLabelHeader.setBounds(redLabelXPos, redLabelYPos, 460, 40);		// 280, 40);
		redLabelHeader.setForeground(Color.RED);
		redLabelHeader.setFont(new Font("Verdana", Font.BOLD, 20));
		Border border = BorderFactory.createLineBorder(Color.WHITE, 1);
		redLabelHeader.setBorder(border);
		entryFrame.add(redLabelHeader);
		
		// Creates green team name header
		greenLabelHeader = new JLabel("Green Team", SwingConstants.CENTER);
		
		int greenLabelXPos = ((82 * screenWidth) / 128);							//((11 * screenWidth) / 16);
		int greenLabelYPos = (screenHeight / 16) - 40;
		
		greenLabelHeader.setBounds(greenLabelXPos, greenLabelYPos, 460, 40);		// 220, 37
		greenLabelHeader.setForeground(Color.GREEN);
		greenLabelHeader.setFont(new Font("Verdana", Font.BOLD, 20));
		Border border2 = BorderFactory.createLineBorder(Color.WHITE, 1);
		greenLabelHeader.setBorder(border2);
		entryFrame.add(greenLabelHeader);
		
		// Creates timer header
		timer = new JLabel("30", SwingConstants.CENTER);
		
		int timerXPos = (screenWidth / 2) - 25;
		int timerYPos = (screenHeight / 16) - 40;
		
		timer.setFont(new Font("Verdana", Font.PLAIN, 25));
		
		timer.setBounds(timerXPos, timerYPos, 40, 40); //220, 37
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

		db = new Database();
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
			if(elapsedSeconds == 5)
				new PlayActionScreen(this);
		}
	}
	
	public void createRedTextbox()
	{
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = (int)screenSize.getWidth();
		int screenHeight = (int)screenSize.getHeight();
		
		int x = (screenWidth / 32) + 35;		//screenWidth / 8; //((3 * screenWidth) / 4); // Initial x position
		int y = screenHeight / 16;				//(screenHeight / 4); // Initial y position
		
		for (int i = 0; i < 30; i++)
		{
			redText[i] = new ModifiedTextField();
			redText[i].setBounds(x, y, 230, 40);	// 140, 40);
			redText[i].setEnabled(false);
			
			if (i % 2 == 0)
			{
				x = ((screenWidth / 32) + 35) + 230;	// + 140;
			} else
			{
				x = ((screenWidth / 32) + 35);
				y += 40;
			}
			entryFrame.add(redText[i]);
		}
	}
	
	public void createGreenTextbox()
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = (int)screenSize.getWidth();
		int screenHeight = (int)screenSize.getHeight();
		
		int x = ((82 * screenWidth) / 128); 			// Initial x position
		int y = screenHeight / 16;						// Initial y position
		
		for (int i = 0; i < 30; i++)
		{
			greenText[i] = new ModifiedTextField();
			greenText[i].setBounds(x, y, 230, 40);			//140, 40);
			greenText[i].setEnabled(false);
			
			if (i % 2 == 0)
			{
				x = ((82 * screenWidth) / 128) + 230;		//((11 * screenWidth) / 16) + 140;
			} else
			{
				x = ((82 * screenWidth) / 128);		//(11 * screenWidth) / 16;
				y += 40;									//35;	// 35 WAS CAUSING THE WEIRD OVERLAP!!!
			}
			entryFrame.add(greenText[i]);
		}
	}
	
	// Creates Numbers 1 - 15 for Red Team
	public void createRedLabels()
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = (int)screenSize.getWidth();
		int screenHeight = (int)screenSize.getHeight();
		
		int x = (screenWidth / 32); //(screenWidth / 8) - 35; // Initial x position
		int y = screenHeight / 16; // Initial y position
		
		for (int i = 0; i < 15; i++)
		{
			int number = i + 1;
			String playerNum = Integer.toString(number);
			redLabels[i] = new JLabel(playerNum, SwingConstants.CENTER);
			redLabels[i].setBounds(x, y, 20, 40);
			redLabels[i].setForeground(Color.RED);
			redLabels[i].setFont(new Font("Verdana", Font.BOLD, 12));
			y += 40;
			entryFrame.add(redLabels[i]);
		}
	}
	
	// Creates Numbers 1 - 15 for Green Team
	public void createGreenLabels()
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = (int)screenSize.getWidth();
		int screenHeight = (int)screenSize.getHeight();
		
		int x = ((122 * screenWidth) / 128);			//((31 * screenWidth) / 32) - 20;	// Initial x position
		int y = (screenHeight / 16);			// Initial y position
		
		for (int i = 0; i < 15; i++)
		{
			int number = i + 1;
			String playerNum = Integer.toString(number);
			greenLabels[i] = new JLabel(playerNum, SwingConstants.CENTER);
			greenLabels[i].setBounds(x, y, 20, 40);
			greenLabels[i].setForeground(Color.GREEN);
			greenLabels[i].setFont(new Font("Verdana", Font.BOLD, 12));
			y += 40;
			entryFrame.add(greenLabels[i]);
		}
	}
	
	public void editButton()
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = (int)screenSize.getWidth();
		int screenHeight = (int)screenSize.getHeight();
		
		int editButtonXPos = (screenWidth / 2) - 50 - 75;
		int editButtonYPos = ((25 * screenHeight) / 32);
		
		// Creates edit button
		edit = new JButton("Edit Game");
		edit.setBounds(editButtonXPos,editButtonYPos,100,100);		// 90, 90 // 75, 75
		// Add action listener to edit button
		edit.addActionListener(this);
		entryFrame.add(edit);
	}
	
	public void startButton()
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = (int)screenSize.getWidth();
		int screenHeight = (int)screenSize.getHeight();
		
		int startButtonXPos = (screenWidth / 2) - 50 + 75;
		int startButtonYPos = ((25 * screenHeight) / 32);
		
		//int timerXPos = (screenWidth / 2) - 25;
		//int timerYPos = (screenHeight / 16) - 40;
		
		// Creates edit button
		start = new JButton("Start Game");
		start.setBounds(startButtonXPos,startButtonYPos,100,100);		// 90, 90 // 85, 75
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


	public void update() throws NumberFormatException, SQLException
	{
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
	
	
	public static void main(String [] args) throws Exception
	{
		PlayerEntryScreen screen = new PlayerEntryScreen();
		while(true)
		{
			screen.update();
		}
	}
}




