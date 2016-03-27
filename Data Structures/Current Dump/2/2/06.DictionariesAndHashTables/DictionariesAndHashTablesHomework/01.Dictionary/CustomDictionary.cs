namespace _01.Dictionary
{
    using System;
    using System.Collections;
    using System.Collections.Generic;
    using System.Linq;

    public class CustomDictionary<TKey, TValue> : IEnumerable<KeyValue<TKey, TValue>>
    {
        private const int InitialCapacity = 16;
        private const double MaxAllowedFillFactor = 0.75;

        private LinkedList<KeyValue<TKey, TValue>>[] entries;

        public CustomDictionary(int capacity = InitialCapacity)
        {
            this.entries = new LinkedList<KeyValue<TKey, TValue>>[capacity];
            this.Count = 0;
        }

        public int Count { get; private set; }

        public int Capacity
        {
            get
            {
                return this.entries.Length;
            }
        }

        public TValue this[TKey key]
        {
            get
            {
                return this.Get(key);
            }

            set
            {
                this.AddOrReplace(key, value);
            }
        }

        public IEnumerable<TKey> Keys
        {
            get
            {
                return this.Select(e => e.Key);
            }
        }

        public IEnumerable<TValue> Values
        {
            get
            {
                return this.Select(e => e.Value);
            }
        }

        public void Add(TKey key, TValue value)
        {
            this.ResizeIfNeeded();
            int position = this.GetPosition(key);
            if (this.entries[position] == null)
            {
                this.entries[position] = new LinkedList<KeyValue<TKey, TValue>>();
            }

            foreach (var element in this.entries[position])
            {
                if (element.Key.Equals(key))
                {
                    throw new ArgumentException("Key is already contained.");
                }
            }

            var keyValue = new KeyValue<TKey, TValue>(key, value);
            this.entries[position].AddLast(keyValue);

            this.Count++;
        }

        public void AddOrReplace(TKey key, TValue value)
        {
            this.ResizeIfNeeded();
            int position = this.GetPosition(key);
            if (this.entries[position] == null)
            {
                this.entries[position] = new LinkedList<KeyValue<TKey, TValue>>();
            }

            foreach (var element in this.entries[position])
            {
                if (element.Key.Equals(key))
                {
                    element.Value = value;
                    return;
                }
            }

            var keyValue = new KeyValue<TKey, TValue>(key, value);
            this.entries[position].AddLast(keyValue);

            this.Count++;
        }

        public void Remove(TKey key)
        {
            int position = this.GetPosition(key);
            if (this.entries[position] == null)
            {
                throw new KeyNotFoundException();
            }

            foreach (var element in this.entries[position])
            {
                if (element.Key.Equals(key))
                {
                    this.entries[position].Remove(element);
                    this.Count--;
                }
            }

            throw new KeyNotFoundException();
        }

        public bool ContainsKey(TKey key)
        {
            foreach (var elements in this.entries)
            {
                if (elements != null)
                {
                    foreach (var element in elements)
                    {
                        if (element.Key.Equals(key))
                        {
                            return true;
                        }
                    }
                }
            }

            return false;
        }

        public IEnumerator<KeyValue<TKey, TValue>> GetEnumerator()
        {
            foreach (var elements in this.entries)
            {
                if (elements != null)
                {
                    foreach (var element in elements)
                    {
                        yield return element;
                    }
                }
            }
        }

        IEnumerator IEnumerable.GetEnumerator()
        {
            return this.GetEnumerator();
        }

        private TValue Get(TKey key)
        {
            int position = this.GetPosition(key);
            if (this.entries[position] == null)
            {
                throw new KeyNotFoundException();
            }

            foreach (var element in this.entries[position])
            {
                if (element.Key.Equals(key))
                {
                    return element.Value;
                }
            }

            throw new KeyNotFoundException();
        }

        private int GetPosition(TKey key)
        {
            return Math.Abs(key.GetHashCode()) % this.Capacity;
        }

        private void ResizeIfNeeded()
        {
            double fillFactor = (this.Count + 1.0) / this.Capacity;
            if (fillFactor >= MaxAllowedFillFactor)
            {
                this.Resize();
            }
        }

        private void Resize()
        {
            var newDictionary = new CustomDictionary<TKey, TValue>(this.Capacity * 2);
            foreach (var elements in this.entries)
            {
                if (elements != null)
                {
                    foreach (var element in elements)
                    {
                        newDictionary.Add(element.Key, element.Value);
                    }
                }
            }

            this.entries = newDictionary.entries;
            this.Count = newDictionary.Count;
        }
    }
}
