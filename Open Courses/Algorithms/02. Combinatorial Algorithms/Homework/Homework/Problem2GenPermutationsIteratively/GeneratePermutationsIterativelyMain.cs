namespace Problem2GenPermutationsIteratively
{
    using System;
    using System.Linq;

    public class GeneratePermutationsIterativelyMain
    {
        private static int n;
        private static int[] array;
        private static int totalPermutations = 1;

        public static void Main()
        {
            Setup();
            Permute();
            Console.WriteLine("Total permutations: {0}", totalPermutations);
        }

        private static void Permute()
        {
            Console.WriteLine("({0})", string.Join(", ", array));

            int[] indices = new int[n];
            int index = 1;

            while (index < n)
            {
                if (indices[index] < index)
                {
                    int tempIndex = 0;

                    if ((index % 2) != 0)
                    {
                        tempIndex = indices[index];
                    }

                    Swap(ref array[tempIndex], ref array[index]);

                    Console.WriteLine("({0})", string.Join(", ", array));
                    totalPermutations++;

                    indices[index]++;
                    index = 1;
                }
                else
                {
                    indices[index] = 0;
                    index++;
                }
            }
        }

        private static void Setup()
        {
            n = int.Parse(Console.ReadLine());
            array = Enumerable.Range(1, n).ToArray();
        }

        private static void Swap(ref int a, ref int b)
        {
            if (a == b)
            {
                return;
            }

            int temp = a;
            a = b;
            b = temp;
        }
    }
}
