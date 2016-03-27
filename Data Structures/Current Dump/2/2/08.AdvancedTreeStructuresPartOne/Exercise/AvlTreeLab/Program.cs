using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AvlTreeLab
{
    class Program
    {
        static void Main(string[] args)
        {
            AvlTree<int> tree = new AvlTree<int>();
            tree.Add(6472);
            tree.Add(2788);
            tree.Add(8199);
            tree.Add(9256);
            tree.Add(1404);
            tree.Add(3397);
            tree.Add(809);
            PrintTree(tree.root);
        }

        private static void PrintTree(Node<int> node, int space = 0)
        {
            if (node.LeftChild != null)
            {
                PrintTree(node.LeftChild, space + 1);
            }

            Console.WriteLine("{0}{1}{2}", new string('-', space), node.Value, node.Parent == null ? "(root)" : "(" + node.Parent.Value + ")");

            if (node.RightChild != null)
            {
                PrintTree(node.RightChild, space + 1);
            }
        }
    }
}
