import java.net.URI;
import java.net.URISyntaxException;
import java.sql.*;
import java.util.Properties;

import javax.xml.crypto.Data;

public class Database
{
    private static final String URI = "jdbc:postgresql://db.eokjwfanemzgvdmneeay.supabase.co:5432/postgres?user=postgres&password=uDpXxozjRFJmYp6W";
    Connection connection;

    public Database() throws Exception
    {
        //Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection(URI);

    }

    public void closeConnection() throws Exception
    {
        this.connection.close();
    }

 

    //Gets the userName from the table of players from a given id
    public String getCodeName(int id) throws SQLException
    {
        Statement stmt = connection.createStatement();
        ResultSet result = stmt.executeQuery("SELECT * FROM PLAYER WHERE ID =" + id);
        //If the query returns us a value then we
        if(result.next() != false)
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
        ResultSet result = statement.executeQuery("SELECT * FROM PLAYER WHERE ID=" + id);
        if(result.next() == false)
        {
            return false;
        }
        else
            return true;
    }

    public void insertPlayer(int id, String codeName) throws SQLException
    {
        String sql = "INSERT INTO player(id, codename) VALUES(" + id + ", '" + codeName + "')";
        Statement st = this.connection.createStatement();
        st.executeUpdate(sql);
        st.close();
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

    public static void main(String [] args) throws Exception
    {
        Database db = new Database();
        db.insertPlayer(668, "DOG");
    }

    
}
