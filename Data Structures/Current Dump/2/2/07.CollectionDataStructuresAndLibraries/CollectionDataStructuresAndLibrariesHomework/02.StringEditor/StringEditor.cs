namespace _02.StringEditor
{
    using System;
    using Wintellect.PowerCollections;

    public class StringEditor
    {
        public static void Main()
        {
            BigList<char> rope = new BigList<char>();
            string command = Console.ReadLine();
            while (!command.ToLower().Equals("end"))
            {
                string[] commandArgs = command.Split();
                string comandType = commandArgs[0].ToLower();
                
                if (comandType.Equals("append"))
                {
                    string str = commandArgs[1];
                    rope.AddRange(str);
                    Console.WriteLine("OK");
                }
                else if (comandType.Equals("insert"))
                {
                    string str = commandArgs[2];
                    int position = int.Parse(commandArgs[1]);
                    try
                    {
                        rope.InsertRange(position, str);
                        Console.WriteLine("OK");
                    }
                    catch (ArgumentOutOfRangeException)
                    {
                        Console.WriteLine("ERROR");
                    }
                }
                else if (comandType.Equals("delete"))
                {
                    int index = int.Parse(commandArgs[1]);
                    int count = int.Parse(commandArgs[2]);

                    try
                    {
                        rope.RemoveRange(index, count);
                        Console.WriteLine("OK");
                    }
                    catch (ArgumentOutOfRangeException)
                    {
                        Console.WriteLine("ERROR");
                    }
                }
                else if (comandType.Equals("replace"))
                {
                    int index = int.Parse(commandArgs[1]);
                    int count = int.Parse(commandArgs[2]);
                    string str = commandArgs[3];

                    try
                    {
                        rope.RemoveRange(index, count);
                        rope.InsertRange(index, str);
                        Console.WriteLine("OK");
                    }
                    catch (ArgumentOutOfRangeException)
                    {
                        Console.WriteLine("ERROR");
                    }
                }
                else if (comandType.Equals("print"))
                {
                    Console.WriteLine(string.Join("", rope));
                }

                command = Console.ReadLine();
            }
        }
    }
}
