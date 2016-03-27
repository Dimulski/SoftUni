namespace _03.LongestSubsequence
{
    using System;
    using System.Collections.Generic;
    using System.Linq;

    public class LongestSubsequence
    {
        public static void Main()
        {
            List<int> sequence = Console.ReadLine()
                .Split(new[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                .Select(int.Parse)
                .ToList();

            int numberInLongestSequence = sequence[0];
            int currSubsequence = 1;
            int longestSequence = 0;
            

            for (int i = 0; i < sequence.Count - 1; i++)
            {
                if (sequence[i] == sequence[i + 1])
                {
                    currSubsequence++;
                }
                else
                {
                    currSubsequence = 1;
                }

                if (currSubsequence > longestSequence)
                {
                    longestSequence = currSubsequence;
                    numberInLongestSequence = sequence[i];
                }
            }

            if (longestSequence == 0)
            {
                longestSequence = currSubsequence;
            }

            List<int> longestSubsequence = new List<int>();
            for (int i = 0; i < longestSequence; i++)
            {
                longestSubsequence.Add(numberInLongestSequence);
            }

            Console.WriteLine(string.Join(" ", longestSubsequence));
        }
    }
}
