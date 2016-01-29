namespace ChangePreventers
{
    public class Controller
    {
        public static void DisplayAllCustomers()
        {
            Database.GetCustomers();
            // ...
        }
    }
}
