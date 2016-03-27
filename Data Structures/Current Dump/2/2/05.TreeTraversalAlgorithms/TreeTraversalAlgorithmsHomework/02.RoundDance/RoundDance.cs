namespace _02.RoundDance
{
    using System;
    using System.Collections.Generic;
    using System.Linq;

    public class RoundDance
    {
        private static Node<int> startNode;
        private static Dictionary<int, bool> visited = new Dictionary<int, bool>();
        private static int longestRoundDance;

        public static void Main()
        {
            ReadFrienships();
            FindLongestRoundDance(startNode);
            Console.WriteLine("Longest round dance: {0}", longestRoundDance);
        }

        private static void FindLongestRoundDance(Node<int> startNode, int currLength = 1)
        {
            if (longestRoundDance < currLength)
            {
                longestRoundDance = currLength;
            }

            visited.Add(startNode.Value, true);
            foreach (var friend in startNode.Friends)
            {
                if (visited.ContainsKey(friend.Value) && visited[friend.Value])
                {
                    continue;
                }

                FindLongestRoundDance(friend, currLength + 1);
            }
        }

        private static void ReadFrienships()
        {
            int numberOfFriendships = int.Parse(Console.ReadLine());
            int startNodeValue = int.Parse(Console.ReadLine());
            var friends = new Dictionary<int, Node<int>>();
            for (int currFriendship = 0; currFriendship < numberOfFriendships; currFriendship++)
            {
                var args = Console.ReadLine()
                    .Split(new[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                    .Select(int.Parse)
                    .ToArray();
                int firstFriendValue = args[0];
                int secondFriendValue = args[1];

                if (!friends.ContainsKey(firstFriendValue))
                {
                    friends.Add(firstFriendValue, new Node<int>(firstFriendValue));
                }

                if (!friends.ContainsKey(secondFriendValue))
                {
                    friends.Add(secondFriendValue, new Node<int>(secondFriendValue));
                }

                friends[firstFriendValue].Friends.Add(friends[secondFriendValue]);
                friends[secondFriendValue].Friends.Add(friends[firstFriendValue]);

                if (firstFriendValue == startNodeValue && startNode == null)
                {
                    startNode = friends[firstFriendValue];
                }

                if (secondFriendValue == startNodeValue && startNode == null)
                {
                    startNode = friends[secondFriendValue];
                }
            }
        }
    }
}
