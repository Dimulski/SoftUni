namespace Part1RecursiveArraySum
{
    using System;
    using System.Linq;

    public class RecursiveArraySumMain
    {
        private static int[] array;
        private static int sum;

        public static void Main()
        {
            Setup();
            FindSum(0);
        }

        private static void FindSum(int index)
        {
            if (index >= array.Length)
            {
                Console.WriteLine("Sum = {0}", sum);
                return;
            }

            sum += array[index];
            FindSum(index + 1);
        }

        private static void Setup()
        {
            array = Console.ReadLine().Trim().Split(' ').Select(int.Parse).ToArray();
        }
    }
}
