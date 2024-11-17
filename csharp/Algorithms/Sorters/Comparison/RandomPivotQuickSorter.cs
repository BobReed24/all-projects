using System;
using System.Collections.Generic;

namespace Algorithms.Sorters.Comparison;

public sealed class RandomPivotQuickSorter<T> : QuickSorter<T>
{
    private readonly Random random = new();

    protected override T SelectPivot(T[] array, IComparer<T> comparer, int left, int right) =>
        array[random.Next(left, right + 1)];
}
