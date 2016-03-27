namespace _05.CountOfOccurances
{
    using System;
    using System.Collections.Generic;
    using System.Linq;

    public class CountOfOccurances
    {
        public static void Main()
        {
            List<int> numbers = Console.ReadLine()
                .Split(new[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                .Select(int.Parse)
                .ToList();

            numbers.Sort();
            int numberOfDistinctNumbers = numbers.Distinct().Count();
            List<string> results = new List<string>();

            for (int i = 0; i < numbers.Count; i++)
            {
                int occurancesOfCurrentNumber = 0;
                for (int j = i; j < numbers.Count; j++)
                {
                    if (numbers[i] == numbers[j])
                    {
                        occurancesOfCurrentNumber++;
                    }
                    else
                    {
                        i = j - 1;
                        break;
                    }
                }

                results.Add(string.Format("{0} -> {1} times", numbers[i], occurancesOfCurrentNumber));
                if (results.Count == numberOfDistinctNumbers)
                {
                    break;
                }
            }

            Console.WriteLine(string.Join("\n", results));
        }
    }
}
