// Write a program that reads a keyword and some text from the console and prints all sentences from the text, containing
// that word.A sentence is any sequence of words ending with '.', '!' or '?'. 

using System;
using System.Text.RegularExpressions;

namespace Problem_4_Sentence_Extractor
{
    class SentanceExtractor
    {
        static void Main(string[] args)
        { 
            string word = Console.ReadLine();
            string text = Console.ReadLine();
            
            MatchCollection matches = IsSentence(text);

            foreach (Match sentence in matches)
            {
                string x = sentence.ToString();
                if (IsWordInSentence(x, word))
                {
                    Console.WriteLine(x.Trim());
                }
            }
        }

        private static bool IsWordInSentence(string sentence, string word)
        {
            return Regex.Matches(sentence, string.Format(@"\b{0}\b", word), RegexOptions.IgnoreCase).Count != 0;
        }

        private static MatchCollection IsSentence(string text)
        {
            string pattern = @"([^.!?]+(?=[.!?])[.!?])";
            Regex rgx = new Regex(pattern);
            MatchCollection matches = rgx.Matches(text);
            return matches;
        }
    }
}
