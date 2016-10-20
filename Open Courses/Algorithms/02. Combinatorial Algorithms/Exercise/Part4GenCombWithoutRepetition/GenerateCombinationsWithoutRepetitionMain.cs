namespace Part4GenCombWithoutRepetition
{
    using System;

    public class GenerateCombinationsWithoutRepetitionMain
    {
        private static int n;
        private static int k;

        private static int[] array;

        public static void Main()
        {
            Setup();
            GenerateCombinations(array, n, 0);
        }

        private static void GenerateCombinations(int[] arr, int sizeOfSet, int index, int start = 1)
        {
            if (index >= arr.Length)
            {
                Print(arr);
            }
            else
            {
                for (int i = start; i <= sizeOfSet; i++)
                {
                    arr[index] = i;
                    GenerateCombinations(arr, sizeOfSet, index + 1, i + 1);
                }
            }
        }

        private static void Setup()
        {
            k = int.Parse(Console.ReadLine());
            n = int.Parse(Console.ReadLine());
            array = new int[k];
        }

        private static void Print(int[] arr)
        {
            Console.WriteLine("({0})", string.Join(", ", arr));
        }
    }
}
