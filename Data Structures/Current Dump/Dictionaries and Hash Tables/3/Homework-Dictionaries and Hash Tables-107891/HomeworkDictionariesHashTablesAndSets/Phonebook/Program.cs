using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Dictionary;

namespace Phonebook
{
    internal class Program
    {
        private static void Main()
        {
            var phoneBook = new HashTable<string, string>();

            var input = Console.ReadLine();

            while (input != "search")
            {
                var splittedInput = input.Split('-');
                var name = splittedInput[0].Trim();
                var number = splittedInput[1].Trim();

                phoneBook.AddOrReplace(name, number);

                input = Console.ReadLine();
            }

            var searchedContacts = Console.ReadLine();

            while (searchedContacts != "end")
            {
                if (phoneBook.ContainsKey(searchedContacts))
                {
                    Console.WriteLine("{0} -> {1}", searchedContacts, phoneBook[searchedContacts]);
                }
                else
                {
                    Console.WriteLine("Contact {0} does not exist", searchedContacts);
                }

                searchedContacts = Console.ReadLine();
            }
        }
    }
}
