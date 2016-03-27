namespace _04.RemoveOddOccurances
{
    using System;
    using System.Collections.Generic;
    using System.Linq;

    public class RemoveOddOccurances
    {
        public static void Main()
        {
            List<int> numbers = Console.ReadLine()
                .Split(new[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                .Select(int.Parse)
                .ToList();

            int numberOfOccurances = 0;
            for (int i = 0; i < numbers.Count; i++)
            {
                for (int j = 0; j < numbers.Count; j++)
                {
                    if (numbers[i] == numbers[j])
                    {
                        numberOfOccurances++;
                    }
                }

                if (numberOfOccurances % 2 == 1)
                {
                    int numberToRemove = numbers[i];
                    numbers.RemoveAll(n => n == numberToRemove);
                    i--;
                }

                numberOfOccurances = 0;
            }

            Console.WriteLine(string.Join(" ", numbers));
        }
    }
}
