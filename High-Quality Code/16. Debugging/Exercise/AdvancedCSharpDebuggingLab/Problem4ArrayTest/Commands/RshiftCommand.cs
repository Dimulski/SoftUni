using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem4ArrayTest.Commands
{
    public class RshiftCommand : Command
    {
        public RshiftCommand(string commandLine)
            : base(commandLine)
        {
        }

        public override string Execute(int[] numbers)
        {
            int[] copyArray = new int[numbers.Length];
            int lastNumber = numbers.Last();
            copyArray[0] = lastNumber;
            for (int i = 1; i < numbers.Length; i++)
            {
                copyArray[i] = numbers[i - 1];
            }
            StringBuilder sb = new StringBuilder();
            foreach (var number in copyArray)
            {
                sb.Append(number + " ");
            }
            return sb.ToString();
        }
    }
}
