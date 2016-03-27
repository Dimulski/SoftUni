namespace _01.ReverseNumbersWithAStack
{
    using System;
    using System.Collections.Generic;
    using System.Linq;

    public class ReverseNumbersWithAStack
    {
        public static void Main()
        {
            var numbers = Console.ReadLine()
                .Split(new[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                .Select(int.Parse)
                .ToArray();
            var reversedNumbers = new Stack<int>();

            for (int i = 0; i < numbers.Length; i++)
            {
                reversedNumbers.Push(numbers[i]);
            }

            Console.WriteLine(string.Join(" ", reversedNumbers));
        }
    }
}
