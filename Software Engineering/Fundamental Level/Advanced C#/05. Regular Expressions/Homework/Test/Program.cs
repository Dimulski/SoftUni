using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Test
{
    class Program
    {
        static void Main()
        {
            string input = Console.ReadLine();
            string pattern = @"[+359]{4}[ -]{1}[2][ -]{1}[0-9]{3}[ -]{1}[0-9]{4}";
            bool result = Regex.IsMatch(input, pattern);
            Console.WriteLine(result);
        }
    }
}
