import java.net.URI;
import java.net.URISyntaxException;
import java.sql.*;
public class Database {

    private Connection connection;
    private final int id = 1;
    private final int codeName = 4;
    private static final String URL = "";

    

    public Database()
    {
        Connection connection = getConnection();

    }

    private static Connection getConnection() throws URISyntaxException, SQLException
    {
        URI dburi = new URI(System.getenv(URL));

        String userName = dburi.getUserInfo().split(":")[0];
        String password = dburi.getUserInfo().split(":")[1];
        String dburl = "jdbc:postgresql://" + dburi.getHost() + dburi.getPath();

        return DriverManager.getConnection(dburl, userName, password);
    }

    //Gets the userName from the table of players from a given id
    public String getCodeName(int id)
    {
        String userName = "";
        Statement stmt = connection.createStatement();
        //Why does it not like this thing here it should like it and I don't know why it does not
        ResultSet result = stmt.executeQuery("SELECT * FROM PLAYER WHERE ID " + id);
        //
        //If the query returns us a value then we
        if(!result.wasNull())
        {
            return result.get(codeName);
        }
        else
        {
            return null;
        }
    }

    //Adds a new player to the table with unique id and own code Name
    public void addCodeName(int id, String codeName)
    {

    }

    public boolean idExist(int id)
    {
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("SELECT * FROM PLAYER WHERE ID " + id);
        if(result.get(1) == null)
        {
            return false;
        }
        if(result.get(1) == id)
        {
            return true;
        }
    }

    public void printPlayers()
    {
        Statement stmt = connection.createStatement();
        ResultSet result = stmt.executeQuery("SELECT * FROM PLAYER");
        while(result.next())
        {
            System.out.println("ID: " + result.get(id) + ", code name: " + result.get(codeName));
        }

        stmt.close();
        result.close();
    }

    
}
