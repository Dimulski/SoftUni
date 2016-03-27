namespace P01_PlayWithTrees
{
    using System;
    using System.Collections.Generic;
    using System.Linq;

    public class PlayWithTrees
    {
        private static Dictionary<int, Tree<int>> nodeByValue = new Dictionary<int, Tree<int>>();

        private static List<Tree<int>> treesEqualSum = new List<Tree<int>>();

        public static void Main()
        {
            int nodeCount = int.Parse(Console.ReadLine());
            for (int i = 1; i < nodeCount; i++)
            {
                string[] edge = Console.ReadLine().Split();
                int parentValue = int.Parse(edge[0]);
                Tree<int> parentNode = GetTreeNodeByValue(parentValue);
                int childValue = int.Parse(edge[1]);
                Tree<int> childNode = GetTreeNodeByValue(childValue);
                parentNode.Children.Add(childNode);
                childNode.Parent = parentNode;
            }

            int pathSum = int.Parse(Console.ReadLine());
            int subtreeSum = int.Parse(Console.ReadLine());

            Tree<int> rootNode = FindRootNode();
            Console.WriteLine("Root node: {0}", rootNode.Value);

            var leafNodes = FindLeafNodes();
            var leafNodesValues = leafNodes.OrderBy(node => node.Value).Select(node => node.Value);
            Console.WriteLine("Leaf nodes: {0}", string.Join(", ", leafNodesValues));

            var middleNodesValues = FindMiddleNodes().OrderBy(node => node.Value).Select(node => node.Value);
            Console.WriteLine("Middle nodes: {0}", string.Join(", ", middleNodesValues));

            Stack<Tree<int>> longestPath = FindLongestPath(leafNodes);
            var longestPathValues = longestPath.Select(node => node.Value);
            Console.WriteLine(
                "Longest path:{0}{1} (length = {2})",
                Environment.NewLine,
                string.Join(" -> ", longestPathValues),
                longestPathValues.Count());

            List<Stack<Tree<int>>> pathSums = FindPathSums(leafNodes, pathSum);
            Console.WriteLine("Paths of sum {0}:", pathSum);
            foreach (var stack in pathSums)
            {
                var stackValues = stack.Select(node => node.Value);
                Console.WriteLine(string.Join(" -> ", stackValues));
            }

            FindTreeSums(rootNode, subtreeSum);
            PrintTreeSumsNodes();
        }

        public static Tree<int> GetTreeNodeByValue(int value)
        {
            if (!nodeByValue.ContainsKey(value))
            {
                nodeByValue[value] = new Tree<int>(value);
            }

            return nodeByValue[value];
        }

        public static Tree<int> FindRootNode()
        {
            var rootNode = nodeByValue.Values.FirstOrDefault(node => node.Parent == null);

            return rootNode;
        }

        public static IEnumerable<Tree<int>> FindLeafNodes()
        {
            var leafNodes = nodeByValue.Values.Where(
                node => node.Children.Count == 0 && node.Parent != null);

            return leafNodes;
        }

        public static IEnumerable<Tree<int>> FindMiddleNodes()
        {
            var middleNodes = nodeByValue.Values.Where(
                node => node.Children.Count > 0 && node.Parent != null);

            return middleNodes;
        }

        public static Stack<Tree<int>> FindLongestPath(IEnumerable<Tree<int>> leaftNodes)
        {
            Stack<Tree<int>> longestPath = new Stack<Tree<int>>();
            foreach (Tree<int> leafNode in leaftNodes)
            {
                Stack<Tree<int>> currentPath = new Stack<Tree<int>>();
                Tree<int> currentNode = leafNode;

                while (currentNode != null)
                {
                    currentPath.Push(currentNode);
                    currentNode = currentNode.Parent;
                }

                if (longestPath.Count < currentPath.Count)
                {
                    longestPath = currentPath;
                }
            }

            return longestPath;
        }

        public static List<Stack<Tree<int>>> FindPathSums(IEnumerable<Tree<int>> leaftNodes, int pathSum)
        {
            List<Stack<Tree<int>>> pathSums = new List<Stack<Tree<int>>>();
            foreach (Tree<int> leafNode in leaftNodes)
            {
                Stack<Tree<int>> currentPath = new Stack<Tree<int>>();
                Tree<int> currentNode = leafNode;
                int currentSum = 0;

                while (currentNode != null)
                {
                    currentSum += currentNode.Value;
                    currentPath.Push(currentNode);
                    currentNode = currentNode.Parent;
                }

                if (currentSum == pathSum)
                {
                    pathSums.Add(currentPath);
                }
            }

            return pathSums;
        }
        
        public static void FindTreeSums(Tree<int> node, int sum)
        {
            int nodeSum = 0;
            CalculateTreeSum(node, ref nodeSum);

            if (nodeSum == sum)
            {
                treesEqualSum.Add(node);
            }

            foreach (Tree<int> child in node.Children)
            {
                FindTreeSums(child, sum);
            }
        }

        public static int CalculateTreeSum(Tree<int> node, ref int sum)
        {
            sum += node.Value;

            if (node.Children == null || node.Children.Count == 0)
            {
                return sum + node.Value;
            }

            foreach (Tree<int> child in node.Children)
            {
                CalculateTreeSum(child, ref sum);
            }

            return 0;
        }

        public static void PrintTreeSumsNodes()
        {
            foreach (Tree<int> node in treesEqualSum)
            {
                List<int> nodes = new List<int>();
                GetTreeNodesValues(node, ref nodes);
                Console.WriteLine(string.Join(" + ", nodes));
            }
        }

        public static void GetTreeNodesValues(Tree<int> node, ref List<int> nodes)
        {
            nodes.Add(node.Value);

            if (node.Children == null || node.Children.Count == 0)
            {
                return;
            }

            foreach (Tree<int> child in node.Children)
            {
                GetTreeNodesValues(child, ref nodes);
            }
        }
    }
}