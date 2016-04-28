namespace Longest_Increasing_Subsequence
{
    using System;
    using System.Collections.Generic;

    public class LongestIncreasingSubsequence
    {
        private const int NoPrevious = -1;

        public static void Main()
        {
            int[] seq = { 3, 4, 8, 1, 2, 4, 32, 6, 2, 5, 33, 4, 38, 22 };
            int[] len = new int[seq.Length];
            int[] prev = new int[seq.Length];

            int bestIndex = CalculateLongestIncreasingSubsequence(seq, len, prev);

            Console.WriteLine("seq[] = " + string.Join(", ", seq));
            Console.WriteLine("len[] = " + string.Join(", ", len));
            Console.WriteLine("prev[] = " + string.Join(", ", prev));

            PrintLongestIncreasingSubsequence(seq, prev, bestIndex);
        }

        public static int[] FindLongestIncreasingSubsequence(int[] seq)
        {
            if (seq.Length == 0)
            {
                return seq;
            }
            int[] len = new int[seq.Length];
            int[] prev = new int[seq.Length];

            int bestIndex = CalculateLongestIncreasingSubsequence(seq, len, prev);
            return ReturnLongestIncreasingSubsequence(seq, prev, bestIndex);
        }

        private static void PrintLongestIncreasingSubsequence(int[] seq, int[] prev, int index)
        {
            List<int> lis = new List<int>();
            while (index != NoPrevious)
            {
                lis.Add(seq[index]);
                index = prev[index];
            }
            lis.Reverse();
            Console.WriteLine("subsequence = [{0}]", string.Join(", ", lis));
        }

        private static int CalculateLongestIncreasingSubsequence(int[] seq, int[] len, int[] prev)
        {
            int maxIndex = 0;
            int maxLen = 0;
            for (int x = 0; x < seq.Length; x++)
            {
                len[x] = 1;
                prev[x] = -1;
                for (int i = 0; i < x; i++)
                {
                    if (seq[x] > seq[i] && len[i] + 1 > len[x])
                    {
                        len[x] = len[i] + 1;
                        prev[x] = i;
                    }
                }

                if (len[x] > maxLen)
                {
                    maxLen = len[x];
                    maxIndex = x;
                }
            }

            return maxIndex;
        }

        private static int[] ReturnLongestIncreasingSubsequence(int[] seq, int[] prev, int index)
        {
            List<int> lis = new List<int>();
            while (index != NoPrevious)
            {
                lis.Add(seq[index]);
                index = prev[index];
            }

            lis.Reverse();
            return lis.ToArray();
        }
    }
}
