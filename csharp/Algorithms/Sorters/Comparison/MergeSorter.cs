using System.Collections.Generic;
using System.Linq;

namespace Algorithms.Sorters.Comparison;

public class MergeSorter<T> : IComparisonSorter<T>
{
    
    public void Sort(T[] array, IComparer<T> comparer)
    {
        if (array.Length <= 1)
        {
            return;
        }

        var (left, right) = Split(array);
        Sort(left, comparer);
        Sort(right, comparer);
        Merge(array, left, right, comparer);
    }

    private static void Merge(T[] array, T[] left, T[] right, IComparer<T> comparer)
    {
        var mainIndex = 0;
        var leftIndex = 0;
        var rightIndex = 0;

        while (leftIndex < left.Length && rightIndex < right.Length)
        {
            var compResult = comparer.Compare(left[leftIndex], right[rightIndex]);
            array[mainIndex++] = compResult <= 0 ? left[leftIndex++] : right[rightIndex++];
        }

        while (leftIndex < left.Length)
        {
            array[mainIndex++] = left[leftIndex++];
        }

        while (rightIndex < right.Length)
        {
            array[mainIndex++] = right[rightIndex++];
        }
    }

    private static (T[] Left, T[] Right) Split(T[] array)
    {
        var mid = array.Length / 2;
        return (array.Take(mid).ToArray(), array.Skip(mid).ToArray());
    }
}
