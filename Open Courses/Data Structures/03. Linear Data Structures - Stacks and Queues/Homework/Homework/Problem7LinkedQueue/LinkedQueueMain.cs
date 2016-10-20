namespace Problem7LinkedQueue
{
    using System;

    class LinkedQueueMain
    {
        static void Main()
        {
            var queue = new LinkedQueue<int>();

            queue.Enqueue(1);
            queue.Enqueue(2);
            queue.Enqueue(3);
            queue.Enqueue(4);

            var array = queue.ToArray();

            foreach (var i in array)
            {
                Console.WriteLine(i);
            }
        }
    }
}
