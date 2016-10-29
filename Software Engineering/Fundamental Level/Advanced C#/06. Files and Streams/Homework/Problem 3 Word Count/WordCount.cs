// Write a program that reads a list of words from the file words.txt and finds how many times each of the words is contained
// in another file text.txt. Matching should be case-insensitive. Write the results in file results.txt.Sort the words by
// frequency in descending order. Use StreamReader in combination with StreamWriter.

using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;

namespace Problem_3_Word_Count
{
    class WordCount
    {
        static void Main()
        {
            List<string> wordList = new List<string>();
            StringBuilder textReaderTestBuilder = new StringBuilder();
            char[] delimiters = { ' ', ',', '.', '?', '!', '-' , '\n'};

            using (var wordReader = new StreamReader("words.txt"))
            {
                string line = wordReader.ReadLine();
                while (line != null)
                {
                    wordList.Add(line);
                    line = wordReader.ReadLine();
                }
            }

            int numberOfWords = wordList.ToArray().Length;

            int[] intArray = new int[numberOfWords];

            using (var textReader = new StreamReader("text.txt"))
            {
                string line = textReader.ReadLine();
                while (line != null)
                {
                    textReaderTestBuilder.Append(line + '\n');
                    line = textReader.ReadLine();
                }
            }

            string[] textArray = textReaderTestBuilder.ToString().Split(delimiters);



            for (int i = 0; i < textArray.Length; i++)
            {
                for (int j = 0; j < numberOfWords; j++)
                {
                    if (wordList[j].ToUpperInvariant() == textArray[i].ToUpperInvariant())
                    {
                        intArray[j] += 1;
                    }
                }
            }

            for (int i = 0; i < numberOfWords; i++)
            {
                wordList[i] += " - " + intArray[i];
            }
            for (int i = 0; i < numberOfWords; i++)
            {
                wordList[i] = Reverse(wordList[i]);
            }
            string[] wordArray = wordList.ToArray().OrderByDescending(c => c).ToArray();
            

            using (var writer = new StreamWriter("result.txt"))
            {
                for (int i = 0; i < numberOfWords; i++)
                {
                    writer.WriteLine(Reverse(wordArray[i]));
                    
                }
            }
            
        }
        public static string Reverse(string s)
        {
            char[] charArray = s.ToCharArray();
            Array.Reverse(charArray);
            return new string(charArray);
        }
    }
}