namespace ListVsHashSet
{
    using System;
    using System.Collections.Generic;
    using System.Diagnostics;

    public class ListVsHashSet
    {
        private const int ElementsCount = 64000;

        static void Main()
        {
            var rand = new Random();

            // Init list
            var beforeList = GC.GetTotalMemory(true);
            var list = InitializeList(rand);

            var afterList = GC.GetTotalMemory(true);
            Console.WriteLine("Memory used by List<int>:\t{0}",
                afterList - beforeList);

            // Init hash set
            var beforeHashSet = GC.GetTotalMemory(true);
            var hashSet = InitializeHashSet(rand);

            var afterHashSet = GC.GetTotalMemory(true);
            Console.WriteLine("Memory used by HashSet<int>:\t{0}",
                afterHashSet - beforeHashSet);

            var sw = new Stopwatch();
            sw.Start();
            for (int i = 0; i < ElementsCount; i++)
            {
                list.Contains(rand.Next());
            }

            Console.WriteLine("Time used by List<int>:\t\t{0}", sw.Elapsed);

            sw.Restart();
            for (int i = 0; i < ElementsCount; i++)
            {
                hashSet.Contains(rand.Next());
            }

            Console.WriteLine("Time used by HashSet<int>:\t{0}", sw.Elapsed);
        }

        private static HashSet<int> InitializeHashSet(Random rand)
        {
            HashSet<int> hashSet = new HashSet<int>();
            for (int i = 0; i < ElementsCount; i++)
            {
                hashSet.Add(rand.Next());
            }

            return hashSet;
        }

        private static List<int> InitializeList(Random rand)
        {
            var list = new List<int>();
            for (int i = 0; i < ElementsCount; i++)
            {
                list.Add(rand.Next());
            }

            return list;
        }
    }
}
