using System;
using System.Collections.Generic;
using System.Text;

public class EscapeFromLabyrinth
{
    private const char VisitedCell = 's';

    private static int width = 9;

    private static int height = 7;

    private static char[,] labyrinth;
        

    public static void Main()
    {
        ReadLabyrinth();

        string shortestPathToExit = FindShortestPathToExit();
        if (shortestPathToExit == null)
        {
            Console.WriteLine("No exit!");
        }
        else if (shortestPathToExit == string.Empty)
        {
            Console.WriteLine("Start is at the exit.");
        }
        else
        {
            Console.WriteLine("Shortest exit: " + shortestPathToExit);
        }
    }

    private static string FindShortestPathToExit()
    {
        var queue = new Queue<Point>();
        var startPosition = FindStartPosition();
        if (startPosition == null)
        {
            // No start position = no exit
            return null;
        }
        queue.Enqueue(startPosition);
        while (queue.Count > 0)
        {
            var currentCell = queue.Dequeue();
            // Console.WriteLine("Visited cell: ({0}, {1})", currentCell.X, currentCell.Y);
            if (IsExit(currentCell))
            {
                return TracePathBack(currentCell);
            }
            TryDirection(queue, currentCell, "U", 0, -1);
            TryDirection(queue, currentCell, "R", +1, 0);
            TryDirection(queue, currentCell, "D", 0, +1);
            TryDirection(queue, currentCell, "L", -1, 0);
        }

        return null;
    }

    private static string TracePathBack(Point currentCell)
    {
        var path = new StringBuilder();
        while (currentCell.PreviousPoint != null)
        {
            path.Append(currentCell.Direction);
            currentCell = currentCell.PreviousPoint;
        }
        var pathReversed = new StringBuilder(path.Length);
        for (int i = path.Length - 1; i >= 0; i--)
        {
            pathReversed.Append(path[i]);
        }
        return pathReversed.ToString();
    }

    private static void TryDirection(Queue<Point> queue, Point currentCell, string direction, int deltaX, int deltaY)
    {
        int newX = currentCell.X + deltaX;
        int newY = currentCell.Y + deltaY;
        if (newX >= 0 && newX < width && newY >= 0 && newY < height && labyrinth[newY, newX] == '-')
        {
            labyrinth[newY, newX] = VisitedCell;
            var nextCell = new Point()
            {
                X = newX, Y = newY, Direction = direction, PreviousPoint = currentCell
            };
            queue.Enqueue(nextCell);
        }
    }

    private static bool IsExit(Point currentCell)
    {
        bool isOnBorderX = currentCell.X == 0 || currentCell.X == width - 1;
        bool isOnBorderY = currentCell.Y == 0 || currentCell.Y == height - 1;
        return isOnBorderX || isOnBorderY;
    }

    private static Point FindStartPosition()
    {
        for (int x = 0; x < width; x++)
        {
            for (int y = 0; y < height; y++)
            {
                if (labyrinth[y, x] == VisitedCell)
                {
                    return new Point() { X = x, Y = y };
                }
            }
        }

        return null;
    }

    private static void ReadLabyrinth()
    {
        width = int.Parse(Console.ReadLine());
        height = int.Parse(Console.ReadLine());
        labyrinth = new char[height, width];

        for (int i = 0; i < height; i++)
        {
            char[] line = Console.ReadLine().ToCharArray();
            for (int j = 0; j < width; j++)
            {
                labyrinth[i, j] = line[j];
            }
        }
    }

    public class Point
    {
        public int X { get; set; }

        public int Y { get; set; }

        public string Direction { get; set; }

        public Point PreviousPoint { get; set; }
    }
}
