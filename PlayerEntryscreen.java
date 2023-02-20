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

public class PlayerEntryscreen extends JFrame implements ActionListener
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
    
    public PlayerEntryscreen() {
        // Adds title to the frame
        entryFrame = new JFrame("Player Entry Terminal");
		for(int i = 0; i < 30; i++)
        {
            redTextUpdate[i] = false;
            greenTextUpdate[i] = false;
        }
		entryFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
        // Creates red team name header
        redLabelHeader = new JLabel("Red Team", SwingConstants.CENTER);
        redLabelHeader.setBounds(120, 10, 220, 37);
        redLabelHeader.setForeground(Color.RED);
        Border border = BorderFactory.createLineBorder(Color.WHITE, 1);
        redLabelHeader.setBorder(border);
        entryFrame.add(redLabelHeader);
		
        // Creates green team name header
        greenLabelHeader = new JLabel("Green Team", SwingConstants.CENTER);
        greenLabelHeader.setBounds(500, 10, 220, 37);
        greenLabelHeader.setForeground(Color.GREEN);
        Border border2 = BorderFactory.createLineBorder(Color.WHITE, 1);
        greenLabelHeader.setBorder(border2);
        entryFrame.add(greenLabelHeader);



        timer = new JLabel("30", SwingConstants.CENTER);
        timer.setBounds(800, 10, 220, 37);
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
		
        // Sets the window size
		// Next four lines added by Joseph Telford --> 2/18/2023 at 2:56PM
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int resizeWidth = (int)screenSize.getWidth();
		int resizeHeight = (int)screenSize.getHeight();
		entryFrame.setSize(resizeWidth, resizeHeight);
		
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
        int x = 67; // Initial x position
        int y = 45; // Initial y position

        for (int i = 0; i < 30; i++) {
            redText[i] = new JTextField();
            redText[i].setBounds(x, y, 140, 40);
            redText[i].setEnabled(false);

            if (i % 2 == 0) {
                x = 203;
            } else {
                x = 67;
                y += 35;
            }
            entryFrame.add(redText[i]);
        }
    }

    public void createGreenTextbox()
	{
        int x = 497; // Initial x position
        int y = 45; // Initial y position

        for (int i = 0; i < 30; i++) {
            greenText[i] = new JTextField();
            greenText[i].setBounds(x, y, 140, 40);
            greenText[i].setEnabled(false);

            if (i % 2 == 0) {
                x = 633;
            } else {
                x = 497;
                y += 35;
            }
            entryFrame.add(greenText[i]);
        }
    }

    public void createRedLabels()
	{
        int x = 30; // Initial x position
        int y = 45; // Initial y position

        for (int i = 0; i < 15; i++) {
            int number = i + 1;
            String playerNum = Integer.toString(number);
            redLabels[i] = new JLabel(playerNum);
            redLabels[i].setBounds(x, y, 40, 40);
            redLabels[i].setForeground(Color.RED);
            y += 35;

            entryFrame.add(redLabels[i]);
        }
    }

    public void createGreenLabels()
	{
        int x = 800; // Initial x position
        int y = 45; // Initial y position

        for (int i = 0; i < 15; i++) {
            int number = i + 1;
            String playerNum = Integer.toString(number);
            greenLabels[i] = new JLabel(playerNum);
            greenLabels[i].setBounds(x, y, 40, 40);
            greenLabels[i].setForeground(Color.GREEN);
            y += 35;

            entryFrame.add(greenLabels[i]);
        }
    }

    public void editButton()
	{
        // Creates edit button
        edit = new JButton("Edit Game");
        edit.setBounds(25,580,100,100);		// 90, 90 // 75, 75
        // Add action listener to edit button
        edit.addActionListener(this);
        entryFrame.add(edit);
    }

    public void startButton() {
        // Creates edit button
        start = new JButton("Start Game");
        start.setBounds(150,580,100,100);		// 90, 90 // 85, 75
        // Add action listener to edit button
        start.addActionListener(this);
        entryFrame.add(start);
    }
    
    // When button is clicked allow input in text fields
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == edit)
        {
            for (int i = 0; i < 30; i++) {
                redText[i].setEnabled(true);
                
            }
    
            for (int i = 0; i < 30; i++) {
                greenText[i].setEnabled(true);
            }
        }
       
        if (e.getSource() == start)
		{
            timerUpdate();
        }
    }
}