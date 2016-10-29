// Write a method that reverses the digits of a given floating-point number.

using System;
using System.Linq;

namespace P5_Reverse_Number
{
    class Program
    {
        static void Main()
        {
            
            double number = double.Parse(Console.ReadLine());
            double reversed = ReverseDouble(number);
            Console.WriteLine(reversed);
        }

        static double ReverseDouble(double number)
        {
            return double.Parse(new string(number.ToString().ToCharArray().Reverse().ToArray()));
        }
    }
}