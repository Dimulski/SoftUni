namespace Problem3Phonebook
{
    using System;
    using System.Collections.Generic;
    using System.Linq;

    using Problem1Dictionary;

    public class PhonebookMain
    {
        static void Main()
        {
            var dictionary = new MyDictionary<string, string>();
            var inputLine = Console.ReadLine();
            while (inputLine != "search")
            {
                var inputParams = inputLine.Split('-').ToArray();
                var name = inputParams[0];
                var number = inputParams[1];
                dictionary.Add(name, number);
                inputLine = Console.ReadLine();
            }
            var contact = Console.ReadLine();
            while (true)
            {
                try
                {
                    Console.WriteLine("{0} -> {1}", contact, dictionary[contact]);
                }
                catch (KeyNotFoundException)
                {

                    Console.WriteLine("Contact {0} does not exist.", contact); 
                }
                contact = Console.ReadLine();
            }
        }
    }
}
