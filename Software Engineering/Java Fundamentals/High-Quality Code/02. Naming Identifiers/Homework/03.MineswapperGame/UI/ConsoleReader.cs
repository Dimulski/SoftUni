namespace Minesweeper.UI
{
    using System;
    using Contracts;

    public class ConsoleReader : IInputReader
    {
        public string Read()
        {
            var result = Console.ReadLine();

            return result;
        }
    }
}