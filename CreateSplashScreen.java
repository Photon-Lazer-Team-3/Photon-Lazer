// --------------------------------------------------------
// Name				: Joseph Telford
// Last Updated		: February 12, 2023 at 5:09PM
// --------------------------------------------------------
import javax.swing.*;
import java.awt.*;

public class CreateSplashScreen extends JFrame //JWindow // EDIT on 2/19/23 at 10:35PM : Made into a JFrame instead of JWindow
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
		
		// Sets the Size for the JFrame from the Image Size
		setSize(imageIcon.getIconWidth(),imageIcon.getIconHeight());
		
		// Makes the JFrame Visible
		setVisible(true);
	}
	
	// Paints the Image onto the JFrame
	public void paint(Graphics g)
	{
		super.paint(g);
		g.drawImage(splashScreen, 0, 0, this);
	}
	
}
