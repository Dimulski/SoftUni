namespace _04.LongestPathInTree
{
    using System.Collections.Generic;

    public class Node<T>
    {
        public Node(T value)
        {
            this.Value = value;
            this.Children = new List<Node<T>>();
        }

        public T Value { get; set; }

        public Node<T> Parent { get; set; }

        public IList<Node<T>> Children { get; set; }
    }
}
