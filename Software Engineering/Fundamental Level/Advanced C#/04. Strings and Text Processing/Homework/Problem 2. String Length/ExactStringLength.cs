// Write a program that reads from the console a string of maximum 20 characters.If the length of the string is less than 20,
// the rest of the characters should be filled with*. Print the resulting string on the console.

using System;

namespace Problem_2.String_Length
{
    class ExactStringLength
    {
        static void Main()
        {
            string asterisk = new string('*', 20);
            string inputString = Console.ReadLine();

            // String check and edit.
            for (int i = 0; i < inputString.Length; i++)
            {
                if (inputString.Length < 20)
                {
                    inputString += (asterisk.Remove(asterisk.Length - inputString.Length));
                }
                if (inputString.Length > 20)
                {
                    inputString = inputString.Substring(0,20);
                }
            }

            Console.WriteLine(inputString);
        }
    }
}
