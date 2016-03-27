namespace Dictionary
{
    using System;
    using System.Collections.Generic;
    using System.Collections;
    using System.Linq;
    
    public class MyDictionary<TKey, TValue> : IEnumerable<KeyValue<TKey, TValue>>
    {
        //creating the dictionary with LinkedList
        private LinkedList<KeyValue<TKey, TValue>>[] list;

        public int Count { get; set; }
        //Initial capacity of the array of lists
        private const int InitialCapacity = 16;
        //constant for the amount of % for the array
        public const float LoadFactor = 0.75f;


        public int Capacity
        {
            get
            {
                return this.list.Length;
            }
        }
        //initialize dictionary with default capacity, and setting the count ot 0
        public MyDictionary(int capacity = InitialCapacity)
        {
            list = new LinkedList<KeyValue<TKey, TValue>>[capacity];
            this.Count = 0;
        }


        public void Add(TKey key, TValue value)
        {
            //grow the capacity if needed, defined by the load factor
            GrowIfNeeded();
            //find the slot number of the key by using GetHashCode()
            int slotNumber = FindSlotNumber(key);

            //after hashing the key, we check if the list with array index of that key is null, if it is then we create a new list
            //ensuring we can handle collision afterwards
            if (list[slotNumber] == null)
            {
                list[slotNumber] = new LinkedList<KeyValue<TKey, TValue>>();
            }
            //check if key exists, if it does throw exception, as dictionary contains only unique keys
            foreach (var element in list[slotNumber])
            {
                if (element.Key.Equals(key))
                {
                    throw new ArgumentException();
                }
            }
            //if the key does not exist, we create it
            var elementToAdd = new KeyValue<TKey, TValue>(key, value);
            //then add it ot the right index
            list[slotNumber].AddLast(elementToAdd);
            //and we increase the count of the elements
            this.Count++;
        }

        private int FindSlotNumber(TKey key)
        {
            //we call the GetHashCode method on key so we get a number and divided my module of list.lenght
            //so it stays within the lenght of the array and we use math.abs to get a positive number everytime
            int slotNumber = Math.Abs(key.GetHashCode() % list.Length);
            return slotNumber;
            
        }
        public KeyValue<TKey, TValue> Find(TKey key)
        {
            //find the slot number of the key by using GetHashCode()
            var slotNumber = FindSlotNumber(key);
            //create a variable with all elements at the given index of list
            var elements = list[slotNumber];
            //if elements is null, then we return null
            if (elements == null)
            {
                return null;
            }
            //search for the element that is not null, and if the element's key equals the key given return the element
            foreach (var element in elements)
            {
                if (element.Key.Equals(key))
                {
                    return element;
                }
            }
            return null;
        }

        private void GrowIfNeeded()
        {
            if (((float)this.Count + 1) / list.Length > LoadFactor)
            {
                this.Grow();
            }
        }

        private void Grow()
        {
            var newDictionary = new MyDictionary<TKey, TValue>(this.Capacity * 2);

            foreach (var element in this)
            {
                    newDictionary.Add(element.Key, element.Value);
                
            }
            this.list = newDictionary.list;
            this.Count = newDictionary.Count;

        }

        public bool AddOrReplace(TKey key, TValue value)
        {
            //check if we need to grow the array
            GrowIfNeeded();
            //find the slotNumber with method
            var slotNumber = FindSlotNumber(key);
            //if the list on this index is empty we create a new linked list
            if (this.list[slotNumber] == null)
            {
                this.list[slotNumber] = new LinkedList<KeyValue<TKey, TValue>>();
            }
            //we iterrate between all elements in list at index slotNumber
            //and if the key exists we set the element's value to our value and we return false
            foreach (var element in list[slotNumber])
            {
                if (element.Key.Equals(key))
                {
                    element.Value = value;
                    return false;
                }   
            }
            //if the key does not exist, we create it
            var elementToAdd = new KeyValue<TKey, TValue>(key, value);
            //then add it ot the right index
            list[slotNumber].AddLast(elementToAdd);
            //and we increase the count of the elements
            this.Count++;
            //return true if the element does not exist??
            return true;
        }



        public bool ContainsKey(TKey key)
        {
            //we use the Find method to get the specific key, then if the key is not null we return true
            //otherwsie we return false
            var element = Find(key);

            if (element != null)
            {
                return true;
            }
            return false;
        }

        public bool Remove(TKey key)
        {
            //we need the current index of the key, so we use FindSlotNumber
            //we get all the elements in the specific index of list[slotNumber]
            int slotNumber = FindSlotNumber(key);
            var elements = list[slotNumber];
            //we check if the elements are not null
            if (elements != null)
            {
                //we take the first element, and while the first element is not null we remove the current element
                //and decrease the Count
                var currentElement = elements.First;

                while (currentElement != null)
                {
                    if (currentElement.Value.Key.Equals(key))
                    {
                        elements.Remove(currentElement);
                        this.Count--;
                        return true;
                    }
                    //we acquire the next element
                    currentElement = currentElement.Next;
                }
            }
            return false;
        }

        public void Clear()
        {
            //Reinitilize the list and the count so all values are null or 0
            this.list = new LinkedList<KeyValue<TKey, TValue>>[InitialCapacity];
            this.Count = 0;
        }

        public IEnumerable<TKey> Keys
        {
            //this means Enumerator of the class, and we just return all the keys
            get { return this.Select(x => x.Key); }
        }

        public IEnumerable<TValue> Values
        {
            get { return this.Select(x => x.Value); }
        }

        public TValue Get(TKey key)
        {
            //we acquire the KeyValue pair from the method Find
            //if the element is not null we return the element's value
            //otherwise we throw am exception
            var element = this.Find(key);

            if (element != null)
            {
                return element.Value;
            }

            throw new KeyNotFoundException();
        }

        public TValue this[TKey key]
        {
            //iterrate through all elements and if any element's key equals the given key, return the value
            //otherwise throw an exception
            get
            {
                var element = this.Find(key);

                if (element == null)
                {
                    throw new KeyNotFoundException("Key does not exist.");
                }

                return element.Value;
            }
            //as per homework the setter should call the AddOrReplace method
            set
            {
                this.AddOrReplace(key, value);
            }
        }


        public bool TryGetValue(TKey key, out TValue value)
        {
            // we get the keyValue pair from the find method
            // if it is not null we set the value to the element's value and we return true
            // otherwise we set to the default value of TValue and return false
            var element = Find(key);

            if (element != null)
            {
                value = element.Value;
                return true;
            }
            else
            {
                value = default(TValue);
                return false;
            }
        }

        public IEnumerator<KeyValue<TKey, TValue>> GetEnumerator()
        {
            //Iterrate through the whle collection and yield return the element
            foreach (var elements in list)
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
            return GetEnumerator();
        }
    }
}
