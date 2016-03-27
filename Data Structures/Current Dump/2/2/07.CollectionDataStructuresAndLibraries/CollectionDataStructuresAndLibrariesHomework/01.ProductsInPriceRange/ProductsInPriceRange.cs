namespace _01.ProductsInPriceRange
{
    using System;
    using Wintellect.PowerCollections;

    public class ProductsInPriceRange
    {
        public static void Main()
        {
            var products = new OrderedMultiDictionary<double, string>(false);

            int numberOfProducts = int.Parse(Console.ReadLine());
            for (int i = 0; i < numberOfProducts; i++)
            {
                string[] productArgs = Console.ReadLine().Split(new[] {' '}, StringSplitOptions.RemoveEmptyEntries);
                string product = productArgs[0];
                double price = double.Parse(productArgs[1]);
                if (!products.ContainsKey(price))
                {
                    products.Add(price, product);
                }
                else
                {
                    products[price].Add(product);
                }
            }

            string[] range = Console.ReadLine().Split(new[] {' '}, StringSplitOptions.RemoveEmptyEntries);
            double start = double.Parse(range[0]);
            double end = double.Parse(range[1]);

            var priceRange = products.Range(start, true, end, true);
            foreach (var price in priceRange.Keys)
            {
                foreach (var product in products[price])
                {
                    Console.WriteLine("{0:F2} {1}", price, product);
                }
            }
        }
    }
}
