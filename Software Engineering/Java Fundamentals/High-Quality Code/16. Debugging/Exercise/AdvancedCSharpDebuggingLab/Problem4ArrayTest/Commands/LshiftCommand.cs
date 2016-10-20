namespace Problem4ArrayTest.Commands
{
    using System.Linq;
    using System.Text;

    public class LshiftCommand : Command
    {
        public LshiftCommand(string commandLine)
            : base(commandLine)
        {
        }

        public override string Execute(int[] numbers)
        {
            int firstNumber = numbers.First();
            int[] copyArray = new int[numbers.Length];
            for (int i = 0; i < numbers.Length - 1; i++)
            {
                copyArray[i] = numbers[i + 1];
            }
            copyArray[numbers.Length - 1] = firstNumber;
            StringBuilder sb = new StringBuilder();
            foreach (var number in copyArray)
            {
                sb.Append(number + " ");
            }
            return sb.ToString();
        }
    }
}
