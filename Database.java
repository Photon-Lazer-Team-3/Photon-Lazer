import java.net.URI;
import java.net.URISyntaxException;
import java.sql.*;

public class Database
{

    private Connection connection;
    private static final String URL = "";


    //Is there anything else that we could need now for this all to work that I can think of no

    

    public Database() throws Exception
    {
        connection = getConnection();

    }

    public void closeConnection() throws Exception
    {
        connection.close();
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
    public String getCodeName(int id) throws SQLException
    {
        Statement stmt = connection.createStatement();
        //Why does it not like this thing here it should like it and I don't know why it does not
        ResultSet result = stmt.executeQuery("SELECT * FROM PLAYER WHERE ID " + id);
        //
        //If the query returns us a value then we
        if(result.getString("codename") == null)
        {
            //Hopefully this here we cna fix sooner than latter this should be fun to finish up
            return result.getString("codename");
        }
        else
        {
            return null;
        }
    }

    public boolean idExist(int id) throws SQLException
    {
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("SELECT * FROM PLAYER WHERE ID " + id);
        //What is the return value of no i
        if(result.getInt("id") == 0)
        {
            return false;
        }
        if(result.getInt("id") == id)
            return true;
        else
            return false;
    }

    public void insertPlayer(int id, String codeName) throws SQLException
    {
        Statement statement = connection.createStatement();

        statement.executeUpdate("INSTERT INTO player (" + id + ", " + "null, null, " + codeName + ")");
     
        statement.close();
    }

    public void printPlayers() throws SQLException
    {
        Statement stmt = connection.createStatement();
        ResultSet result = stmt.executeQuery("SELECT * FROM PLAYER");
        while(result.next())
        {
            System.out.println("ID: " + result.getInt("id") + ", code name: " + result.getString("codename"));
        }

        stmt.close();
        result.close();
    }

    
}
