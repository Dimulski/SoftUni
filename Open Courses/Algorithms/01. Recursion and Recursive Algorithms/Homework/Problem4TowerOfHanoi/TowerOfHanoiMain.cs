using System;
using System.Collections.Generic;
using System.Linq;

namespace Problem4TowerOfHanoi
{
    class TowerOfHanoiMain
    {
        static int steps = 0;
        static Stack<int> source;
        static Stack<int> destination = new Stack<int>();
        static Stack<int> spare = new Stack<int>();

        public static void Main()
        {
            Console.Write("Please enter desired number of disks: ");
            int numberOfDisks = int.Parse(Console.ReadLine());
            source = new Stack<int>(Enumerable.Range(1, numberOfDisks).Reverse());
            PrintRods();
            MoveDisks(numberOfDisks, source, destination, spare);
        }

        private static void MoveDisks(int bottomDisk, Stack<int> sourceRod, Stack<int> destinationRod, Stack<int> spareRod)
        {
            if (bottomDisk < 1)
            {
                return;
            }
            else if (bottomDisk == 1)
            {
                steps++;
                destinationRod.Push(sourceRod.Pop());
                Console.WriteLine($"Step #{steps}: Moved disk {bottomDisk}");
                PrintRods();
                return;
            }
            else
            {
                MoveDisks(bottomDisk - 1, sourceRod, spareRod, destinationRod);
                steps++;
                destinationRod.Push(sourceRod.Pop());
                Console.WriteLine($"Step #{steps}: Moved disk {bottomDisk}");
                PrintRods();
                MoveDisks(bottomDisk - 1, spareRod, destinationRod, sourceRod);
            }
        }

        private static void PrintRods()
        {
            Console.WriteLine("Source: {0}", string.Join(", ", source.Reverse()));
            Console.WriteLine("Destination: {0}", string.Join(", ", destination.Reverse()));
            Console.WriteLine("Spare: {0}", string.Join(", ", spare.Reverse()));
            Console.WriteLine();
        }
    }
}
