// Write a program that reads a string from the console, reverses it and prints the result back at the console.

using System;

namespace Problem_1.Reverse_String
{
    class ReverseString
    {
        static void Main()
        {
            string input = Console.ReadLine();
            Console.WriteLine(Reverse(input));            
        }

        public static string Reverse(string input)
        {
            char[] charArray = input.ToCharArray();
            Array.Reverse(charArray);
            return new string(charArray);
        }
    }
}
