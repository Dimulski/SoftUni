namespace Part1GenVariationsWithRep
{
    using System;

    public class GenerateVariationsWithRepetitionMain
    {
        private static int n;
        private static int k;

        private static int[] array;

        public static void Main()
        {
            Setup();
            GenerateVariations(array, n);
        }

        private static void Setup()
        {
            n = int.Parse(Console.ReadLine());
            k = int.Parse(Console.ReadLine());

            array = new int[k];
        }

        private static void GenerateVariations(int[] arr, int sizeOfSet, int index = 0)
        {
            if (index >= arr.Length)
            {
                Print(arr);
            }
            else
            {
                for (int i = 1; i <= sizeOfSet; i++)
                {
                    arr[index] = i;
                    GenerateVariations(arr, sizeOfSet, index + 1);
                }
            }
        }

        private static void Print(int[] arr)
        {
            Console.WriteLine("({0})", string.Join(", ", arr));
        }
    }
}
