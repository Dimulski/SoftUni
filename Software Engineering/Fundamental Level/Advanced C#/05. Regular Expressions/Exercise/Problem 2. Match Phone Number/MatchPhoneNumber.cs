// Write a regular expression to match a valid phone number from Sofia. A valid number will start with "+359" followed by
// the area code (2) and then the number itself, consisting of 7 digits (separated in two group of 3 and 4 digits respectively).
// The different parts of the number are separated by either a space or a hyphen ('-').

using System;
using System.Text.RegularExpressions;

namespace Problem_2.Match_Phone_Number
{
    class MatchPhoneNumber
    {
        static void Main()
        {
            string input = Console.ReadLine();
            string pattern = @"[+359]{4}[ -]{1}[2][ -]{1}[0-9]{3}[ -]{1}[0-9]{4}";
            bool result = Regex.IsMatch(input,pattern);
            Console.WriteLine(result);
        }
    }
}
