namespace Problem1SumAndAverage
{
    using System;
    using System.Collections.Generic;
    using System.Linq;

    class SumAndAverageMain
    {
        static void Main()
        {
            int sum = 0;
            double average = 0;
            var input = Console.ReadLine();
            if (input != string.Empty)
            {
                List<int> numbers = input.Split(' ').Select(int.Parse).ToList();
                sum = numbers.Sum();
                average = (double)sum / numbers.Count;
            }
            Console.WriteLine("Sum={0}; Average={1}", sum, average);
        }   
    }
}
