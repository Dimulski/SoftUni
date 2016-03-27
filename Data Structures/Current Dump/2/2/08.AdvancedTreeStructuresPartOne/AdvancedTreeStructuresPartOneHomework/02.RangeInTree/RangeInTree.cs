namespace _02.RangeInTree
{
    using System;
    using System.Collections.Generic;
    using System.Linq;
    using _01.AVLTree;

    public class RangeInTree
    {
        public static void Main()
        {
            var tree = GetAVLTree();
            string[] range = Console.ReadLine().Split(new[] {' '}, StringSplitOptions.RemoveEmptyEntries);
            int from = int.Parse(range[0]);
            int to = int.Parse(range[1]);
            IList<int> numbersInRange = tree.Range(from, to).ToList();
            Console.WriteLine(numbersInRange.Count == 0 ? "(empty)" : string.Join(" ", numbersInRange));
        }

        private static AVLTree<int> GetAVLTree()
        {
            AVLTree<int> tree = new AVLTree<int>();
            string[] elements = Console.ReadLine().Split(new[] {' '}, StringSplitOptions.RemoveEmptyEntries);
            foreach (var element in elements)
            {
                tree.Add(int.Parse(element));
            }

            return tree;
        }
    }
}
