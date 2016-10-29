// Write a program that takes as input two lists of integers and joins them.The result should hold all numbers from
// the first list, and all numbers from the second list, without repeating numbers, and arranged in increasing order. 
// The input and output lists are given as integers, separated by a space, each list at a separate line. 
// Do not use LINQ! This problems aims to help you exercise your algorithmic thinking and not how well you are familiar
// with built-in .NET functionalities. Use only arrays and lists.

using System;
using System.Collections.Generic;

namespace Join_Lists
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] input1 = Console.ReadLine().Split(' ');
            List<int> intList1 = new List<int>();
            for (int i = 0; i < input1.Length; i++)
            {
                intList1.Add(int.Parse(input1[i]));
            }

            string[] input2 = Console.ReadLine().Split(' ');
            List<int> intList2 = new List<int>();
            for (int i = 0; i < input2.Length; i++)
            {
                intList2.Add(int.Parse(input2[i]));
            }

            List<int> combinedList = new List<int>();

            for (int i = 0; i < intList1.ToArray().Length; i++)
            {
                combinedList.Add(intList1[i]);
            }
            for (int i = 0; i < intList2.ToArray().Length; i++)
            {
                combinedList.Add(intList2[i]);
            }

            combinedList.Sort();

            for (int i = 0; i < combinedList.ToArray().Length - 1; i++)
            {
                if (i == combinedList.ToArray().Length - 1)
                {
                    Console.WriteLine(i);
                    break;
                }
                if (combinedList[i] == combinedList[i + 1])
                {
                    combinedList.Remove(combinedList[i]);
                    i -= 1;
                }
            }

            for (int i = 0; i < combinedList.ToArray().Length; i++)
            {
                Console.WriteLine(combinedList[i]);
            }

        }
    }
}
