namespace ChangePreventers
{
    public static class Application
    {
        public static void Start()
        {
            Database.DbConnectionString = "LocalDb/v0.2";
            Database.ConnectToDb();

            Controller.DisplayAllCustomers();
            // ..
        }
    }
}
