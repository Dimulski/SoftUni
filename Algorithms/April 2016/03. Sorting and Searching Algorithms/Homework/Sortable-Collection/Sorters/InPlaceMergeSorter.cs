namespace Sortable_Collection.Sorters
{
    using System;
    using System.Collections.Generic;

    using Sortable_Collection.Contracts;

    public class InPlaceMergeSorter<T> : ISorter<T> where T : IComparable<T>
    {
        public void Sort(List<T> collection)
        {
            this.InPlaceMergeSort(collection, 0, collection.Count - 1);
        }

        private void InPlaceMergeSort(List<T> collection, int start, int end)
        {
            if (start < end)
            {
                int mid = (end + start) / 2;
                this.InPlaceMergeSort(collection, start, mid);
                this.InPlaceMergeSort(collection, mid + 1, end);

                int left = start;
                int right = mid + 1;
                if (collection[mid].CompareTo(collection[right]) <= 0)
                {
                    return;
                }

                while (left <= mid && right <= end)
                {
                    if (collection[left].CompareTo(collection[right]) <= 0)
                    {
                        left++;
                    }
                    else
                    {
                        T temp = collection[right];
                        collection.RemoveAt(right);
                        collection.Insert(left, temp);
                        left++;
                        right++;
                        mid++;
                    }
                }
            }
        }
    }
}
