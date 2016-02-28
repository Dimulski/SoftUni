namespace Problem1CollectResources
{
    using System;
    using System.Collections.Generic;
    using System.Linq;
    using System.Text.RegularExpressions;

    class CollectResourcesMain
    {
        static void Main()
        {
            // List<string> collection = Console.ReadLine().Trim().Split(' ').ToList();
            List<string> collection = Console.ReadLine()
            .Split(new[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
            .ToList();

            List<string> collectionCopy = new List<string>(collection);

            int numberOfPaths = int.Parse(Console.ReadLine());

            List<int[]> paths = new List<int[]>();
            for (int i = 0; i < numberOfPaths; i++)
            {
                int[] path = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();
                paths.Add(path);
            }

            int currentMax = 0;

            foreach (var path in paths)
            {
                currentMax = CalculatePath(path, collection, currentMax);
                collection = collectionCopy;
            }

            Console.WriteLine(currentMax);
        }

        private static int CalculatePath(int[] path, List<string> collection, int currentMax)
        {
            int currentScore = 0;
            int startIndex = path[0];
            // int actualStep = path[2] % collection.Count; // IDK If this is needed
            int step = path[1];
            int currentResourceIndex = startIndex;

            while (IsThatCollected(currentResourceIndex, collection) == false)
            {
                bool checker = IsValidResource(collection, currentResourceIndex);

                if (checker)
                {
                    currentScore = currentScore + CollectResourceAndMark(collection, currentResourceIndex);
                }

                currentResourceIndex = Traverse(collection, currentResourceIndex, step);
            }

            if (currentMax < currentScore)
            {
                currentMax = currentScore;
            }

            return currentMax;
        }

        private static int CollectResourceAndMark(List<string> collection, int currentResourceIndex) // This and traversal are the important ones
        {
            int score = 0;

            string resource = collection[currentResourceIndex];

            string[] resourceParams = resource.Split('_');
            if (resourceParams.Length == 1)
            {
                score = 1;
            }
            else
            {
                score = int.Parse(resourceParams[1]);
            }

            collection[currentResourceIndex] = resource + "faipjwi"; // We mark the target

            return score;
        }

        private static bool IsValidResource(List<string> collection, int currentRecourceIndex)
        {


            var expression = new Regex(@"\Awood$|\Awood_(100|[1-9][0-9]?)$");

            if (expression.IsMatch(collection[currentRecourceIndex]))
            {
                return true;
            }

            expression = new Regex(@"\Astone$|\Astone_(100|[1-9][0-9]?)$");

            if (expression.IsMatch(collection[currentRecourceIndex]))
            {
                return true;
            }

            expression = new Regex(@"\Agold$|\Agold_(100|[1-9][0-9]?)$");

            if (expression.IsMatch(collection[currentRecourceIndex]))
            {
                return true;
            }

            expression = new Regex(@"\Afood$|\Afood_(100|[1-9][0-9]?)$");

            if (expression.IsMatch(collection[currentRecourceIndex]))
            {
                return true;
            }

            return false;

        }


        private static int Traverse(List<string> collection, int currentResourceIndex, int step)
        {
            for (int i = 0; i < step; i++)
            {
                currentResourceIndex++;
                if (currentResourceIndex > collection.Count - 1)
                {
                    currentResourceIndex = 0;
                }
            }
            return currentResourceIndex;
        }

        private static bool IsThatCollected(int currentResourceIndex, List<string> collection)
        {
            if (collection[currentResourceIndex].EndsWith("faipjwi"))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
    }
}
