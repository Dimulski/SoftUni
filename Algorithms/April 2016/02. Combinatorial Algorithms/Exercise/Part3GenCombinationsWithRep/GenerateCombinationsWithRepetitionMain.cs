namespace Part3GenCombinationsWithRep
{
    using System;

    public class GenerateCombinationsWithRepetitionMain
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
                    GenerateCombinations(arr, sizeOfSet, index + 1, i);
                }
            }
        }

        private static void Setup()
        {
            n = int.Parse(Console.ReadLine());
            k = int.Parse(Console.ReadLine());

            array = new int[k];
        }

        private static void Print(int[] arr)
        {
            Console.WriteLine("({0})", string.Join(", ", arr));
        }
    }
}
