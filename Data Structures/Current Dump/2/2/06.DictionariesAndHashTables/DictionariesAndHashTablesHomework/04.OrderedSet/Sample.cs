namespace _04.OrderedSet
{
    using System;

    public class Sample
    {
        public static void Main()
        {
            var set = new OrderedSet<int>();
            set.Add(17);
            set.Add(9);
            set.Add(12);
            set.Add(19);
            set.Add(6);
            set.Add(25);
            set.Remove(12);
            set.Remove(6);
            set.Add(0);

            Console.Write("Elements: ");
            foreach (var item in set)
            {
                Console.Write(item + " ");
            }

            Console.WriteLine();
            Console.WriteLine("Count: {0}", set.Count);
            Console.WriteLine("Contains 12: {0}", set.Contains(12));
            Console.WriteLine("Contains 17: {0}", set.Contains(17));
        }
    }
}
