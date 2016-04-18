namespace Sortable_Collection
{
    using System;
    using System.Collections.Generic;
    using System.Linq;

    using Sortable_Collection.Contracts;

    public class SortableCollection<T> where T : IComparable<T>
    {
        public SortableCollection()
        {
        }

        public SortableCollection(IEnumerable<T> items)
        {
            this.Items = new List<T>(items);
        }

        public SortableCollection(params T[] items)
            : this(items.AsEnumerable())
        {
        }

        public List<T> Items { get; } = new List<T>();

        public int Count => this.Items.Count;

        public void Sort(ISorter<T> sorter)
        {
            sorter.Sort(this.Items);
        }

        public int BinarySearch(T item)
        {
            var result = this.BinarySearchProcedure(item, 0, this.Count - 1);
            return result;
        }

        public int InterpolationSearch(T item)
        {
            var numbers = this.Items.OfType<int>().ToArray();

            var result = this.InterpolationSearchProcedure(numbers, numbers.Length, Convert.ToInt32(item));

            return result;
        }

        public static IEnumerable<T> Shuffle<T>(IEnumerable<T> source)
        {
            Random rnd = new Random();
            var array = source.ToArray();
            var n = array.Length;
            for (var i = 0; i < n; i++)
            {
                int r = i + rnd.Next(0, n - i);
                var temp = array[i];
                array[i] = array[r];
                array[r] = temp;
            }

            return array;
        }

        public T[] ToArray()
        {
            return this.Items.ToArray();
        }

        public override string ToString()
        {
            return $"[{string.Join(", ", this.Items)}]";
        }

        private int InterpolationSearchProcedure(int[] arr, int size, int key)
        {
            if (size == 0)
            {
                return -1;
            }
            int low = 0;
            int high = size - 1;
            int mid;

            while (arr[high] != arr[low] && key >= arr[low] && key <= arr[high])
            {
                mid = low + ((key - arr[low]) * (high - low) / (arr[high] - arr[low]));

                if (arr[mid] < key) low = mid + 1;
                else if (key < arr[mid]) high = mid - 1;
                else return mid;
            }

            if (key == arr[low]) return low;
            else return -1;
        }

        private int BinarySearchProcedure(T item, int startIndex, int endIndex)
        {
            if (endIndex < startIndex)
            {
                return -1;
            }

            int midpoint = startIndex + (endIndex - startIndex) / 2;
            if (this.Items[midpoint].CompareTo(item) > 0)
            {
                return BinarySearchProcedure(item, startIndex, midpoint - 1);
            }

            if (this.Items[midpoint].CompareTo(item) < 0)
            {
                return BinarySearchProcedure(item, midpoint + 1, endIndex);
            }

            return midpoint;
        }
    }
}