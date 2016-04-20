using System;
using System.Linq;

namespace Problem1ReverseArray
{
    class ReverseArrayMain
    {
        static int[] numbers;
        static int[] numbersReversed;

        static void Main()
        {
            Setup();
            ReverseNumbers(numbers.Length - 1, 0);
            Console.WriteLine(string.Join(" ",numbersReversed));
        }

        private static void ReverseNumbers(int index, int secondIndex)
        {
            if (index < 0)
            {
                return;
            }
            numbersReversed[index] = numbers[secondIndex];
            ReverseNumbers(index - 1, secondIndex + 1);
        }

        private static void Setup()
        {
            numbers = Console.ReadLine().Trim().Split(' ').Select(int.Parse).ToArray();
            var length = numbers.Length;
            numbersReversed = new int[length];
        }
    }
}
