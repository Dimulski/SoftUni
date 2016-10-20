namespace Problem5CountOfOccurrences
{
    using System;
    using System.Linq;

    class CountOfOccurrencesMain
    {
        static void Main()
        {
            var numbers = Console.ReadLine()
                .Split(' ')
                .Select(int.Parse)
                .ToList();
            var groups = numbers
                .OrderBy(n => n)
                .GroupBy(n => n);

            foreach (var group in groups)
            {
                Console.WriteLine("{0} -> {1} times", group.Key, group.Count());
            }
        }
    }
}
