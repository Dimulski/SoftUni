// Write a program to find how many times a given string appears in a given text as substring. The text is given at the first
// input line. The search string is given at the second input line. The output is an integer number. Please ignore the
// character casing. Overlapping between occurrences is allowed.

using System;

namespace Problem_3.Count_Substring_Occurrences
{
    class SubstringCount
    {
        static void Main()
        {
            string textInput = Console.ReadLine();
            string keyWord = Console.ReadLine();
            int counter = 0;
            string currentSearchWord;

            for (int i = 0; i < textInput.Length - keyWord.Length + 1; i++)
            {
                currentSearchWord = textInput.Substring(i, keyWord.Length);
                if (string.Equals(currentSearchWord, keyWord, StringComparison.OrdinalIgnoreCase))
                {
                    counter++;
                }
            }
            Console.WriteLine(counter);
        }
    }
}
