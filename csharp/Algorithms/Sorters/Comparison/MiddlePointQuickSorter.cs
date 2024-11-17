using System.Collections.Generic;

namespace Algorithms.Sorters.Comparison;

public sealed class MiddlePointQuickSorter<T> : QuickSorter<T>
{
    protected override T SelectPivot(T[] array, IComparer<T> comparer, int left, int right) =>
        array[left + (right - left) / 2];
}
