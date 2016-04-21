namespace Part2VariationsWithoutRep
{
    using System;

    public class VariationsWithoutRepetitionMain
    {
        private static int n;
        private static int k;

        private static int[] array;
        private static bool[] used;

        public static void Main()
        {
            Setup();
            GenerateVariations(array, n, used);
        }

        private static void GenerateVariations(int[] arr, int sizeOfSet, bool[] isUsed, int index = 0)
        {
            if (index >= arr.Length)
            {
                Print(arr);
                return;
            }

            for (int i = 1; i <= sizeOfSet; i++)
            {
                if (!isUsed[i])
                {
                    isUsed[i] = true;
                    arr[index] = i;
                    GenerateVariations(arr, sizeOfSet, isUsed, index + 1);
                    isUsed[i] = false;
                }
            }
        }

        private static void Setup()
        {
            n = int.Parse(Console.ReadLine());
            k = int.Parse(Console.ReadLine());

            array = new int[k];
            used = new bool[n + 1];
        }

        private static void Print(int[] arr)
        {
            Console.WriteLine("({0})", string.Join(", ", arr));
        }
    }
}
