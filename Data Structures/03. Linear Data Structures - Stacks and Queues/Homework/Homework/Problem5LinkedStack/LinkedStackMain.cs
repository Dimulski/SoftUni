namespace Problem5LinkedStack
{
    using System;

    class LinkedStackMain
    {
        static void Main()
        {
            var stack = new LinkedStack<int>();
            stack.Push(1);
            stack.Push(2);
            stack.Push(3);

            var array = stack.ToArray();

            foreach (var i in array)
            {
                Console.Write(i + " ");
            }
        }
    }
}
