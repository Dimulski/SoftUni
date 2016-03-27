namespace _04.LongestPathInTree
{
    using System;
    using System.Collections.Generic;
    using System.Linq;

    public class LongestPathInTree
    {
        private static Dictionary<int, Node<int>> nodes = new Dictionary<int, Node<int>>();
        private static int longestSubtreePath = int.MinValue;

        public static void Main()
        {
            ReadNodes();
            var root = FindRoot();
            int longestPath = FindLongestPath(root);
            Console.WriteLine("Longest path: {0}", longestPath);
        }

        private static int FindLongestPath(Node<int> startNode)
        {
            int firstLongestPath = int.MinValue;
            int secondLongestPath = int.MinValue;

            foreach (var child in startNode.Children)
            {
                longestSubtreePath = 0;
                int currSubtreePath = FindLongestPathInSubtree(child);
                if (firstLongestPath < currSubtreePath || secondLongestPath < currSubtreePath)
                {
                    if (firstLongestPath < secondLongestPath)
                    {
                        firstLongestPath = currSubtreePath;
                    }
                    else
                    {
                        secondLongestPath = currSubtreePath;
                    }
                }
            }

            return firstLongestPath + secondLongestPath + startNode.Value;
        }

        private static Node<int> FindRoot()
        {
            foreach (var nodeValue in nodes.Keys)
            {
                if (nodes[nodeValue].Parent == null)
                {
                    return nodes[nodeValue];
                }
            }

            return null;
        }

        private static int FindLongestPathInSubtree(Node<int> startNode, int currPath = 0)
        {
            if (currPath + startNode.Value > longestSubtreePath && startNode.Children.Count == 0)
            {
                longestSubtreePath = currPath + startNode.Value;
            }

            foreach (var child in startNode.Children)
            {
                FindLongestPathInSubtree(child, currPath + startNode.Value);
            }

            return longestSubtreePath;
        }

        private static void ReadNodes()
        {
            int numberOfNodes = int.Parse(Console.ReadLine());
            int numberOfEdges = int.Parse(Console.ReadLine());
            for (int currEdge = 0; currEdge < numberOfEdges; currEdge++)
            {
                var args = Console.ReadLine()
                    .Split(new[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                    .Select(int.Parse)
                    .ToArray();
                int parentValue = args[0];
                int childValue = args[1];

                if (!nodes.ContainsKey(parentValue))
                {
                    nodes.Add(parentValue, new Node<int>(parentValue));
                }

                if (!nodes.ContainsKey(childValue))
                {
                    nodes.Add(childValue, new Node<int>(childValue));   
                }

                nodes[parentValue].Children.Add(nodes[childValue]);
                nodes[childValue].Parent = nodes[parentValue];
            }
        }
    }
}
