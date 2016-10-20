namespace Sortable_Collection.Sorters
{
    using System;
    using System.Collections.Generic;

    using Sortable_Collection.Contracts;

    public class InsertionSorter<T> : ISorter<T>
        where T : IComparable<T>
    {
        public void Sort(List<T> collection)
        {
            this.InsertionSort(collection);
        }

        private void InsertionSort(List<T> array)
        {
            for (int i = 1; i < array.Count; i++)
            {
                T item = array[i];
                int j = i;

                while ((j > 0) && (array[j - 1].CompareTo(item) > 0))
                {
                    array[j] = array[j - 1];
                    j = j - 1;
                }
                array[j] = item;
            }
        }
    }
}
