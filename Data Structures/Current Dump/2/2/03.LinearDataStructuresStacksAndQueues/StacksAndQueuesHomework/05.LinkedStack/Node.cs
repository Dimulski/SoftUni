namespace _05.LinkedStack
{
    public class Node<T>
    {
        public Node(T value, Node<T> next = null)
        {
            this.Value = value;
            this.Next = next;
        }

        public T Value { get; private set; }

        public Node<T> Next { get; set; }
    }
}
