// Write a method that returns the last digit of a given integer as an English word. Test the method with different input values.
// Ensure you name the method properly.

using System;

namespace P2_Last_Digit_of_Number
{
    class Program
    {
        static void Main()
        {
            int number = int.Parse(Console.ReadLine());

            Console.WriteLine("Output: {0}", GetLastDigitAsWord(number));
        }

        private static string GetLastDigitAsWord(int num)
        {
            string[] digitAsWord = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
            int digit = num % 10;
            return digitAsWord[digit];
        }
    }
}

