namespace Problem7Words
{
    using System;
    using System.Collections.Generic;

    public class WordsMain
    {
        private static int resultsCount = 0;

        public static void Main()
        {
            var source = Console.ReadLine().ToCharArray();
            PermWithoutRepetitions(source, 0);
            Console.WriteLine(resultsCount);
        }

        private static void PermWithoutRepetitions(char[] source, int index)
        {
            if (index >= source.Length)
            {
                for (int i = 0; i < source.Length - 1; i++)
                {
                    if (source[i] == source[i + 1])
                    {
                        return;
                    }
                }

                resultsCount++;
            }
            else
            {
                var swapped = new HashSet<char>();
                for (int k = index; k < source.Length; k++)
                {
                    if (!swapped.Contains(source[k]))
                    {
                        Swap(ref source[index], ref source[k]);
                        PermWithoutRepetitions(source, index + 1);
                        Swap(ref source[index], ref source[k]);

                        swapped.Add(source[k]);
                    }
                }
            }
        }

        private static void Swap(ref char i, ref char k)
        {
            var temp = i;
            i = k;
            k = temp;
        }
    }
}
