
public class main 
{
    public static void main(String [] args) throws Exception
    {
       Database db = new Database();
       db.insertPlayer(120, "goofe");
       db.closeConnection();

    }    
}