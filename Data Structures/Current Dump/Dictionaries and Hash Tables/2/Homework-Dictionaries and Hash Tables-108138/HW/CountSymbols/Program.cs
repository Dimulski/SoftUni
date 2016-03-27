namespace CountSymbols
{
    using System;
    using System.Collections.Generic;
    using System.Linq;
    using CustomDictionary;

    public class Program
    {
        public static void Main(string[] args)
        {
            var dict = new CustomDictionary<char, int>();
            var input = Console.ReadLine().ToCharArray();
            Console.WriteLine();
            foreach (char c in input)
            {
                if (!dict.ContainsKey(c))
                {
                    dict.Add(c, 1);
                }
                else
                {
                    dict[c] += 1;
                }
            }
            var keys = dict.Keys.ToList();
            keys.Sort();
            
            foreach (var key in keys)
            {
                Console.WriteLine(string.Format("{0}: {1} time/s", key, dict[key]));
            }
        }
    }
}
