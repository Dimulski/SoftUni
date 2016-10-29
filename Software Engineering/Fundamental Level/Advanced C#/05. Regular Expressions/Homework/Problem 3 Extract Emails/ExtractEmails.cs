// Write a program that reads a keyword and some text from the console and prints all sentences from the text,
// containing that word. A sentence is any sequence of words ending with '.', '!' or '?'. 

using System;
using System.Text.RegularExpressions;

namespace Problem_3_Extract_Emails
{
    class ExtractEmails
    {
        static void Main()
        {
            string input = Console.ReadLine();
            string emailPattern = @"\b([A-Za-z0-9]+?)[\w\-\.]*?[A-Za-z0-9]+?@[A-Za-z0-9]+?([\w\-\.]+)\2*?\.[\w]{2,}\b";
            Regex regex = new Regex(emailPattern);
            MatchCollection matches = regex.Matches(input);
            foreach (Match match in matches)
            {
                Console.WriteLine(match.Value);
            }
        }
    }
}
