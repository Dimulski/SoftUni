namespace OrderedSet
{
    using System;

    class Test
    {
        static void Main()
        {
            OrderedSet<int> set = new OrderedSet<int>();

            set.Add(1);
            set.Add(2);
            set.Add(300);

            Console.WriteLine("Count " + set.Count);
            Console.WriteLine("Contains element " + set.Contains(20));

            foreach (var element in set)
            {
                Console.WriteLine(element);
            }
        }
    }
}
