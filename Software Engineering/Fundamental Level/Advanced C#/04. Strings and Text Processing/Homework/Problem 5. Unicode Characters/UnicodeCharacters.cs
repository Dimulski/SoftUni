// Write a program that converts a string to a sequence of C# Unicode character literals.

using System;
using System.Text;

namespace Problem_5.Unicode_Characters
{
    class UnicodeCharacters
    {

        static void Main()
        {
            string input = Console.ReadLine();
            StringBuilder sb = new StringBuilder();
            foreach (var character in input)
            {
                sb.Append("\\u");
                sb.Append(String.Format("{0:x4}", (int)character)); ;
            }
            Console.WriteLine(sb.ToString());
        }
    }
}
