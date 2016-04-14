namespace PartOneGenVariationsWithRep
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

        private static void GenerateVariations(int[] array, int sizeOfSet, int index = 0)
        {
            if (index >= array.Length)
            {
                Print(array);
            }
            else
            {
                for (int i = 1; i <= sizeOfSet; i++)
                {
                    array[index] = i;
                    GenerateVariations(array, sizeOfSet, index + 1);
                }
            }
        }

        private static void Print(int[] array)
        {
            Console.WriteLine("({0})", string.Join(", ", array));
        }
    }
}
