using System.Collections.Generic;

namespace Algorithms.Sorters.Comparison;

public class PancakeSorter<T> : IComparisonSorter<T>
{
    
    public void Sort(T[] array, IComparer<T> comparer)
    {
        var n = array.Length;

        for (var currSize = n; currSize > 1; --currSize)
        {
            
            var mi = FindMax(array, currSize, comparer);

            if (mi != currSize - 1)
            {
                
                Flip(array, mi);

                Flip(array, currSize - 1);
            }
        }
    }

    private void Flip(T[] array, int i)
    {
        T temp;
        var start = 0;
        while (start < i)
        {
            temp = array[start];
            array[start] = array[i];
            array[i] = temp;
            start++;
            i--;
        }
    }

    private int FindMax(T[] array, int n, IComparer<T> comparer)
    {
        var mi = 0;
        for (var i = 0; i < n; i++)
        {
            if (comparer.Compare(array[i], array[mi]) == 1)
            {
                mi = i;
            }
        }

        return mi;
    }
}
