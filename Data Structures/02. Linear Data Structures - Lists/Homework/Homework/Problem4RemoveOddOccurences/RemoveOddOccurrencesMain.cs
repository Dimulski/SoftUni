namespace Problem4RemoveOddOccurrences
{
    using System;
    using System.Linq;

    class RemoveOddOccurrencesMain
    {
        static void Main()
        {
            var numbers = Console.ReadLine()
                .Split(' ')
                .Select(int.Parse)
                .ToList();
            var elementsToRemove = numbers
                .GroupBy(n => n)
                .Where(g => g.Count() % 2 != 0)
                .Select(g => g.Key);

            foreach (var element in elementsToRemove)
            {
                numbers.RemoveAll(n => n == element);
            }

            Console.WriteLine(string.Join(" ", numbers));
        }
    }
}
