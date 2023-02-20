import java.util.concurrent.TimeUnit;

public class Main 
{
    public static void main(String [] args) throws Exception
    {
       Database db = new Database();




       PlayerEntryscreen screen = new PlayerEntryscreen(); 
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
    }
}
