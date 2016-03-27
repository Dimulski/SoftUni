namespace _02.RopeForEfficientStringEditing
{
    using System;
    using Wintellect.PowerCollections;

    public class RopeForEfficientStringEditing
    {
        public static void Main()
        {
            BigList<char> rope = new BigList<char>();
            string command = Console.ReadLine();
            while (!command.ToLower().Equals("print"))
            {
                string[] commandArgs = command.Split();
                string comandType = commandArgs[0].ToLower();
                if (comandType.Equals("insert"))
                {
                    string str = commandArgs[1];
                    rope.InsertRange(0, str);
                    Console.WriteLine("OK");
                }
                else if (comandType.Equals("append"))
                {
                    string str = commandArgs[1];
                    rope.AddRange(str);
                    Console.WriteLine("OK");
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

                command = Console.ReadLine();
            }

            Console.WriteLine(string.Join("", rope));
        }
    }
}
