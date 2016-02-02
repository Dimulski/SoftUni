namespace Problem4ArrayTest
{
    using System;
    using System.Linq;

    public class ArraysMain
    {
        private const char ArgumentsDelimiter = ' ';

        public static void Main()
        {
            Console.ReadLine(); // This will stay unused.

            long[] numbers = Console.ReadLine().Trim().Split(ArgumentsDelimiter).Select(long.Parse).ToArray();

            string command = Console.ReadLine();

            ExecureCommand(command);



            while (!command.Equals("stop"))
            {
                
                string[] commandArray = command.Split(ArgumentsDelimiter).ToArray();
                string action = commandArray[0];
                int[] args = new int[2];

                args[0] = int.Parse(commandArray[1]);
                args[1] = int.Parse(commandArray[2]);

                PerformAction(array, command, args);

                PrintArray(array);
                Console.WriteLine('\n');

                command = Console.ReadLine();
            }
        }

        private static string ExecureCommand(string command)
        {
            
        }

        static void PerformAction(long[] arr, string action, int[] args)
        {
            int pos = args[0];
            int value = args[1];

            switch (action)
            {
                case "multiply":
                    arr[pos] *= value;
                    break;
                case "add":
                    arr[pos] += value;
                    break;
                case "subtract":
                    arr[pos] -= value;
                    break;
                case "lshift":
                    ArrayShiftLeft(arr);
                    break;
                case "rshift":
                    ArrayShiftRight(arr);
                    break;
            }
        }

        private static void ArrayShiftRight(long[] array)
        {
            for (int i = array.Length - 1; i >= 1; i--)
            {
                array[i] = array[i - 1];
            }
        }

        private static void ArrayShiftLeft(long[] array)
        {
            for (int i = 0; i < array.Length - 1; i++)
            {
                array[i] = array[i + 1];
            }
        }

        private static void PrintArray(long[] array)
        {
            for (int i = 0; i < array.Length; i++)
            {
                Console.WriteLine(array[i] + " ");
            }
        }
    }
}
