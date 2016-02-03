using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

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
