namespace Sortable_Collection.Sorters
{
    using System;
    using System.Collections.Generic;
    using System.Linq;

    using Sortable_Collection.Contracts;

    public class MergeSorter : ISorter<int>
    {
        public void Sort(List<int> collection)
        {
            var numbers = collection.OfType<int>().ToArray();

            this.MergeSort(numbers, 0, numbers.Length - 1);

            for (int i = 0; i < numbers.Length; i++)
            {
                collection[i] = numbers[i];
            }
        }

        private void MergeSort(int[] array, int start, int end)
        {
            if (start >= end)
            {
                return;
            }

            var mid = start + (end - start) / 2;
            
            this.MergeSort(array, start, mid);
            this.MergeSort(array, mid + 1, end);

            int left = start;
            int right = mid + 1;
            int result = 0;

            int[] temp = new int[end - start + 1];
            while (left <= mid && right <= end)
            {
                if (array[left] < array[right])
                {
                    temp[result] = array[left];
                    left++;
                }
                else
                {
                    temp[result] = array[right];
                    right++;
                }

                result++;
            }

            while (left <= mid)
            {
                temp[result++] = array[left++];
            }

            while (right <= end)
            {
                temp[result++] = array[right++];
            }

            Array.Copy(temp, 0, array, start, temp.Length);
        }
    }
}
