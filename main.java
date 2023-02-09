public class main 
{
    public static void main(String [] args)
    {
       //LXthWx3ZgNGRQyOt
       SupabaseRestClient supabase = new SupabaserestClient("https://eokjwfanemzgvdmneeay.supabase.co","eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImVva2p3ZmFuZW16Z3ZkbW5lZWF5Iiwicm9sZSI6ImFub24iLCJpYXQiOjE2NzU4MDIwNDcsImV4cCI6MTk5MTM3ODA0N30.iHRSYdTqwcuTyDcDoX-rGQuNwesxQlSkbc677WsKlIM");
       supabase.database().insert("users", Insert.row().column("email", "user@email.com").column("username", "user123"));

    }    

}
