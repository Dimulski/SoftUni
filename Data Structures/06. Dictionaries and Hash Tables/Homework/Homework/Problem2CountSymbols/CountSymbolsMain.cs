namespace Problem2CountSymbols
{
    using System;
    using System.Linq;

    using Problem1Dictionary;

    class CountSymbolsMain
    {
        static void Main()
        {
            string text = Console.ReadLine();

            var dictionary = new MyDictionary<char, int>();

            foreach (var letter in text)
            {
                if (!dictionary.ContainsKey(letter))
                {
                    dictionary.Add(letter, 1);
                }
                else
                {
                    dictionary[letter] += 1;
                }
            }

            var sortedDictionary = dictionary.OrderBy(element => element.Key);

            foreach (var element in sortedDictionary)
            {
                Console.WriteLine("{0}: {1} time/s", element.Key, element.Value);
            }
        }
    }
}
