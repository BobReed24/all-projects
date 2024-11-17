using System.Collections.Generic;

namespace Algorithms.Sorters.Comparison;

public class ExchangeSorter<T> : IComparisonSorter<T>
{
    
    public void Sort(T[] array, IComparer<T> comparer)
    {
        for (var i = 0; i < array.Length - 1; i++)
        {
            for (var j = i + 1; j < array.Length; j++)
            {
                if (comparer.Compare(array[i], array[j]) > 0)
                {
                    (array[j], array[i]) = (array[i], array[j]);
                }
            }
        }
    }
}
