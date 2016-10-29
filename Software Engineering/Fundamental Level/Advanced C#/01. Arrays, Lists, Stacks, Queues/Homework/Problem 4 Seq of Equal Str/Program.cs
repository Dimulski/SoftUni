// Write a program that reads an array of strings and finds in it all sequences of equal elements
// (comparison should be case-sensitive). The input strings are given as a single line, separated by a space.

using System;
using System.Collections.Generic;

namespace Problem_4_Seq_of_Equal_Str
{
    class Program
    {
        static void Main()
        {
            string[] input = Console.ReadLine().Split(' ');
            List<string> inputList = new List<string>();
            for (int i = 0; i < input.Length; i++)
            {
                inputList.Add(input[i]);
            }
            
            for (int i = 0; i <= inputList.ToArray().Length - 1; i++)
            {
                if (inputList.ToArray().Length == 1)
                {
                    Console.WriteLine(inputList[0]);
                    break;
                }
                if (i == inputList.ToArray().Length - 1)
                {
                    if (inputList[i] == inputList[i - 1])
                    {
                        Console.Write(inputList[i]);
                        break;
                    }
                    else
                    {
                        Console.WriteLine(inputList[i]);
                        break;
                    }
                }
                if (inputList[i] != inputList[i + 1])
                {
                    Console.WriteLine(inputList[i]);
                    continue;
                }
                Console.Write(inputList[i] + " ");
            }
        }
    }
}
