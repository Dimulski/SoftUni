namespace Bloaters
{
    class Program
    {
        static void Main(string[] args)
        {
            var db = new Database();

            // Prepare database
            db.OpenConnection();
            db.BeginTransaction();

            // Use database
            db.InsertCountry();
            
            // Close database
            db.CloseConnection();
            db.ReleaseInternalResources();
            db.FreeMemory();
        }
    }
}
