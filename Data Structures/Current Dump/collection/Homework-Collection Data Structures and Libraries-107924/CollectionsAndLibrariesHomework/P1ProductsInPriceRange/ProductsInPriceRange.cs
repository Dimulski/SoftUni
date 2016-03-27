using System;
using Wintellect.PowerCollections;
using System.Text;
using System.Linq;

namespace P1ProductsInPriceRange
{
    public class ProductsInPriceRange
    {
        private static Random randomizer = new Random();
        private static void Main()
        {
            var products = new OrderedMultiDictionary<double, string>(true);
            var productNames = new string[]{ "apples", "bananas", "milk", "water", "beer", "cheese", "muffin" };
            
            int productsCount = 500000;
            for (int counter = 0; counter < productsCount; counter++)
            {
                double price = randomizer.NextDouble() * (10.25 - 0.25) + 0.25;
                int randomIndex = randomizer.Next(0, productNames.Length);
                string product = productNames[randomIndex];
                products.Add(price, product);
            }

            int priceSearches = 10000;
            StringBuilder output = new StringBuilder(20);
            for (int counter = 0; counter < priceSearches; counter++)
            {
                double priceFrom = randomizer.NextDouble() * (10.25 - 0.25) + 0.25;
                double priceTo = randomizer.NextDouble() * (10.25 - 0.25) + 0.25;
                while (priceFrom > priceTo)
                {
                    priceFrom = randomizer.NextDouble() * (10.25 - 0.25) + 0.25;
                    priceTo = randomizer.NextDouble() * (10.25 - 0.25) + 0.25;
                }
                
                var firstTwentyProducts = products.Range(priceFrom, true, priceTo, true).KeyValuePairs.Take(20);
                foreach (var pair in firstTwentyProducts)
                {
                    output.AppendFormat("{0} - {1}{2}", pair.Value, pair.Key, Environment.NewLine);
                }

                //Console.WriteLine(output);
                //output.Clear();
            }
        }
    }
}
