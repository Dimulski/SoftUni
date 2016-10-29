// Write a program to read an array of numbers from the console, sort them and print them back on the console.
// The numbers should be entered from the console on a single line, separated by a space.

using System;
using System.Collections.Generic;

namespace Problem_1_Sort_Arr_of_Numbers
{
    class Program
    {
        static void Main()
        {
            string[] input = Console.ReadLine().Split(' ');

            List<int> inputList = new List<int>();

            for (int i = 0; i < input.Length; i++)
            {
                inputList.Add(int.Parse(input[i]));
            }

            inputList.Sort();

            for (int i = 0; i < inputList.ToArray().Length; i++)
            {
                Console.Write(inputList[i] + " ");
            }
        }
    }
}
