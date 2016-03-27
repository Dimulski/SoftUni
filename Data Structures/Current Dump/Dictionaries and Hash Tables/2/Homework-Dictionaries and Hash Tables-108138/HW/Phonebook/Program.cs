namespace Phonebook
{
    using System;
    using CustomDictionary;

    public class Program
    {
        public static void Main(string[] args)
        {
            var phonebook = new CustomDictionary<string, string>();
            string input = Console.ReadLine();
            while (input != "search")
            {
                string[] data = input.Split('-');
                phonebook.AddOrReplace(data[0], data[1]);
                input = Console.ReadLine();
            }
            input = Console.ReadLine();
            while (!string.IsNullOrEmpty(input))
            {
                if (phonebook.ContainsKey(input))
                {
                    Console.WriteLine(phonebook.Find(input));
                }
                else
                {
                    Console.WriteLine(string.Format("Contact {0} does not exist.", input));
                }
                
                input = Console.ReadLine();
            }
        }
    }
}
