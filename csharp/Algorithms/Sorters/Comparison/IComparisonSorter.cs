using System.Collections.Generic;

namespace Algorithms.Sorters.Comparison;

public interface IComparisonSorter<T>
{
    
    void Sort(T[] array, IComparer<T> comparer);
}
