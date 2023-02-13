// --------------------------------------------------------
// Name				: Joseph Telford
// Last Updated		: February 12, 2023 at 5:09PM
// --------------------------------------------------------
import javax.swing.*;
import java.awt.*;

public class CreateSplashScreen extends JWindow
{
	Image splashScreen;
	ImageIcon imageIcon;
	Dimension screenSize;
	
	public CreateSplashScreen()
	{
		// Gets the Image for the Splash Screen
		splashScreen = Toolkit.getDefaultToolkit().getImage("PhotonLogoSplashScreenOriginal.jpg");
		
		// Gets the Current Screen Size
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		// Gets the Width and Height of the Current Screen Size
		int resizeWidth = (int)screenSize.getWidth();
		int resizeHeight = (int)screenSize.getHeight();
		
		// Resizes / Scales the Image for the Splash Screen to the Current Screen Size
		splashScreen = splashScreen.getScaledInstance(resizeWidth, resizeHeight, splashScreen.SCALE_DEFAULT);
		
		// Creates the ImageIcon from the Image for the Splash Screen
		imageIcon = new ImageIcon(splashScreen);
		
		// Sets the Size for the JWindow from the Image Size
		setSize(imageIcon.getIconWidth(),imageIcon.getIconHeight());
		
		// Makes the JWindow Visible
		setVisible(true);
	}
	
	// Paints the Image onto the JWindow
	public void paint(Graphics g)
	{
		super.paint(g);
		g.drawImage(splashScreen, 0, 0, this);
	}
	
	// Main Method for Creating the Splash Screen
	public static void main(String[]args)
	{
		CreateSplashScreen splashScreen = new CreateSplashScreen();
		try 
		{
			// Make JWindow appear for 5 Seconds before Disappearing
			Thread.sleep(5000);
			
			// Destroys and Cleans Up JFrame Window by O.S. (Note: Line 55 may also cause Program to Terminate if no other windows are available)
			splashScreen.dispose();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}