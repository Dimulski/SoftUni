// Write a program that creates a letter. It takes as input the sender and the receiver and prints a formatted output on the console.

using System;

namespace Letter_Creator
{
    class Program
    {
        private static void Main()
        {
            string sender = Console.ReadLine();
            string receiver = Console.ReadLine();
            PrintLetter(sender, receiver);
        }

        static void PrintLetter(string sender, string receiver)
        {
            string time = string.Format("{0:dd MMM, yyyy}", DateTime.Now);
            Console.WriteLine("Dear {0}", receiver);
            Console.WriteLine("I hope I find you in good health. \nI need to inform you that the cheese has run away. \nSincerely,{0}!", sender);
            Console.WriteLine("{0}",time);
        }
    }
}
