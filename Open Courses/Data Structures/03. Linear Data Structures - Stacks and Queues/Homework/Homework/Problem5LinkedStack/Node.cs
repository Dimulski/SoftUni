namespace Problem5LinkedStack
{
    public class Node<T>
    {
        public Node(T value, Node<T> nexNode = null)
        {
            this.Value = value;
            this.NextNode = nexNode;
        }

        public T Value { get; set; }

        public Node<T> NextNode { get; set; }
    }
}
