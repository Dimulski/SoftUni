using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Test
{
    class Program
    {
        static void Main(string[] args)
        {
            int current = 0;

            int offset = -1;
            int arrayLength = 5;
            int wanted = (current + offset) % arrayLength;
            Console.WriteLine(wanted);
        }
    }
}
