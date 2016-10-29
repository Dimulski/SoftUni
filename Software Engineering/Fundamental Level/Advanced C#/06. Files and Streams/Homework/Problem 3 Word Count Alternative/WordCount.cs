// Write a program that reads a list of words from the file words.txt and finds how many times each of the words is contained
// in another file text.txt. Matching should be case-insensitive. Write the results in file results.txt.Sort the words by
// frequency in descending order. Use StreamReader in combination with StreamWriter.

using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text.RegularExpressions;

namespace Problem_3_Word_Count_Alternative
{
    class WordCount
    {
        static void Main()
        {
            StreamReader reader = new StreamReader("word.txt");
            StreamReader reader2 = new StreamReader("text.txt");
            StreamWriter writer = new StreamWriter("results.txt");
            Dictionary<string, int> dict = new Dictionary<string, int>();
            using (reader2)
            {
                string text = reader2.ReadToEnd();
                using (reader)
                {
                    while (!reader.EndOfStream)
                    {
                        string wordToMatch = reader.ReadLine();
                        string pattern = "\\b" + wordToMatch + "\\b";
                        int count = Regex.Matches(text, pattern, RegexOptions.IgnoreCase).Count;
                        dict.Add(wordToMatch, count);
                    }
                }
            }
            using (writer)
            {
                foreach (var i in dict.OrderByDescending(s => s.Value))
                {
                    writer.WriteLine(String.Format("{0} - {1}", i.Key, i.Value));
                }
            }

        }
    }
}