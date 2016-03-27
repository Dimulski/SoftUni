namespace _09.SequenceNM
{
    using System;
    using System.Collections.Generic;

    public class SequenceNM
    {
        public static void Main()
        {
            Console.Write("Start number: ");
            int startNumber = int.Parse(Console.ReadLine());
            Console.Write("End number: ");
            int endNumber = int.Parse(Console.ReadLine());
            var sequence = new Queue<Item<int>>();
            var firstItem = new Item<int>(startNumber);
            sequence.Enqueue(firstItem);

            while (sequence.Count > 0)
            {
                var currItem = sequence.Dequeue();

                if (currItem.Value < endNumber)
                {
                    sequence.Enqueue(new Item<int>(currItem.Value + 1, currItem));
                    sequence.Enqueue(new Item<int>(currItem.Value + 2, currItem));
                    sequence.Enqueue(new Item<int>(2 * currItem.Value, currItem));
                }
                else if (currItem.Value == endNumber)
                {
                    PrintSequence(currItem);
                    return;
                }
            }

            Console.WriteLine("(no solution)");
        }

        private static void PrintSequence(Item<int> lastItem)
        {
            var sequence = new Stack<int>();
            var currItem = lastItem;
            while (currItem != null)
            {
                sequence.Push(currItem.Value);
                currItem = currItem.Previous;
            }

            Console.WriteLine(string.Join(" -> ", sequence));
        }
    }
}
