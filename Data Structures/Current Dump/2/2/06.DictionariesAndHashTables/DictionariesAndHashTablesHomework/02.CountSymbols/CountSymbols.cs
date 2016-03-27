namespace _02.CountSymbols
{
    using System;
    using System.Linq;
    using _01.Dictionary;

    public class CountSymbols
    {
        public static void Main()
        {
            Console.Write("Enter text: ");
            string text = Console.ReadLine();
            var dictionary = new CustomDictionary<char, int>();

            foreach (var symbol in text)
            {
                if (!dictionary.ContainsKey(symbol))
                {
                    dictionary.Add(symbol, 0);
                }

                dictionary[symbol]++;
            }

            var orderedSymbols = dictionary.Keys.OrderBy(s => s);

            foreach (var symbol in orderedSymbols)
            {
                Console.WriteLine("{0}: {1} time/s", symbol, dictionary[symbol]);
            }
        }
    }
}
