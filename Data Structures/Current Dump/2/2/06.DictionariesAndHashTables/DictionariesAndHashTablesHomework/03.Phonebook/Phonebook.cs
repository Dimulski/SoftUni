namespace _03.Phonebook
{
    using System;
    using _01.Dictionary;

    public class Phonebook
    {
        public static void Main()
        {
            var phonebook = new CustomDictionary<string, string>();

            string phoneEntry = Console.ReadLine();
            while (!phoneEntry.Equals("search"))
            {
                var args = phoneEntry.Split('-');
                string person = args[0];
                string phoneNumber = args[1];
                phonebook[person] = phoneNumber;

                phoneEntry = Console.ReadLine();
            }

            string contact = Console.ReadLine();
            while (!contact.Equals(string.Empty))
            {
                if (!phonebook.ContainsKey(contact))
                {
                    Console.WriteLine("Contact {0} does not exist.", contact);
                }
                else
                {
                    Console.WriteLine("{0} -> {1}", contact, phonebook[contact]);
                }

                contact = Console.ReadLine();
            }
        }
    }
}
