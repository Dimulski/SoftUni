namespace Part2Rope
{
    using System;

    using Wintellect.PowerCollections;

    public class Part2Main
    {
        private static BigList<char> bigList;
         
        public static void Main()
        {
            bigList = new BigList<char>();

            var inputLine = Console.ReadLine();
            while (inputLine != null)
            {
                var inputLineParams = inputLine.Split(' ');
                var command = inputLineParams[0];
                switch (command)
                {
                    case "INSERT":
                        var stringToInsert = inputLineParams[1];
                        ExecuteInsertCommand(stringToInsert);
                        break;
                    case "APPEND":
                        var stringToAppend = inputLineParams[1];
                        ExecuteAppendCommand(stringToAppend);
                        break;
                    case "DELETE":
                        var startIndex = int.Parse(inputLineParams[1]);
                        var count = int.Parse(inputLineParams[2]);
                        try
                        {
                            ExecuteDeleteCommand(startIndex, count);
                        }
                        catch (Exception)
                        {
                            Console.WriteLine("ERROR");
                        }

                        break;
                    case "PRINT":
                        ExecutePrintCommand();
                        break;
                }
                
                inputLine = Console.ReadLine();
            }
        }

        private static void ExecutePrintCommand()
        {
            foreach (var str in bigList)
            {
                Console.Write(str);
            }
            Console.WriteLine();
        }

        private static void ExecuteDeleteCommand(int startIndex, int count)
        {
            bigList.RemoveRange(startIndex, count);
            Console.WriteLine("OK");
        }

        private static void ExecuteAppendCommand(string stringToAppend)
        {
            foreach (var c in stringToAppend)
            {
                bigList.Add(c);
            }
            Console.WriteLine("OK");
        }

        private static void ExecuteInsertCommand(string stringToInsert)
        {
            int count = 0;
            foreach (var c in stringToInsert)
            {
                bigList.Insert(count++, c);
            }
            Console.WriteLine("OK");
        }
    }
}
