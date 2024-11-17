using System.Collections.Generic;

namespace Algorithms.Sorters.Comparison;

public class SelectionSorter<T> : IComparisonSorter<T>
{
    
    public void Sort(T[] array, IComparer<T> comparer)
    {
        for (var i = 0; i < array.Length - 1; i++)
        {
            var jmin = i;
            for (var j = i + 1; j < array.Length; j++)
            {
                if (comparer.Compare(array[jmin], array[j]) > 0)
                {
                    jmin = j;
                }
            }

            var t = array[i];
            array[i] = array[jmin];
            array[jmin] = t;
        }
    }
}
