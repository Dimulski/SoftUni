namespace Problem2SortWords
{
    using System;
    using System.Collections.Generic;
    using System.Linq;

    class SortWordsMain
    {
        static void Main()
        {
            List<string> words = Console.ReadLine().Split(' ').ToList();

            words.Sort((w1, w2) => w1.CompareTo(w2));

            foreach (var word in words)
            {
                Console.WriteLine(word);
            }
        }
    }
}
