// Write a program that reads N floating-point numbers from the console.Your task is to separate them in two sets,
// one containing only the round numbers(e.g. 1, 1.00, etc.) and the other containing the floating-point numbers with
// non-zero fraction. Print both arrays along with their minimum, maximum, sum and average (rounded to two decimal places).

using System;
using System.Collections.Generic;
using System.Linq;

namespace Problem_3_Min__Max__Average
{
    class Program
    {
        static void Main()
        {
            List<double> roundNumbers = new List<double>();
            List<double> flopNumbers = new List<double>();
            List<double> inputList = new List<double>();

            string[] input = Console.ReadLine().Split(' ');

            for (int i = 0; i < input.Length; i++)
            {
                inputList.Add(double.Parse(input[i]));
            }

            for (int i = 0; i < inputList.ToArray().Length; i++)
            {
                if (inputList[i] % 1 == 0)
                {
                    roundNumbers.Add(inputList[i]);
                }
                else
                {
                    flopNumbers.Add(inputList[i]);
                }
            }
            
            for (int i = 0; i < flopNumbers.ToArray().Length; i++)
            {
                if (i == 0)
                {
                    Console.Write("[");
                }
                if (i == flopNumbers.ToArray().Length - 1)
                {
                    Console.Write(flopNumbers[i] + "] -> min: {0}, max: {1}, sum: {2}, avg: {3:F2}", flopNumbers.Min(), flopNumbers.Max(), flopNumbers.Sum(), flopNumbers.Average());
                    Console.WriteLine();
                    break;
                }
                Console.Write(flopNumbers[i] + ", ");
            }

            for (int i = 0; i < roundNumbers.ToArray().Length; i++)
            {
                if (i == 0)
                {
                    Console.Write("[");
                }
                if (i == roundNumbers.ToArray().Length - 1)
                {
                    Console.Write(roundNumbers[i] + "] -> min: {0}, max: {1}, sum: {2}, avg: {3:F2}", roundNumbers.Min(), roundNumbers.Max(), roundNumbers.Sum(), roundNumbers.Average());
                    Console.WriteLine();
                    break;
                }
                Console.Write(roundNumbers[i] + ", ");
            }
        }
    }
}
