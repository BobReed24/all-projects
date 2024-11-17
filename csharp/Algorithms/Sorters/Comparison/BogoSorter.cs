using System;
using System.Collections.Generic;

namespace Algorithms.Sorters.Comparison;

public class BogoSorter<T> : IComparisonSorter<T>
{
    private readonly Random random = new();

    public void Sort(T[] array, IComparer<T> comparer)
    {
        while (!IsSorted(array, comparer))
        {
            Shuffle(array);
        }
    }

    private bool IsSorted(T[] array, IComparer<T> comparer)
    {
        for (var i = 0; i < array.Length - 1; i++)
        {
            if (comparer.Compare(array[i], array[i + 1]) > 0)
            {
                return false;
            }
        }

        return true;
    }

    private void Shuffle(T[] array)
    {
        var taken = new bool[array.Length];
        var newArray = new T[array.Length];
        for (var i = 0; i < array.Length; i++)
        {
            int nextPos;
            do
            {
                nextPos = random.Next(0, int.MaxValue) % array.Length;
            }
            while (taken[nextPos]);

            taken[nextPos] = true;
            newArray[nextPos] = array[i];
        }

        for (var i = 0; i < array.Length; i++)
        {
            array[i] = newArray[i];
        }
    }
}
