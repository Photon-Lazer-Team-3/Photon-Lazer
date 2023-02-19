
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
            String str = screen.greenText[i].getText();
            if(!screen.greenText[i].getText().equals(""))
            {
                System.out.println("ID found");
                if(db.idExist(Integer.parseInt(screen.greenText[i].getText())))
                {
                    System.out.println("ID is in database");
                    screen.greenText[i+1].setText(db.getCodeName(Integer.parseInt(screen.greenText[i].getText())));
                }
            }
            i += 2;
        }
       }
    }
}