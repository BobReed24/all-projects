using System.Collections.Generic;

namespace Algorithms.Sorters.Comparison;

public class InsertionSorter<T> : IComparisonSorter<T>
{
    
    public void Sort(T[] array, IComparer<T> comparer)
    {
        for (var i = 1; i < array.Length; i++)
        {
            for (var j = i; j > 0 && comparer.Compare(array[j], array[j - 1]) < 0; j--)
            {
                var temp = array[j - 1];
                array[j - 1] = array[j];
                array[j] = temp;
            }
        }
    }
}
