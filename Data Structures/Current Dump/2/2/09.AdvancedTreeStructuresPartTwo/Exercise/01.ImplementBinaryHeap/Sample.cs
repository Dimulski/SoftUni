namespace _01.ImplementBinaryHeap
{
    using System;

    public class Sample
    {
        public static void Main()
        {
            var binaryHeap = new BinaryHeap<int>();
            binaryHeap.Insert(100);
            binaryHeap.Insert(12);
            binaryHeap.Insert(1);
            binaryHeap.Insert(213);
            binaryHeap.Insert(3);
            binaryHeap.Insert(14);

            while (binaryHeap.Count > 0)
            {
                Console.WriteLine(binaryHeap.ExtractMax());
            }
        }
    }
}
