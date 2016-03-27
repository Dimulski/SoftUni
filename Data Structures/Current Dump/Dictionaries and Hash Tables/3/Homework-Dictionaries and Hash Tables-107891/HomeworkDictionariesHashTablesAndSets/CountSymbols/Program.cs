namespace CountSymbols
{
    using System;
    using System.Linq;
    using Dictionary;

    internal class Program
    {
        private static void Main()
        {
            var input = Console.ReadLine();

            var counter = new HashTable<int, int>();

            if (input != null)
            {
                foreach (var t in input)
                {
                    if (!counter.ContainsKey(t))
                    {
                        counter.Add(t, 0);
                    }
                    counter[t]++;
                }
            }

            foreach (var count in counter.OrderBy(k => k.Key))
            {
                Console.WriteLine("{0}: {1} times/s", (char)count.Key, count.Value);
            }
        }
    }
}
