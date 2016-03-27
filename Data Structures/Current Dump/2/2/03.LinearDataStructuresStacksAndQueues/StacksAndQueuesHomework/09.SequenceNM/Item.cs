namespace _09.SequenceNM
{
    public class Item<T>
    {
        public Item(T value, Item<T> previous = null)
        {
            this.Value = value;
            this.Previous = previous;
        }

        public T Value { get; set; }

        public Item<T> Previous { get; set; }
    }
}
