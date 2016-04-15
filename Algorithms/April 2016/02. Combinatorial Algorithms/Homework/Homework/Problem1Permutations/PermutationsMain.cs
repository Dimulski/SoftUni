namespace Problem1Permutations
{
    using System;
    using System.Linq;

    public class PermutationsMain
    {
        private static int n;
        private static int[] array;
        private static int countOfPermutations;

        public static void Main()
        {
            Setup();
            Permute();

            Console.WriteLine($"Total permutations: {countOfPermutations}");
        }

        private static void Setup()
        {
            n = int.Parse(Console.ReadLine());
            array = Enumerable.Range(1, n).ToArray();
        }

        private static void Permute(int startIndex = 0)
        {
            if (startIndex >= array.Length - 1)
            {
                Console.WriteLine(string.Join(", ", array));
                countOfPermutations++;
            }
            else
            {
                for (int i = startIndex; i < array.Length; i++)
                {
                    Swap(ref array[startIndex], ref array[i]);
                    Permute(startIndex + 1);
                    Swap(ref array[startIndex], ref array[i]);
                }
            }
        }

        private static void Swap(ref int i, ref int j)
        {
            if (i == j)
            {
                return;
            }

            i ^= j;
            j ^= i;
            i ^= j;
        }
    }
}
