namespace Problem1ReverseNumbersStack
{
    using System;
    using System.Collections.Generic;
    using System.Linq;

    class ReverseNumbersStackMain
    {
        static void Main()
        {
            var readLine = Console.ReadLine();
            if (!string.IsNullOrEmpty(readLine))
            {
                var input = readLine.Split().Select(int.Parse).ToArray();
                var arrayLength = input.Length;
                Stack<int> numbers = new Stack<int>();
                foreach (var number in input)
                {
                    numbers.Push(number);
                }
                for (int i = 0; i < arrayLength; i++)
                {
                    Console.Write(numbers.Pop() + " ");
                }
            }
            Console.WriteLine();
        }
    }
}
