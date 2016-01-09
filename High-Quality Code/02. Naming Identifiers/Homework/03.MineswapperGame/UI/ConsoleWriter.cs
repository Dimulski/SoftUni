namespace Minesweeper.UI
{
    using System;
    using Contracts;

    public class ConsoleWriter : IOutputWriter
    {
        public void Print(string msg, params object[] args)
        {
            Console.Write(msg, args);
        }

        public void PrintLine(string msg, params object[] args)
        {
            Console.WriteLine(msg, args);
        }
    }
}