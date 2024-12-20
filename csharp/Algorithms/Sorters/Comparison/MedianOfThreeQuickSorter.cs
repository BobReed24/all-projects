using System.Collections.Generic;

namespace Algorithms.Sorters.Comparison;

public sealed class MedianOfThreeQuickSorter<T> : QuickSorter<T>
{
    protected override T SelectPivot(T[] array, IComparer<T> comparer, int left, int right)
    {
        var leftPoint = array[left];
        var middlePoint = array[left + (right - left) / 2];
        var rightPoint = array[right];

        return FindMedian(comparer, leftPoint, middlePoint, rightPoint);
    }

    private static T FindMedian(IComparer<T> comparer, T a, T b, T c)
    {
        if (comparer.Compare(a, b) <= 0)
        {
            
            if (comparer.Compare(b, c) <= 0)
            {
                return b;
            }

            if (comparer.Compare(a, c) <= 0)
            {
                return c;
            }

            return a;
        }

        if (comparer.Compare(b, c) >= 0)
        {
            return b;
        }

        if (comparer.Compare(a, c) >= 0)
        {
            return c;
        }

        return a;
    }
}
