using System;
using System.Collections.Generic;

namespace Algorithms.Sorters.Comparison;

public class CombSorter<T> : IComparisonSorter<T>
{
    public CombSorter(double shrinkFactor = 1.3) => ShrinkFactor = shrinkFactor;

    private double ShrinkFactor { get; }

    public void Sort(T[] array, IComparer<T> comparer)
    {
        var gap = array.Length;
        var sorted = false;
        while (!sorted)
        {
            gap = (int)Math.Floor(gap / ShrinkFactor);
            if (gap <= 1)
            {
                gap = 1;
                sorted = true;
            }

            for (var i = 0; i < array.Length - gap; i++)
            {
                if (comparer.Compare(array[i], array[i + gap]) > 0)
                {
                    (array[i], array[i + gap]) = (array[i + gap], array[i]);
                    sorted = false;
                }
            }
        }
    }
}
