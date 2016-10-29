// Write a program that reads a string from the console and replaces all series of consecutive identical letters with a
// single one.

using System;
using System.Text.RegularExpressions;

namespace Problem_1_Series_of_Letters
{
    class SeriesOfLetters
    {
        static void Main()
        {
            string input = Console.ReadLine();
            string pattern = @"(\w)\1+";
            string replacement = "$1";
            string result = Regex.Replace(input, pattern, replacement);
            Console.WriteLine(result);
        }
    }
}