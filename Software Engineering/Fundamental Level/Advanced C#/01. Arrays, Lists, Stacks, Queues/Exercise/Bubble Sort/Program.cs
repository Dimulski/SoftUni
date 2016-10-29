// Write a program to sort an array of integer numbers and then print them back on the console. 
// The numbers should be entered from the console on a single line, separated by a space. 
// Print the sorted array in the following format: “[element1, element2… elementN]”.

using System;
using System.Collections.Generic;

namespace Bubble_Sort
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

            List<int> inputListSorted = BubbleSort(inputList);
            for (int i = 0; i < inputListSorted.ToArray().Length; i++)
            {
                Console.WriteLine(inputListSorted[i]);
            }
            Console.ReadLine();
        }

        private static List<int> BubbleSort(List<int> inputList)
        {
            for (int i = 0; i < inputList.ToArray().Length - 1; i++)
            {
                for (int j = 0; j < inputList.ToArray().Length - 1 - i; j++)
                {
                    if (inputList[j] > inputList[j + 1])
                    {
                        int temp = inputList[j];
                        inputList[j] = inputList[j + 1];
                        inputList[j + 1] = temp;
                    }
                }
            }
            return inputList;
        }
    }
}