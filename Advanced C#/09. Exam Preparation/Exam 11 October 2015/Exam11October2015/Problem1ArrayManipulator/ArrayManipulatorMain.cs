namespace Problem1ArrayManipulator
{
    using System;
    using System.Collections.Generic;
    using System.Linq;
    using System.Text;

    class ArrayManipulatorMain
    {
        static void Main()
        {
            List<int> numbers = Console.ReadLine().Split(' ').Select(int.Parse).ToList();

            string[] command = Console.ReadLine().Split(' ').ToArray();
            while (!string.IsNullOrEmpty(command[0]))
            {
                switch (command[0])
                {
                    case "exchange":
                        try
                        {
                            var newList = ExecuteExchangeCommand(numbers, command);
                            numbers = newList;
                        }
                        catch (InvalidOperationException ex)
                        {
                            Console.WriteLine(ex.Message);
                        }
                        break;
                    case "max":
                        string maxResult = ExecuteMaxCommand(numbers, command);
                        Console.WriteLine(maxResult);
                        break;
                    case "min":
                        string minResult = ExecuteMinCommand(numbers, command);
                        Console.WriteLine(minResult);
                        break;
                    case "first":
                        string firstResult = ExecuteFirstCommand(numbers, command);
                        Console.WriteLine(firstResult);
                        break;

                }
                command = Console.ReadLine().Split(' ').ToArray();
            }
            foreach (var s in numbers)
            {
                Console.WriteLine(s);
            }
        }

        private static string ExecuteFirstCommand(List<int> numbers, string[] command)
        {
            List<int> newList = new List<int>(numbers);
            string result = string.Empty;
            switch (command[2])
            {
                case "odd": // using one newList might result in unwanted results 
                    newList.RemoveAll(n => n % 2 == 0);
                    if (newList.Count == 0)
                    {
                        result = "[]";
                        break;
                    }
                    var firstOdd = newList.GetRange(0, int.Parse(command[1]));
                    StringBuilder sb = new StringBuilder();
                    foreach (var i in firstOdd)
                    {
                        sb.Append(i + " ");
                    }
                    result = sb.ToString();
                    break;
                case "even":
                    newList.RemoveAll(n => n % 2 != 0);
                    if (newList.Count == 0)
                    {
                        result = "[]";
                        break;
                    }
                    var firstEven = newList.GetRange(0, int.Parse(command[1]));
                    StringBuilder sb2 = new StringBuilder();
                    foreach (var i in newList)
                    {
                        sb2.Append(i + " ");
                    }
                    result = sb2.ToString();
                    break;
            }
            return result;
        }

        private static string ExecuteMinCommand(List<int> numbers, string[] command)
        {
            List<int> newList = new List<int>(numbers);
            string result = string.Empty;
            switch (command[1])
            {
                case "odd":
                    newList.RemoveAll(n => n % 2 == 0);
                    if (newList.Count == 0)
                    {
                        result = "No matches";
                        break;
                    }
                    var minOdd = newList.Min();
                    result = minOdd.ToString();
                    break;
                case "even":
                    newList.RemoveAll(n => n % 2 != 0);
                    if (newList.Count == 0)
                    {
                        result = "No matches";
                        break;
                    }
                    var minEven = newList.Min(); ////////////////////////////////// IDK if this returns the first element which is a necessity.
                    result = minEven.ToString();
                    break;
            }
            return result;
        }

        private static string ExecuteMaxCommand(List<int> numbers, string[] command)
        {
            List<int> newList = new List<int>(numbers);
            string result = string.Empty;
            switch (command[1])
            {
                case "odd":
                    newList.RemoveAll(n => n % 2 == 0);
                    if (newList.Count == 0)
                    {
                        result = "No matches";
                        break;
                    }
                    var maxOdd = newList.Max(); 
                    result = maxOdd.ToString();
                    break;
                case "even":
                    newList.RemoveAll(n => n % 2 != 0);
                    if (newList.Count == 0)
                    {
                        result = "No matches";
                        break;
                    }
                    var maxEven = newList.Max();
                    result = maxEven.ToString();
                    break;
            }
            return result;
        }

        private static List<int> ExecuteExchangeCommand(List<int> numbers, string[] command)
        {
            List<int> newList = new List<int>();
            if (int.Parse(command[1]) > numbers.Count - 1)
            {
                throw new InvalidOperationException("Invalid index");
            }
            else
            {
                int counter = 0;
                for (int i = 0; i < numbers.Count; i++)
                {
                    if (i < int.Parse(command[1]) + 1)
                    {
                        newList.Add(numbers[i]);
                    }
                    else
                    {
                        newList.Insert(counter, numbers[i]);
                        counter++;
                    }
                }
                return newList;
            }
        }
    }
}
