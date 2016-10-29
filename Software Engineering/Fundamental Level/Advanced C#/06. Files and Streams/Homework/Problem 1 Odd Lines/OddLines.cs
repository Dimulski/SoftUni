// Write a program that reads a text file and prints on the console its odd lines. Line numbers starts from 0. Use StreamReader.

using System;
using System.IO;

namespace Problem_1_Odd_Lines
{
    class OddLines
    {
        static void Main()
        {
            StreamReader reader = new StreamReader("ayy lmao.txt");
            using (reader)
            {
                int lineNumber = 0;
                string line = reader.ReadLine();
                while (line != null)
                {
                    if (lineNumber % 2 != 0)
                    {
                        Console.WriteLine("Line {0}: {1}", lineNumber, line);
                    }
                    lineNumber++;
                    line = reader.ReadLine();
                }
            }
        }
    }
}
