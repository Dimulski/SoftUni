namespace Problem3LongestSubsequence
{
    using System;
    using System.Collections.Generic;
    using System.Linq;

    class LongestSubsequenceMain
    {
        static void Main()
        {

            var numbers = Console.ReadLine()
                .Split(' ')
                .Select(int.Parse)
                .ToList();

            Console.WriteLine(string.Join(" ", GetLongestSubsequence(numbers)));
        }

        static List<int> GetLongestSubsequence(List<int> list)
        {
            var newList = new List<int>();
            int currentCount = 1;
            int largestCount = 1;
            int index = 0;

            for (int i = 0; i < list.Count - 1; i++)
            {
                for (int j = i + 1; j < list.Count; j++)
                {
                    if (list[i] == list[j])
                    {
                        currentCount++;
                    }
                }

                if (currentCount > largestCount)
                {
                    largestCount = currentCount;
                    index = i;
                }

                currentCount = 1;
            }

            newList.AddRange(list.GetRange(index, largestCount));

            return newList;
        }
    }
}
