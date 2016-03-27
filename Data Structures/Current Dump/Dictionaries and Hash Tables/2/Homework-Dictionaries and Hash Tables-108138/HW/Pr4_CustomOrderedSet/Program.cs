namespace Pr4_CustomOrderedSet
{
    using System;

    public class Program
    {
        public static void Main(string[] args)
        {
            var myOrdSet = new CustomOrderedSet<int>();
            myOrdSet.Add(5);
            myOrdSet.Add(2);
            myOrdSet.Add(-4);
            myOrdSet.Add(3);
            myOrdSet.Add(18);
            myOrdSet.Remove(-4);
            Console.WriteLine();

            var secondOrdSet = new CustomOrderedSet<int>();
            secondOrdSet.Add(5);
            secondOrdSet.Add(2);
            secondOrdSet.Add(18);
            secondOrdSet.Add(3);
            secondOrdSet.Add(-4);
            secondOrdSet.Add(21);
            secondOrdSet.Add(19);
            secondOrdSet.Add(25);
            secondOrdSet.Remove(18);

            var tirdOrdSet = new CustomOrderedSet<int>();
            secondOrdSet.Add(5);
            secondOrdSet.Add(2);
            secondOrdSet.Add(12);
            secondOrdSet.Add(-4);
            secondOrdSet.Add(3);
            secondOrdSet.Add(9);
            secondOrdSet.Add(21);
            secondOrdSet.Add(19);
            secondOrdSet.Add(25);
            secondOrdSet.Remove(12);
            Console.WriteLine();

        }
    }
}
