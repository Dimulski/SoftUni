namespace Problem5PermutationsWithRepetition
{
    using System;
    using System.Collections.Generic;
    using System.Linq;

    public class PermutationsWithRepetitionMain
    {
        private static string[] arr;

        public static void Main()
        {
            Setup();
            GeneratePermutations(arr);
        }

        private static void GeneratePermutations<T>(T[] array, int index = 0)
        {
            var arrayLength = array.Length;

            if (index >= arrayLength)
            {
                Console.WriteLine("({0})", string.Join(", ", array));
            }
            else
            {
                var swapped = new HashSet<T>();

                for (int i = index; i < arrayLength; i++)
                {
                    if (!swapped.Contains(array[i]))
                    {
                        Swap(ref array[index], ref array[i]);
                        GeneratePermutations(array, index + 1);
                        Swap(ref array[index], ref array[i]);

                        swapped.Add(array[i]);
                    }
                }
            }
        }

        private static void Swap<T>(ref T a, ref T b)
        {
            T temp = a;
            a = b;
            b = temp;
        }

        private static void Setup()
        {
            var input = Console.ReadLine().Trim();
            arr = input.Split(' ').Select(i => i.Trim()).ToArray();
        }
    }
}
