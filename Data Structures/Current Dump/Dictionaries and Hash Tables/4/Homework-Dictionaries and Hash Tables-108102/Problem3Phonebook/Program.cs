namespace Problem3Phonebook
{
    using System;
    using System.Collections.Generic;
    using Dictionary;

    class Program
    {
        static void Main()
        {
            MyDictionary<string, string> phonebook = new MyDictionary<string, string>();

            string input = Console.ReadLine();

            while (input != "search")
            {
                string[] data = input.Split('-');

                string name = data[0];
                string phone = data[1];

                phonebook[name] = phone;
                
                input = Console.ReadLine();
            }

            input = Console.ReadLine();

            while (input != "end")
            {
                string name = input;

                if (phonebook.ContainsKey(name))
                {
                    Console.WriteLine("{0} -> {1}", name, phonebook[name]);   
                    
                }
                else
                {
                    Console.WriteLine("Contant {0} does not exist", name);
                }

                input = Console.ReadLine();
            }
        }
    }
}
