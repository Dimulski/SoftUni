namespace _02.SweepAndPrune
{
    using System;
    using System.Collections.Generic;

    public class SweepAndPrune
    {
        public static void Main()
        {
            var objects = new List<GameObject>();
            var objectsByName = new Dictionary<string, GameObject>();

            string command = Console.ReadLine();
            while (command != "start")
            {
                string[] args = command.Split(new[] {' '}, StringSplitOptions.RemoveEmptyEntries);
                string name = args[1];
                int x1 = int.Parse(args[2]);
                int y1 = int.Parse(args[3]);
                var newObject = new GameObject(name, x1, y1);
                objects.Add(newObject);
                objectsByName.Add(name, newObject);

                command = Console.ReadLine();
            }

            InsertionSort(objects);

            int currTick = 1;
            while (true)
            {
                command = Console.ReadLine();
                if (command != "tick")
                {
                    var args = command.Split(new[] { ' ' }, StringSplitOptions.RemoveEmptyEntries);
                    string name = args[1];
                    int newX1 = int.Parse(args[2]);
                    int newY1 = int.Parse(args[3]);
                    objectsByName[name].X1 = newX1;
                    objectsByName[name].Y1 = newY1;
                    objectsByName[name].X2 = newX1 + objectsByName[name].Width;
                    objectsByName[name].Y2 = newY1 + objectsByName[name].Height;
                    InsertionSort(objects);
                }

                PrintCollisions(objects, currTick);

                currTick++;
            }
        }

        private static void InsertionSort(List<GameObject> objects)
        {
            for (int i = 0; i < objects.Count; i++)
            {
                var currObject = objects[i];
                int currIndex = i;

                for (int j = i - 1; j >= 0; j--)
                {
                    if (currObject.X1 < objects[j].X1)
                    {
                        var old = objects[j];
                        objects[j] = objects[currIndex];
                        objects[currIndex] = old;
                        currIndex--;
                    }
                    else
                    {
                        break;
                    }
                }
            }
        }

        private static void PrintCollisions(List<GameObject> objects, int tick)
        {
            for (int i = 0; i < objects.Count; i++)
            {
                for (int j = i + 1; j < objects.Count; j++)
                {
                    if (objects[i].X2 < objects[j].X1)
                    {
                        break;
                    }

                    if (objects[i].Intersects(objects[j]))
                    {
                        Console.WriteLine("({0}) {1} collides with {2}", tick, objects[i].Name, objects[j].Name);
                    }
                }
            }
        }
    }
}
