using System;

namespace Problem4CombWithoutRepetition
{
    class CombinationsWithoutRepetitionMain
    {
        static int n;
        static int k;
        static int[] array;

        static void Main()
        {
            try
            {
                Setup();
            }
            catch(InvalidOperationException e)
            {
                Console.WriteLine(e.Message);
            }
            
            GenerateCombinations(1, 0);
        }

        private static void GenerateCombinations(int current, int index)
        {
            if (index >= array.Length)
            {
                Print();
                return;
            }
            else
            {
                for (int i = current; i <= n; i++)
                {
                    array[index] = i;
                    GenerateCombinations(i + 1, index + 1);
                }
            }
        }

        private static void Print()
        {
            Console.WriteLine(string.Join(" ", array));
        }

        private static void Setup()
        {
            n = int.Parse(Console.ReadLine());
            k = int.Parse(Console.ReadLine());

            if (k > n)
            {
                throw new InvalidOperationException("n must be >= k!");
            }

            array = new int[k];
        }
    }
}
