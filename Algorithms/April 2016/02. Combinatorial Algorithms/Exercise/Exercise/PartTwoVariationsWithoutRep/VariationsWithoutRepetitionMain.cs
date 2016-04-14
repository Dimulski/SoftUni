namespace PartTwoVariationsWithoutRep
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

        private static void GenerateVariations(int[] array, int sizeOfSet, bool[] used, int index = 0)
        {
            if (index >= array.Length)
            {
                Print(array);
                return;
            }

            for (int i = 1; i <= sizeOfSet; i++)
            {
                if (!used[i])
                {
                    used[i] = true;
                    array[index] = i;
                    GenerateVariations(array, sizeOfSet, used, index + 1);
                    used[i] = false;
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

        private static void Print(int[] array)
        {
            Console.WriteLine("({0})", string.Join(", ", array));
        }
    }
}
