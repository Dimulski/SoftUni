// Write a program to find all increasing sequences inside an array of integers. The integers are given on a single
// line, separated by a space. Print the sequences in the order of their appearance in the input array,
// each at a single line. Separate the sequence elements by a space. Find also the longest increasing sequence and
// print it at the last line. If several sequences have the same longest length, print the left-most of them.

using System;
using System.Collections.Generic;
using System.Linq;

namespace Problem_5_Longest_Incr_Seq
{
    class Program
    {
        static void Main()
        {
            int[] input = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();
            List<int> ls = new List<int>();

            int counter = 1;
            ls.Add(input[0]);

            Console.Write(input[0] + " ");
            for (int i = 1; i < input.Length; i++)
            {
                if (input[i] > input[i - 1])
                {
                    counter++;
                    Console.Write(input[i] + " ");
                }
                else
                {
                    if (counter > ls.Count)
                    {
                        ls.Clear();
                        for (int j = i - counter; j < i; j++)
                        {
                            ls.Add(input[j]);
                        }
                    }
                    counter = 1;
                    Console.WriteLine();
                    Console.Write(input[i] + " ");
                }
            }
            Console.WriteLine();
            Console.WriteLine("Longest: " + string.Join(" ", ls));
        }
    }
}
