namespace Bloaters
{
    using System;
    using System.Collections.Generic;

    public class Database
    {
        public void InsertUser(string username, 
            string password,
            int age,
            DateTime birthDate,
            int passportId, 
            string cityName, 
            string country, 
            int height,
            string favouriteFood)
        {
            // ...
        }

        public void OpenConnection()
        {
        }

        public void BeginTransaction()
        {
        }

        public List<string> GetAllUserNames()
        {
            return null;
        }

        public List<int> GetAllUserIds()
        {
            return null;
        }

        public void InsertCity()
        {
        }

        public List<string> GetAllCountries()
        {
            return null;
        }

        public void InsertCountry()
        {
        }

        public List<string> GetAllCities()
        {
            return null;
        }

        // ...

        public void CloseConnection()
        {
        }

        public void ReleaseInternalResources()
        {
        }

        public void FreeMemory()
        {
        }
    }
}
