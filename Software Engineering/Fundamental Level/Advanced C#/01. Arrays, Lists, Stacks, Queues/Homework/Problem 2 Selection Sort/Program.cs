// Write a program to sort an array of numbers and then print them back on the console.The numbers should be
// entered from the console on a single line, separated by a space. Refer to the examples for problem 1.

using System;
using System.Collections.Generic;

namespace Problem_2_Selection_Sort
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

            int minPosition, temp;

            for (int i = 0; i < inputList.ToArray().Length - 1; i++)
            {
                minPosition = i;

                for (int j = i + 1; j < inputList.ToArray().Length; j++)
                {
                    if (inputList[j] < inputList[minPosition])
                    {
                        minPosition = j;
                    }
                }

                if (minPosition != i)
                {
                    temp = inputList[i];
                    inputList[i] = inputList[minPosition];
                    inputList[minPosition] = temp;
                }
            }

            for (int i = 0; i < inputList.ToArray().Length; i++)
            {
                Console.Write(inputList[i] + " ");
            }
        }
    }
}
