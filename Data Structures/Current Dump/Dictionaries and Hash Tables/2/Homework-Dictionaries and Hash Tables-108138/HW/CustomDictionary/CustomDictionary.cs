namespace CustomDictionary
{
    using System;
    using System.Collections;
    using System.Collections.Generic;
    using System.Linq;

    public class CustomDictionary<TKey, TValue>: IEnumerable<CustomKeyValue<TKey, TValue>>
    {
        private const int DefaultCapacity = 16;
        private const double FillCapacity = 0.75f;
        private LinkedList<CustomKeyValue<TKey, TValue>>[] slots;
        private int capacity;

        public CustomDictionary() : this(DefaultCapacity)
        {
        }
        
        public CustomDictionary(int capacity)
        {
            this.capacity = capacity;
            this.Count = 0;
            this.slots = new LinkedList<CustomKeyValue<TKey, TValue>>[this.capacity];
        }
        
        public int Count { get; private set; }

        public int Capacity 
        {
            get
            {
                return this.capacity;
            }
        }

        public TValue this[TKey key]
        {
            get { return this.Get(key); }
            set { this.AddOrReplace(key, value); }
        }

        public void Add(TKey key, TValue value)
        {
            // check if need to grow and grow
            // check if there is such element if true => throw argument exeption
            // add element
            // Up counter
            this.GrouIfNecessary();
            int slotNumber = this.FindSlotNumber(key);
            if (this.slots[slotNumber] == null)
            {
                this.slots[slotNumber] = new LinkedList<CustomKeyValue<TKey, TValue>>();
            }
            foreach (var element in slots[slotNumber])
            {
                if (element.Key.Equals(key))
                {
                    throw new ArgumentException("there is such key:" + key);
                }
            }
            
            this.slots[slotNumber].AddLast(new CustomKeyValue<TKey, TValue>(key, value));
            this.Count++;
        }

        public bool ContainsKey(TKey key)
        {
            int slotNumber = this.FindSlotNumber(key);
            if (this.slots[slotNumber] != null)
            {
                foreach (var element in this.slots[slotNumber])
                {
                    if (element.Key.Equals(key))
                    {
                        return true;
                    }
                }
            }
            return false;
        }

        public TValue Get(TKey key)
        {
            var element = this.Find(key);
            if (element == null)
            {
                throw new KeyNotFoundException("missing key:" + key);
            }
            
            return element.Value;
        }

        public bool AddOrReplace(TKey key, TValue value)
        {
            this.GrouIfNecessary();
            int slotNumber = this.FindSlotNumber(key);
            if (this.slots[slotNumber] == null)
            {
                this.slots[slotNumber] = new LinkedList<CustomKeyValue<TKey, TValue>>();
            }
            
            foreach (var element in slots[slotNumber])
            {
                if (element.Key.Equals(key))
                {
                    element.Value = value;
                    return false;
                }
            }

            this.slots[slotNumber].AddLast(new CustomKeyValue<TKey, TValue>(key, value));
            this.Count++;
            return true;
        }

        public CustomKeyValue<TKey, TValue> Find(TKey key)
        {
            int slotNumber = this.FindSlotNumber(key);
            if (this.slots[slotNumber] != null)
            {
                foreach (var element in this.slots[slotNumber])
                {
                    if (element.Key.Equals(key))
                    {
                        return element;
                    }
                }
            }
            return null;

        }

        public IEnumerable<TKey> Keys
        {
            get
            {
                return this.Select(element => element.Key);
            }
        }

        public IEnumerable<TValue> Values
        {
            get { return this.Select(element => element.Value); }
        }

        public IEnumerator<CustomKeyValue<TKey, TValue>> GetEnumerator()
        {
            foreach (var slot in this.slots)
            {
                if (slot != null)
                {
                    foreach (var element in slot)
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

        private int FindSlotNumber(TKey key)
        {
            int number = Math.Abs(key.GetHashCode()) % this.slots.Length;
            return number;
        }

        private void GrouIfNecessary()
        {
            if ((double)this.Count / this.Capacity >= FillCapacity)
            {
                this.Grow();
            }
        }

        private void Grow()
        {
            var newDictionary = new CustomDictionary<TKey, TValue>(2 * this.Capacity);
            foreach (var slot in slots)
            {
                if (slot != null)
                {
                    foreach (var element in slot)
                    {
                        newDictionary.Add(element.Key, element.Value);
                    }
                }
            }
            this.slots = newDictionary.slots;
            this.Count = newDictionary.Count;
        }
    }
}
