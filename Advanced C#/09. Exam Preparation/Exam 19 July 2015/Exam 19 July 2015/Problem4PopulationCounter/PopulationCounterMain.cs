namespace Problem4PopulationCounter
{
    using System;
    using System.Collections.Generic;
    using System.Linq;
    using System.Numerics;
    using System.Text;

    class PopulationCounterMain
    {
        static void Main()
        {
            Dictionary<string, Dictionary<string, long>> countriesAndTowns = new Dictionary<string, Dictionary<string, long>>();

            string inputLine = Console.ReadLine();
            while (inputLine != "report")
            {
                string[] inputParams = inputLine.Split('|');
                string town = inputParams[0];
                string country = inputParams[1];
                int population = int.Parse(inputParams[2]);

                if (!countriesAndTowns.ContainsKey(country))
                {
                    countriesAndTowns.Add(country, new Dictionary<string, long>());
                }

                countriesAndTowns[country].Add(town, population);

                inputLine = Console.ReadLine();
            }

            var sortedData = countriesAndTowns.OrderByDescending(x => x.Value.Sum(y => y.Value));

            foreach (var countryInfo in sortedData)
            {
                long totalPopulation = countryInfo.Value.Sum(x => x.Value);
                Console.WriteLine(
                    "{0} (total population: {1})",
                    countryInfo.Key,
                    totalPopulation);

                var orderedCityData = countryInfo.Value
                    .OrderByDescending(x => x.Value);

                foreach (var cityInfo in orderedCityData)
                {
                    Console.WriteLine("=>{0}: {1}", cityInfo.Key, cityInfo.Value);
                }
            }
        }
    }
}
