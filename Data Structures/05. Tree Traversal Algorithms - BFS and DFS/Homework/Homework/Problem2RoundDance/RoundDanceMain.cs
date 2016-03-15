namespace Problem2RoundDance
{
    using System;
    using System.Collections.Generic;
    using System.Linq;

    public class RoundDanceMain
    {
        private static int longestRoundDance;

        private static Dictionary<int, List<int>> nodes = new Dictionary<int, List<int>>();

        private static int leaderNode;

        public static void Main()
        {
            ReadInput();

            FindLongestRoundDance(leaderNode, leaderNode);

            Console.WriteLine(longestRoundDance);
        }

        private static void FindLongestRoundDance(int node, int prevNode, int count = 0)
        {
            count++;

            foreach (var neighbour in nodes[node])
            {
                if (neighbour == prevNode)
                {
                    continue;
                }

                FindLongestRoundDance(neighbour, node, count);
            }

            if (count > longestRoundDance)
            {
                longestRoundDance = count;
            }
        }

        private static void ReadInput()
        {
            int numberOfEdges = int.Parse(Console.ReadLine());
            int leader = int.Parse(Console.ReadLine());
            leaderNode = leader;

            nodes[leader] = new List<int>();

            for (int count = 0; count < numberOfEdges; count++)
            {
                string[] inputLine = Console.ReadLine().Split(' ');

                int first = int.Parse(inputLine[0]);
                int second = int.Parse(inputLine[1]);

                if (!nodes.ContainsKey(first))
                {
                    nodes[first] = new List<int>();
                }

                if (!nodes.ContainsKey(second))
                {
                    nodes[second] = new List<int>();
                }

                nodes[first].Add(second);
                nodes[second].Add(first);
            }
        }
    }
}
