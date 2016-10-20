namespace Problem4ArrayTest.Commands
{
    using System;
    using System.Linq;

    public abstract class Command
    { 
        private const char ArgumentsDelimiter = ' ';

        private string _commandLine;

        private string _action;

        private int _position;

        private int _value;

        public Command(string commandLine)
        {
            this.CommandLine = commandLine;
            string[] commandArgs = this.CommandLine.Trim().Split(ArgumentsDelimiter).ToArray();
            this.Action = commandArgs[0];
            if (commandArgs.Length > 1)
            {
                this.Position = int.Parse(commandArgs[1]);
                this.Value = int.Parse(commandArgs[2]);
            }
        }

        public int Value
        {
            get { return this._value; }
            set { this._value = value; }
        }
        public int Position
        {
            get { return this._position; }
            set
            {
                if (value < 0)
                {
                    throw new ArgumentOutOfRangeException("The position must be an integer in the range [0, 100]!");
                }
                this._position = value;
            }
        }

        public string Action
        {
            get { return this._action; }
            set { this._action = value; }

        }

        public string CommandLine
        {
            get { return this._commandLine; }
            set { this._commandLine = value; }
        }

        public abstract string Execute(int[] numbers);
    }
}
