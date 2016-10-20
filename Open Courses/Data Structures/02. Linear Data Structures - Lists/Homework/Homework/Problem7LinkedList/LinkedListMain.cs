namespace Problem7LinkedList
{
    using System;

    class LinkedListMain
    {
        static void Main()
        {
            var linkedList = new LinkedList<int>();

            linkedList.Add(0);
            linkedList.Add(1);
            linkedList.Add(2);
            linkedList.Add(3);

            Console.WriteLine("Number of elements: {0}\nIterating:", linkedList.Count);

            foreach (var element in linkedList)
            {
                Console.WriteLine(element);
            }

            linkedList.Remove(1);

            Console.WriteLine("Number of elements: {0}\nIterating:", linkedList.Count);

            foreach (var element in linkedList)
            {
                Console.WriteLine(element);
            }

            linkedList.Add(0);

            Console.WriteLine("Iterating:");

            foreach (var element in linkedList)
            {
                Console.WriteLine(element);
            }

            int firstIndexOfZero = linkedList.FirstIndexOf(0);
            int lastIndexOfZero = linkedList.LastIndexOf(0);

            Console.WriteLine("First index of zero: {0}; Last index of zero: {1}", firstIndexOfZero, lastIndexOfZero);
        }
    }
}
