import java.net.URI;
import java.net.URISyntaxException;
import java.sql.*;
import java.util.Properties;

public class Database
{

    


    private static final String URL = "jdbc:postgresql://db.eokjwfanemzgvdmneeay.supabase.co:5432/postgres?user=postgres&password=jVzB9MWEhATQnxrW";
    private static final String URI = "jdbc:postgresql://db.eokjwfanemzgvdmneeay.supabase.co:5432/postgres?user=postgres&password=jVzB9MWEhATQnxrW";
    private static final String KEY = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImVva2p3ZmFuZW16Z3ZkbW5lZWF5Iiwicm9sZSI6ImFub24iLCJpYXQiOjE2NzU4MDIwNDcsImV4cCI6MTk5MTM3ODA0N30.iHRSYdTqwcuTyDcDoX-rGQuNwesxQlSkbc677WsKlIM";
    Connection connection;

    public Database() throws Exception
    {
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection(URI);
        Statement st = connection.createStatement();
        String sql = "INSERT INTO player(id, first_name, last_name, codename) VALUES(120, 'dug', 'dug', 'goof')";
        st.executeUpdate(sql);
    }

    public void closeConnection() throws Exception
    {
        this.connection.close();
    }

 

    //Gets the userName from the table of players from a given id
    public String getCodeName(int id) throws SQLException
    {
        Statement stmt = connection.createStatement();
        //Why does it not like this thing here it should like it and I don't know why it does not
        ResultSet result = stmt.executeQuery("SELECT * FROM PLAYER WHERE ID " + id);
        //
        //If the query returns us a value then we
        if(result.getString("codename") != null)
        {
            return result.getString("codename");
        }
        else
        {
            return null;
        }
    }

    public boolean idExist(int id) throws SQLException
    {
        Statement statement = this.connection.createStatement();
        ResultSet result = statement.executeQuery("SELECT * FROM PLAYER WHERE ID " + id);
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
        String sql = "INSERT INTO player(id, first_name, last_name, codename) VALUES(120, 'dug', 'dug', 'goof')";
        Statement st = this.connection.createStatement();
        st.executeUpdate(sql);
    }

    public void printPlayers() throws SQLException
    {
        Statement stmt = this.connection.createStatement();
        ResultSet result = stmt.executeQuery("SELECT * FROM PLAYER");
        while(result.next())
        {
            System.out.println("ID: " + result.getInt("id") + ", code name: " + result.getString("codename"));
        }

        stmt.close();
        result.close();
    }

    
}
