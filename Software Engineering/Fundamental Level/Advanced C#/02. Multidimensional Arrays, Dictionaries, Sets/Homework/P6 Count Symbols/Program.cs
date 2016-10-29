// Write a program that reads some text from the console and counts the occurrences of each character in it.
// Print the results in alphabetical (lexicographical) order. 

using System;
using System.Collections.Generic;

namespace P6_Count_Symbols
{
    class Program
    {
        static void Main()
        {
            string inputText = Console.ReadLine();

            SortedDictionary<char, int> occurrences = new SortedDictionary<char, int>();
            foreach (char symbol in inputText)
            {
                if (occurrences.ContainsKey(symbol))
                {
                    occurrences[symbol]++;
                }
                else
                {
                    occurrences.Add(symbol, 1);
                }
            }

            foreach (KeyValuePair<char, int> pair in occurrences)
            {
                Console.WriteLine("{0}: {1} time/s", pair.Key, pair.Value);
            }
        }
    }
}
