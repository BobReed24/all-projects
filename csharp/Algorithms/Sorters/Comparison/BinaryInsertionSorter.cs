using System;
using System.Collections.Generic;

namespace Algorithms.Sorters.Comparison;

public class BinaryInsertionSorter<T> : IComparisonSorter<T>
{
    
    public void Sort(T[] array, IComparer<T> comparer)
    {
        for (var i = 1; i < array.Length; i++)
        {
            var target = array[i];
            var moveIndex = i - 1;
            var targetInsertLocation = BinarySearch(array, 0, moveIndex, target, comparer);
            Array.Copy(array, targetInsertLocation, array, targetInsertLocation + 1, i - targetInsertLocation);

            array[targetInsertLocation] = target;
        }
    }

    private static int BinarySearch(T[] array, int from, int to, T target, IComparer<T> comparer)
    {
        var left = from;
        var right = to;
        while (right > left)
        {
            var middle = (left + right) / 2;
            var comparisonResult = comparer.Compare(target, array[middle]);

            if (comparisonResult == 0)
            {
                return middle + 1;
            }

            if (comparisonResult > 0)
            {
                left = middle + 1;
            }
            else
            {
                right = middle - 1;
            }
        }

        return comparer.Compare(target, array[left]) < 0 ? left : left + 1;
    }
}
