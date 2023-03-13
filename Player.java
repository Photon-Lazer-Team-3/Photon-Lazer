public class Player 
{
    private String codeName;
    private int id, score;


    public Player(String codeName, int id, int score)
    {
        this.codeName = codeName;
        this.id = id;
        this.score = score;
    }

    public Player(String codeName)
    {
        this.codeName = codeName;
        this.score = 0;
    }

    //Default constructor
    public Player()
    {
        this.score = 0;
    }

    //User Name getter/setters
    public void setcodeName(String name)
    {
        this.codeName = name;
    }
    public String getcodeName()
    {
        return this.codeName;
    }

    public void setID(int id)
    {
        this.id = id;
    }
    public int getID()
    {
        return this.id;
    }

    public void setScore(int score)
    {
        this.score = score;
    }
    public int getScore()
    {
        return this.score;
    }

    public void incrementScore(int ammount)
    {
        this.score += ammount;
    }


    public String toString()
    {
        return "Code Name: " + this.codeName + "\nID: " + this.id + "\nScore: " + this.score; 
    }


}