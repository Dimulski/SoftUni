namespace Dictionary
{
    using System;
    using System.Linq;
    using System.Text;

    class Problem2
    {
        static void Main()
        {
            string text = Console.ReadLine();

            MyDictionary<char, int> dict = new MyDictionary<char, int>();

            foreach (var character in text)
            {
                if (!dict.ContainsKey(character))
                {
                    dict[character] = 1;
                }
                else
                {
                    dict[character]++;
                }
            }


            var sortedByKeys = dict.OrderBy(x => x.Key);
            foreach (var pair in sortedByKeys)
            {
                Console.WriteLine("{0}: {1} time/s", pair.Key, pair.Value);
            }
        }
    }
}
