namespace Problem4ArrayTest.Commands
{
    using System.Text;

    public class AddCommand : Command
    {
        public AddCommand(string commandLine)
            : base(commandLine)
        {
        }

        public override string Execute(int[] numbers)
        {
            numbers[this.Position - 1] = numbers[this.Position - 1] + this.Value;

            StringBuilder sb = new StringBuilder();
            foreach (var number in numbers)
            {
                sb.Append(number + " ");
            }
            return sb.ToString();
        }
    }
}
