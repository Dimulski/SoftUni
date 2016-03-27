namespace _02CountSymbols
{
    using System;
    using System.Linq;
    using _01Dictionary;

    class Program
    {
        static void Main()
        {
            string text = Console.ReadLine();
            var symbolsCount = new Dictionary<char, int>();
            CountSymbols(text, symbolsCount);

            symbolsCount.OrderBy(e => e.Key).ToList().ForEach(e => Console.WriteLine("{0}: {1} time/s", e.Key, e.Value));
        }

        private static void CountSymbols(string text, Dictionary<char, int> symbolsCount)
        {
            foreach (var ch in text)
            {
                if (!symbolsCount.ContainsKey(ch))
                {
                    symbolsCount[ch] = 0;
                }

                symbolsCount[ch]++;
            }
        }
    }
}
