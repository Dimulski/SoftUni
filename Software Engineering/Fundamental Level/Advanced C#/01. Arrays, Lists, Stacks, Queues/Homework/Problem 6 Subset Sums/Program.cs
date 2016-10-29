// Write a program that reads from the console a number N and an array of integers given on a single line.
// Your task is to find all subsets within the array which have a sum equal to N and print them on the console
// (the order of printing is not important). Find only the unique subsets by filtering out repeating numbers first.
// In case there aren't any subsets with the desired sum, print "No matching subsets."

using System;
using System.Collections.Generic;
using System.Linq;

namespace Problem_6_Subset_Sums
{
    class Program
    {
        static void Main()
        {
            int sum = int.Parse(Console.ReadLine());
            int[] input = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();
            bool isMatch = false;
            List<int> subset = new List<int>();

            int combinations = (int)Math.Pow(2, input.Length);
            for (int mask = 0; mask < combinations; mask++)
            {
                for (int j = 0; j < input.Length; j++)
                {
                    if ((mask & (1 << j)) != 0)
                    {
                        subset.Add(input[j]);
                    }
                }
                if (subset.Sum() == sum)
                {
                    Console.WriteLine("{0} = {1}", string.Join(" + ", subset), sum);
                    isMatch = true;
                }
                subset.Clear();
            }
            if (isMatch == false)
            {
                Console.WriteLine("No matching subsets.");
            }
        }
    }
}
