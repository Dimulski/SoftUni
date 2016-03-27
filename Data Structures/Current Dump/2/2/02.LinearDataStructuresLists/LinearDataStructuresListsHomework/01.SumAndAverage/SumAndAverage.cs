namespace _01.SumAndAverage
{
    using System;
    using System.Linq;
    using System.Collections.Generic;

    public class SumAndAverage
    {
        public static void Main()
        {
            List<int> numbers = Console.ReadLine()
                .Split(new[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                .Select(int.Parse)
                .ToList();

            int sum = numbers.Count > 0 ? numbers.Sum() : 0;
            double average = numbers.Count > 0 ? numbers.Average() : 0;
            Console.WriteLine("Sum = {0}; Average = {1}", sum, average);
        }
    }
}
