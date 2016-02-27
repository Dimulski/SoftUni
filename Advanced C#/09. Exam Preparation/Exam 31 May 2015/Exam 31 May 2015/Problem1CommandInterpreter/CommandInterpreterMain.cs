namespace Problem1CommandInterpreter
{
    using System;
    using System.Collections.Generic;
    using System.Linq;

    class CommandInterpreterMain
    {
        static void Main()
        {
            // Things wrong about this solution: Not all invalid commands are caught. Validation through regex might be needed when working with different types
            // than those in the authors solution.

            List<string> collection = Console.ReadLine()
            .Split(new[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
            .ToList();

            var command = Console.ReadLine().Split(' ');
            bool weDidSomething = false;
            while (command[0] != "end")
            {
                try
                {
                    if (!IsValidInput(command))
                    {
                        throw new ArgumentException();
                    }

                    switch (command[0])
                    {
                        case "reverse":
                            ExecuteReverseCommand(command, collection);
                            break;
                        case "sort":
                            ExecuteSortCommand(command, collection);
                            break;
                        case "rollLeft":
                            int actualCount = int.Parse(command[1]) % collection.Count;
                            for (int i = 0; i < actualCount; i++)
                            {
                                collection = ShiftLeft(collection.ToArray());
                            }
                            break;
                        case "rollRight":
                            int actualCount2 = int.Parse(command[1]) % collection.Count;
                            for (int i = 0; i < actualCount2; i++)
                            {
                                collection = ShiftRight(collection.ToArray());
                            }
                            break;

                    }
                }
                catch (ArgumentException)
                {
                    Console.WriteLine("Invalid input parameters.");
                }
                
                command = Console.ReadLine().Split(' ');
            }
            Console.WriteLine("[{0}]",string.Join(", ", collection));
        }

        private static bool IsValidInput(string[] command)
        {
            bool result = true;

            switch (command[0])
            {
                case "reverse":
                case "sort":
                    if (int.Parse(command[2]) < 0)
                    {
                        result = false;
                    }
                    if (int.Parse(command[4]) < 0)
                    {
                        result = false;
                    }
                    break;
                case "rollLeft":
                case "rollRight":
                    if (int.Parse(command[1]) < 0)
                    {
                        result = false;
                    }
                    break;
            }

            return result;
        }

        private static List<string> ShiftLeft(string[] arr)
        {
            string[] demo = new string[arr.Length];

            for (int i = 0; i < arr.Length - 1; i++)
            {
                demo[i] = arr[i + 1];
            }

            demo[demo.Length - 1] = arr[0];

            return demo.ToList();
        }

        private static List<string> ShiftRight(string[] arr)
        {
            string[] demo = new string[arr.Length];

            for (int i = 1; i < arr.Length; i++)
            {
                demo[i] = arr[i - 1];
            }

            demo[0] = arr[demo.Length - 1];

            return demo.ToList();
        }

        private static void ExecuteSortCommand(string[] command, List<string> collection)
        {
            int startIndex = int.Parse(command[2]);

            if (startIndex == collection.Count)
            {
                throw new ArgumentException();
            }

            int count = int.Parse(command[4]);

            var targetSubcollection = collection.GetRange(startIndex, count);
            targetSubcollection.Sort();

            collection.RemoveRange(startIndex, count);
            collection.InsertRange(startIndex, targetSubcollection);
        }

        private static void ExecuteReverseCommand(string[] command, List<string> collection)
        {
            int startIndex = int.Parse(command[2]);

            if (startIndex == collection.Count)
            {
                throw new ArgumentException();
            }

            int count = int.Parse(command[4]);

            var targetSubcollection = collection.GetRange(startIndex, count);
            targetSubcollection.Reverse();

            collection.RemoveRange(startIndex, count);
            collection.InsertRange(startIndex, targetSubcollection);
        }
    }
}
