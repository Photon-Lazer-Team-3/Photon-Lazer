
public class main 
{
    public static void main(String [] args) throws Exception
    {
       Database db = new Database();
       db.insertPlayer(2000, "y2k");
       db.insertPlayer(3000, "y3k");

       db.closeConnection();

    }    
}