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

public class PlayActionScreen extends JFrame
{
	JFrame actionFrame;
	
	Dimension screenSize;
	
	public PlayActionScreen()
	{
		// Adds title to the frame
		actionFrame = new JFrame("Play Action Terminal");
		
		actionFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = (int)screenSize.getWidth();
		int screenHeight = (int)screenSize.getHeight();
		actionFrame.setSize(screenWidth, screenHeight);
		
		actionFrame.setLayout(null);
		actionFrame.setVisible(true);
		
		// Sets the windows background color to black
		actionFrame.getContentPane().setBackground(Color.BLACK);
	}
	
	// Testing the Play Action Screen
	public static void main(String[] args)
	{
		new PlayActionScreen();
	}
}
