namespace _01.PlayWithTrees
{
    using System;
    using System.Collections.Generic;
    using System.Linq;

    public class PlayWithTrees
    {
        private static Dictionary<int, Tree<int>> nodeByValue = new Dictionary<int, Tree<int>>();
        private static IList<Tree<int>> longestPath = new List<Tree<int>>();

        public static void Main()
        {
            int numberOfNodes = int.Parse(Console.ReadLine());
            for (int i = 1; i < numberOfNodes; i++)
            {
                string[] edge = Console.ReadLine().Split();
                int parentValue = int.Parse(edge[0]);
                var parentNode = GetTreeNodeByValue(parentValue);
                int childValue = int.Parse(edge[1]);
                var childNode = GetTreeNodeByValue(childValue);

                parentNode.Children.Add(childNode);
                childNode.Parent = parentNode;
            }

            var root = FindRootNode();
            Console.WriteLine("Root: {0}", root.Value);
            var leafNodes = FindLeafNodes();
            leafNodes = SortTreeNodes(leafNodes);
            Console.WriteLine("Leaf nodes: {0}", string.Join(", ", GetTreeNodeValues(leafNodes)));
            var middleNodes = FindMiddleNodes();
            middleNodes = SortTreeNodes(middleNodes);
            Console.WriteLine("Middle nodes: {0}", string.Join(", ", GetTreeNodeValues(middleNodes)));
            var longestPathList = FindLongestPath(root);
            Console.WriteLine("Longest Path: {0} (length = {1})",
                string.Join(" -> ", GetTreeNodeValues(longestPathList)),
                longestPath.Count);
        }

        private static Tree<int> GetTreeNodeByValue(int value)
        {
            if (!nodeByValue.ContainsKey(value))
            {
                nodeByValue[value] = new Tree<int>(value);
            }

            return nodeByValue[value];
        }

        private static Tree<int> FindRootNode()
        {
            var root = nodeByValue.Values.FirstOrDefault(n => n.Parent == null);

            return root;
        }

        private static IEnumerable<Tree<int>> FindLeafNodes()
        {
            var leafNodes = nodeByValue.Values
                .Where(n => n.Children.Count == 0)
                .ToList();

            return leafNodes;
        }

        private static IEnumerable<Tree<int>> FindMiddleNodes()
        {
            var middleNodes = nodeByValue.Values
                .Where(n => n.Children.Count > 0 && n.Parent != null)
                .ToList();

            return middleNodes;
        }

        private static IEnumerable<Tree<int>> SortTreeNodes(IEnumerable<Tree<int>> nodes)
        {
            nodes = nodes.OrderBy(n => n.Value).ToList();

            return nodes;
        }

        private static IEnumerable<Tree<int>> FindLongestPath(Tree<int> startNode, int longestPathLength = 0)
        {
            var path = new List<Tree<int>>();
            var currNode = startNode;
            while (currNode != null)
            {
                path.Add(currNode);
                currNode = currNode.Parent;
            }

            if (path.Count > longestPathLength)
            {
                longestPath = path;
            }

            foreach (var child in startNode.Children)
            {
                FindLongestPath(child, longestPath.Count);
            }

            return longestPath.Reverse();
        }

        private static IList<int> GetTreeNodeValues(IEnumerable<Tree<int>> nodes)
        {
            var nodeValues = new List<int>();
            foreach (var node in nodes)
            {
                nodeValues.Add(node.Value);
            }

            return nodeValues;
        }
    }
}
