namespace _02.RoundDance
{
    using System.Collections.Generic;

    public class Node<T>
    {
        public Node(T value)
        {
            this.Value = value;
            this.Friends = new List<Node<T>>();
        }

        public T Value { get; set; }

        public IList<Node<T>> Friends { get; set; }
    }
}
