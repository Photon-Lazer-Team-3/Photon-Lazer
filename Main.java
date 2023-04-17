import java.util.concurrent.TimeUnit;

public class Main 
{
    //This is a test
    public static void main(String [] args) throws Exception
    {
       CreateSplashScreen splashScreen = new CreateSplashScreen();
		try 
		{
			// Make JWindow appear for 5 Seconds before Disappearing
			// EDIT: Make JFrame appear for 3 seconds before Disappearing
			Thread.sleep(3000);
			
			// Destroys and Cleans Up JFrame Window by O.S. (Note: Line 55 may also cause Program to Terminate if no other windows are available)
			splashScreen.dispose();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
        //Database db = new Database();



        
       PlayerEntryScreen screen = new PlayerEntryScreen();
       boolean something = true;
       while(something)
       {
        screen.update();
        something = screen.getInUse();
        System.out.println(something);
       }
       PlayActionScreen action = new PlayActionScreen(screen);
      
    }
}
