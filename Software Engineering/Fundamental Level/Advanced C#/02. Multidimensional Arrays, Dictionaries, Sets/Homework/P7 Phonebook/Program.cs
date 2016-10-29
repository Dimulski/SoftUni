// Write a program that receives some info from the console about people and their phone numbers.
// You are free to choose the manner in which the data is entered; each entry should have just one name and one number (both of them strings). 
// After filling this simple phonebook, upon receiving the command "search", your program should be able to perform a search of a contact by
// name and print her details in format "{name} -> {number}". In case the contact isn't found, print "Contact {name} does not exist."

using System;
using System.Collections.Generic;

namespace P7_Phonebook
{
    class Program
    {
        static void Main()
        {
            string line = Console.ReadLine().Trim();

            Dictionary<string, string> phonebook = new Dictionary<string, string>();
            while (!line.Equals("search"))
            {
                string[] items = line.Split('-');

                if (phonebook.ContainsKey(items[0]))
                    phonebook.Remove(items[0]);
                phonebook.Add(items[0], items[1]);

                line = Console.ReadLine().Trim();
            }

            line = Console.ReadLine().Trim();
            while (line.Length > 0)
            {
                if (phonebook.ContainsKey(line))
                    Console.WriteLine("{0} -> {1}", line, phonebook[line]);
                else
                    Console.WriteLine("Contact {0} does not exist.", line);

                line = Console.ReadLine().Trim();
            }
        }
    }
}
