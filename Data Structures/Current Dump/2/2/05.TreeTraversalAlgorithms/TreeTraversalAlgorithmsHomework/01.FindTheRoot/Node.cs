namespace _01.FindTheRoot
{
    using System.Collections.Generic;

    class Node<T>
    {
        public Node(T value)
        {
            this.Value = value;
            this.Parents = new List<Node<T>>();
            this.Children = new List<Node<T>>();
        }

        public T Value { get; set; }

        public IList<Node<T>> Parents { get; set; }

        public IList<Node<T>> Children { get; set; }
    }
}
