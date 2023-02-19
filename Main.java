
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
            if(!screen.greenText[i])
            i += 2;
        }
       }
    }
}