namespace NestedDictionary
{
    using System;
    using System.Collections.Generic;
    using System.Linq;

    public class CountriesAndPopulation
    {
        static void Main()
        {
            var countriesAndCities = new Dictionary<string, Dictionary<string, int>>();

            countriesAndCities.Add("Bulgaria", new Dictionary<string, int>());
            countriesAndCities["Bulgaria"]["Sofia"] = 1000000;
            countriesAndCities["Bulgaria"]["Plovdiv"] = 400000;
            countriesAndCities["Bulgaria"]["Pernik"] = 30000;

            foreach (var city in countriesAndCities["Bulgaria"])
            {
                Console.WriteLine(city.Value);
            }

            var totalPopulation = countriesAndCities["Bulgaria"]
                .Sum(c => c.Value);
            Console.WriteLine(totalPopulation);
        }
    }
}
