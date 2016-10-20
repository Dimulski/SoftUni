namespace Problem3GenCombinationsIteratively
{
    using System;
    using System.Collections.Generic;

    public class GenerateCombinationsIterativelyMain
    {
        private static int n;
        private static int k;
        private static int totalCombinations;

        public static void Main()
        {
            Setup();
            GenerateCombinations();
            Console.WriteLine("Total combinations: {0}", totalCombinations);
        }

        private static void GenerateCombinations()
        {
            int[] combo = new int[k];

            Stack<int> stack = new Stack<int>();
            stack.Push(1);

            while (stack.Count > 0)
            {
                int index = stack.Count - 1;
                int value = stack.Pop();

                while (value <= n)
                {
                    combo[index++] = value++;
                    stack.Push(value);

                    if (index == k)
                    {
                        Console.WriteLine("({0})", string.Join(", ", combo));
                        totalCombinations++;
                        break;
                    }
                }
            }
        }

        private static void Setup()
        {
            n = int.Parse(Console.ReadLine());
            k = int.Parse(Console.ReadLine());
        }
    }
}
