namespace Problem4GenerateSubsetsOfStringArray
{
    using System;
    using System.Linq;

    public class GenerateSubsetsOfStringArrayMain
    {
        private static int k;
        private static string[] set;
        private static int[] array;

        public static void Main()
        {
            Setup();
            GenerateCombinations(0, 0);
        }

        private static void GenerateCombinations(int index, int start)
        {
            if (index >= k)
            {
                Print();
            }
            else
            {
                for (int i = start; i < set.Length; i++)
                {
                    array[index] = i;
                    GenerateCombinations(index + 1, i + 1);
                }
            }
        }

        private static void Print()
        {
            Console.WriteLine("({0})", string.Join(", ", array.Select(i => set[i])));
        }

        private static void Setup()
        {
            var input = Console.ReadLine().Trim();
            set = input.Split(' ').Select(i => i.Trim()).ToArray();

            k = int.Parse(Console.ReadLine());
            array = new int[k]; 
        }
    }
}
