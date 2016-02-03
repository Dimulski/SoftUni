namespace Problem4ArrayTest.Commands
{
    public class StopCommand : Command
    {
        public StopCommand(string commandLine)
            : base(commandLine)
        {
        }

        public override string Execute(int[] numbers)
        {
            return "stop";
        }
    }
}
