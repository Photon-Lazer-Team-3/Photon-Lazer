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
       //sdfasfsdf
       /* 
       //sdlkfjsdlkfjsdlk
       while(true)
       {
        int i = 0;
        while(i < 30)
        {
            if(!screen.greenText[i].getText().equals(""))
            {
                if(db.idExist(Integer.parseInt(screen.greenText[i].getText())))
                {
                    screen.greenText[i+1].setText(db.getCodeName(Integer.parseInt(screen.greenText[i].getText())));
                }
            }
            if(!screen.greenText[i].getText().equals("") && !screen.greenText[i+1].getText().equals("") && !db.idExist(Integer.parseInt(screen.greenText[i].getText())))
            {
                db.insertPlayer(Integer.parseInt(screen.greenText[i].getText()), screen.greenText[i+1].getText());
            }
            if(!screen.redText[i].getText().equals(""))
            {
                if(db.idExist(Integer.parseInt(screen.redText[i].getText())))
                {
                    screen.redText[i+1].setText(db.getCodeName(Integer.parseInt(screen.redText[i].getText())));
                }
            }
            if(!screen.redText[i].getText().equals("") && !screen.redText[i+1].getText().equals("") && !db.idExist(Integer.parseInt(screen.redText[i].getText())))
            {
                db.insertPlayer(Integer.parseInt(screen.redText[i].getText()), screen.redText[i+1].getText());
            }
            TimeUnit.MILLISECONDS.sleep(500);
            //Thread.sleep(250);
            i += 2;
        }
       }
       */
    }
}
