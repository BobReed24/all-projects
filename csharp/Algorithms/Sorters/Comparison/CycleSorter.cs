using System.Collections.Generic;

namespace Algorithms.Sorters.Comparison;

public class CycleSorter<T> : IComparisonSorter<T>
{
    
    public void Sort(T[] array, IComparer<T> comparer)
    {
        for (var i = 0; i < array.Length - 1; i++)
        {
            MoveCycle(array, i, comparer);
        }
    }

    private static void MoveCycle(T[] array, int startingIndex, IComparer<T> comparer)
    {
        var item = array[startingIndex];
        var pos = startingIndex + CountSmallerElements(array, startingIndex + 1, item, comparer);

        if (pos == startingIndex)
        {
            return;
        }

        pos = SkipSameElements(array, pos, item, comparer);

        var temp = array[pos];
        array[pos] = item;
        item = temp;

        while (pos != startingIndex)
        {
            pos = startingIndex + CountSmallerElements(array, startingIndex + 1, item, comparer);
            pos = SkipSameElements(array, pos, item, comparer);

            temp = array[pos];
            array[pos] = item;
            item = temp;
        }
    }

    private static int SkipSameElements(T[] array, int nextIndex, T item, IComparer<T> comparer)
    {
        while (comparer.Compare(array[nextIndex], item) == 0)
        {
            nextIndex++;
        }

        return nextIndex;
    }

    private static int CountSmallerElements(T[] array, int startingIndex, T element, IComparer<T> comparer)
    {
        var smallerElements = 0;
        for (var i = startingIndex; i < array.Length; i++)
        {
            if (comparer.Compare(array[i], element) < 0)
            {
                smallerElements++;
            }
        }

        return smallerElements;
    }
}
