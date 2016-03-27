namespace _02.ImplementBiDictionary
{
    using System;
    using System.Collections.Generic;
    using System.Linq;

    public class BiDictionary<K1, K2, T>
    {
        private Dictionary<K1, List<T>> valuesByFirstKey;
        private Dictionary<K2, List<T>> valuesBySecondKey;
        private Dictionary<Tuple<K1, K2>, List<T>> valuesByBothKeys;

        public BiDictionary()
        {
            this.valuesByFirstKey = new Dictionary<K1, List<T>>();
            this.valuesBySecondKey = new Dictionary<K2, List<T>>();
            this.valuesByBothKeys = new Dictionary<Tuple<K1, K2>, List<T>>();
        }

        public void Add(K1 key1, K2 key2, T value)
        {
            if (!this.valuesByFirstKey.ContainsKey(key1))
            {
                this.valuesByFirstKey.Add(key1, new List<T>());
            }

            this.valuesByFirstKey[key1].Add(value);

            if (!this.valuesBySecondKey.ContainsKey(key2))
            {
                this.valuesBySecondKey.Add(key2, new List<T>());
            }

            this.valuesBySecondKey[key2].Add(value);

            var keyPair = new Tuple<K1, K2>(key1, key2);
            if (!this.valuesByBothKeys.ContainsKey(keyPair))
            {
                this.valuesByBothKeys.Add(keyPair, new List<T>());
            }

            this.valuesByBothKeys[keyPair].Add(value);
        }

        public IEnumerable<T> Find(K1 key1, K2 key2)
        {
            var keyPair = new Tuple<K1, K2>(key1, key2);
            if (this.valuesByBothKeys.ContainsKey(keyPair))
            {
                foreach (var value in this.valuesByBothKeys[keyPair])
                {
                    yield return value;
                }
            }
        }

        public IEnumerable<T> FindByKey1(K1 key1)
        {
            if (this.valuesByFirstKey.ContainsKey(key1))
            {
                foreach (var value in this.valuesByFirstKey[key1])
                {
                    yield return value;
                }
            }
        }

        public IEnumerable<T> FindByKey2(K2 key2)
        {
            if (this.valuesBySecondKey.ContainsKey(key2))
            {
                foreach (var value in this.valuesBySecondKey[key2])
                {
                    yield return value;
                }
            }
        }

        public bool Remove(K1 key1, K2 key2)
        {
            var valuesToRemove = this.Find(key1, key2);
            if (valuesToRemove.ToList().Count == 0)
            {
                return false;
            }

            for (int i = 0; i < this.valuesByFirstKey[key1].Count; i++)
            {
                foreach (var valueToRemove in valuesToRemove)
                {
                    if (this.valuesByFirstKey[key1][i].Equals(valueToRemove))
                    {
                        this.valuesByFirstKey[key1].RemoveAt(i);
                        i--;
                        break;
                    }
                }
            }

            if (this.valuesByFirstKey[key1].Count == 0)
            {
                this.valuesByFirstKey.Remove(key1);
            }

            for (int i = 0; i < this.valuesBySecondKey[key2].Count; i++)
            {
                foreach (var valueToRemove in valuesToRemove)
                {
                    if (this.valuesBySecondKey[key2][i].Equals(valueToRemove))
                    {
                        this.valuesBySecondKey[key2].RemoveAt(i);
                        i--;
                        break;
                    }
                }
            }

            if (this.valuesBySecondKey[key2].Count == 0)
            {
                this.valuesBySecondKey.Remove(key2);
            }

            var keyPair = new Tuple<K1, K2>(key1, key2);
            this.valuesByBothKeys.Remove(keyPair);

            return true;
        }
    }
}
