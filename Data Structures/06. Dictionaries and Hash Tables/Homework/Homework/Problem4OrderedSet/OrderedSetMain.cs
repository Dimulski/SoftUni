using System;

namespace Problem4OrderedSet
{
    public class OrderedSetMain
    {
        public static void Main()
        {
            var set = new BinarySearchTree();
            set.Add(17);
            set.Add(9);
            set.Add(12);
            set.Add(19);
            set.Add(6);
            set.Add(25);
            foreach (Node item in set)
            {
                Console.WriteLine(item);
            }
        }
    }
}

