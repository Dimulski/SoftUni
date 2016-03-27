namespace _01.Dictionary
{
    public class KeyValue<TKey, TValue>
    {
        public KeyValue(TKey key, TValue value)
        {
            this.Key = key;
            this.Value = value;
        }

        public TKey Key { get; set; }

        public TValue Value { get; set; }
    }
}
