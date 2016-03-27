namespace _03Phonebook
{
    using System;
    using _01Dictionary;

    class Program
    {
        static void Main()
        {
            var phonebook = new Dictionary<string, string>();
            var input = Console.ReadLine();
            while (input != "search")
            {
                var data = input.Split('-');
                phonebook[data[0]] = data[1];
                input = Console.ReadLine();
            }

            input = Console.ReadLine();
            while (!string.IsNullOrEmpty(input))
            {
                var item = phonebook.Find(input);
                if (item != null)
                {
                    Console.WriteLine(item);
                }
                else
                {
                    Console.WriteLine("Contact {0} does not exist", input);
                }

                input = Console.ReadLine();
            }
        }
    }
}
