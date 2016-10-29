// Write a regular expression to match a valid full name. A valid full name consists of two words, each word starts with a
// capital letter and contains only lowercase letters afterwards; each word should be at least two letters long;
// the two words should be separated by a single space. 

using System;
using System.Text.RegularExpressions;

namespace Problem_1_Match_Full_Name
{
    class MatchFullName
    {
        static void Main()
        {
            string input = Console.ReadLine();
            string pattern = @"[A-Z]{1}[a-z]{1,30}[ ][A-Z]{1}[a-z]{1,30}";
            bool result = Regex.IsMatch(input, pattern);
            Console.WriteLine(result);
        }
    }
}
