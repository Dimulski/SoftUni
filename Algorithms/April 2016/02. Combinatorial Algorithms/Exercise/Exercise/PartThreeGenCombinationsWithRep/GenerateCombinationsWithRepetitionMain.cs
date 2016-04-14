namespace PartThreeGenCombinationsWithRep
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
        
        private static void GenerateCombinations(int[] array, int sizeOfSet, int index, int start = 1)
        {
            if (index >= array.Length)
            {
                Print(array);
            }
            else
            {
                for (int i = start; i <= sizeOfSet; i++)
                {
                    array[index] = i;
                    GenerateCombinations(array, sizeOfSet, index + 1, i);
                }
            }
        }

        private static void Setup()
        {
            n = int.Parse(Console.ReadLine());
            k = int.Parse(Console.ReadLine());

            array = new int[k];
        }

        private static void Print(int[] array)
        {
            Console.WriteLine("({0})", string.Join(", ", array));
        }
    }
}
