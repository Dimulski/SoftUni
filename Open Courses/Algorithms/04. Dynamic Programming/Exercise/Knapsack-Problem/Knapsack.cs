namespace KnapsackProblem
{
    using System;
    using System.Collections.Generic;
    using System.Linq;

    public class Knapsack
    {
        public static void Main()
        {
            var items = new[]
            {
                new Item { Weight = 5, Price = 30 },
                new Item { Weight = 8, Price = 120 },
                new Item { Weight = 7, Price = 10 },
                new Item { Weight = 0, Price = 20 },
                new Item { Weight = 4, Price = 50 },
                new Item { Weight = 5, Price = 80 },
                new Item { Weight = 2, Price = 10 }
            };

            var knapsackCapacity = 20;

            var itemsTaken = FillKnapsack(items, knapsackCapacity);

            Console.WriteLine("Knapsack weight capacity: {0}", knapsackCapacity);
            Console.WriteLine("Take the following items in the knapsack:");
            foreach (var item in itemsTaken)
            {
                Console.WriteLine("(weight: {0}, price: {1})", item.Weight, item.Price);
            }

            Console.WriteLine("Total weight: {0}", itemsTaken.Sum(i => i.Weight));
            Console.WriteLine("Total price: {0}", itemsTaken.Sum(i => i.Price));
        }

        public static Item[] FillKnapsack(Item[] items, int capacity)
        {
            var maxPrice = new int[items.Length, capacity + 1];
            var isItemTaken = new bool[items.Length, capacity + 1];

            for (int indexCapacity = 0; indexCapacity <= capacity; indexCapacity++)
            {
                if (items[0].Weight <= indexCapacity)
                {
                    maxPrice[0, indexCapacity] = items[0].Price;
                    isItemTaken[0, indexCapacity] = true;
                }
            }

            for (int indexItem = 1; indexItem < items.Length; indexItem++)
            {
                for (int indexCapacity = 0; indexCapacity <= capacity; indexCapacity++)
                {
                    maxPrice[indexItem, indexCapacity] = maxPrice[indexItem - 1, indexCapacity];

                    var remainingCapacity = indexCapacity - items[indexItem].Weight;
                    if (remainingCapacity >= 0 && maxPrice[indexItem - 1, remainingCapacity] + items[indexItem].Price > maxPrice[indexItem - 1, indexCapacity])
                    {
                        maxPrice[indexItem, indexCapacity] = maxPrice[indexItem - 1, remainingCapacity] + items[indexItem].Price;
                        isItemTaken[indexItem, indexCapacity] = true;
                    }
                }
            }

            return TakeItems(items, isItemTaken, capacity);
        }

        private static Item[] TakeItems(Item[] items, bool[,] isItemTaken, int capacity)
        {
            var itemsTaken = new List<Item>();

            for (int itemIndex = items.Length - 1; itemIndex >= 0; itemIndex--)
            {
                if (isItemTaken[itemIndex, capacity])
                {
                    itemsTaken.Add(items[itemIndex]);
                    capacity -= items[itemIndex].Weight;
                }
            }

            itemsTaken.Reverse();
            return itemsTaken.ToArray();
        }
    }
}
