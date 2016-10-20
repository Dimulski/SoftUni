namespace Problem9SequenceNToM
{
    using System;
    using System.Collections.Generic;
    using System.Linq;

    class SequenceNToMMain
    {
        static void Main()
        {
            bool solutionFound = false;

            var input = Console.ReadLine().Split().Select(int.Parse).ToArray();

            var n = input[0];
            var m = input[1];

            var firstItem = new Item(n, null);
            var itemQueue = new Queue<Item>();
            itemQueue.Enqueue(firstItem);

            while (itemQueue.Count > 0)
            {
                var currentItem = itemQueue.Dequeue();
                if (currentItem.Value < m)
                {
                    itemQueue.Enqueue(new Item(currentItem.Value + 1, currentItem));
                    itemQueue.Enqueue(new Item(currentItem.Value + 2, currentItem));
                    itemQueue.Enqueue(new Item(currentItem.Value * 2, currentItem));
                }
                else if (currentItem.Value == m)
                {
                    PrintSolution(currentItem);
                    solutionFound = true;
                    break;
                }
            }

            if (solutionFound == false)
            {
                Console.WriteLine("(no solution)");
            }
        }

        private static void PrintSolution(Item item)
        {
            var stack = new Stack<int>();

            while (item != null)
            {
                stack.Push(item.Value);

                item = item.PreviousItem;
            }

            while (stack.Count > 0)
            {
                if (stack.Count == 1)
                {
                    Console.WriteLine(stack.Pop());
                }
                else
                {
                    Console.Write(stack.Pop() + " -> ");
                }
            }
        }
    }
}
