using System;
using System.Collections;
using System.Collections.Generic;

namespace Algorithms.Sorters.Comparison
{
    
    public class BasicTimSorter<T>
    {
        private readonly int minRuns = 32;
        private readonly IComparer<T> comparer;

        public BasicTimSorter(IComparer<T> comparer)
        {
            this.comparer = comparer ?? Comparer<T>.Default;
        }

        public void Sort(T[] array)
        {
            var n = array.Length;

            for (var i = 0; i < n; i += minRuns)
            {
                InsertionSort(array, i, Math.Min(i + minRuns - 1, n - 1));
            }

            for (var size = minRuns; size < n; size *= 2)
            {
                for (var left = 0; left < n; left += 2 * size)
                {
                    var mid = left + size - 1;
                    var right = Math.Min(left + 2 * size - 1, n - 1);

                    if (mid < right)
                    {
                        Merge(array, left, mid, right);
                    }
                }
            }
        }

        private void InsertionSort(T[] array, int left, int right)
        {
            for (var i = left + 1; i <= right; i++)
            {
                var key = array[i];
                var j = i - 1;

                while (j >= left && comparer.Compare(array[j], key) > 0)
                {
                    array[j + 1] = array[j];
                    j--;
                }

                array[j + 1] = key;
            }
        }

        private void Merge(T[] array, int left, int mid, int right)
        {
            
            var leftSegment = new ArraySegment<T>(array, left, mid - left + 1);
            var rightSegment = new ArraySegment<T>(array, mid + 1, right - mid);

            var leftArray = leftSegment.ToArray();
            var rightArray = rightSegment.ToArray();

            var i = 0;
            var j = 0;
            var k = left;

            while (i < leftArray.Length && j < rightArray.Length)
            {
                array[k++] = comparer.Compare(leftArray[i], rightArray[j]) <= 0 ? leftArray[i++] : rightArray[j++];
            }

            while (i < leftArray.Length)
            {
                array[k++] = leftArray[i++];
            }

            while (j < rightArray.Length)
            {
                array[k++] = rightArray[j++];
            }
        }
    }
}
