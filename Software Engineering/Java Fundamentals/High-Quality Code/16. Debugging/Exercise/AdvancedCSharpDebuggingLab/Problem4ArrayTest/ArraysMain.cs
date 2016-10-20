namespace Problem4ArrayTest
{
    using System;
    using System.Linq;

    using Problem4ArrayTest.Commands;

    public class ArraysMain
    {
        private const char ArgumentsDelimiter = ' ';

        public static void Main()
        {
            Console.ReadLine();
            int[] array = Console.ReadLine().Trim().Split(ArgumentsDelimiter).Select(int.Parse).ToArray();
            string command = Console.ReadLine();
            while (true)
            {
                string[] commandArgs = command.Trim().Split(ArgumentsDelimiter).ToArray();
                string action = commandArgs[0];
                string properActionName = action.Replace(action.Substring(0, 1), action.Substring(0, 1).ToUpper());

                Command currentCommand =
                    Activator.CreateInstance(
                        Type.GetType(string.Format("Problem4ArrayTest.Commands.{0}Command", properActionName)),
                        command) as Command;
                var result = currentCommand.Execute(array);
                if (result == "stop")
                {
                    break;
                }
                Console.WriteLine(result);
                
                command = Console.ReadLine();
            }
        }
    }
}
