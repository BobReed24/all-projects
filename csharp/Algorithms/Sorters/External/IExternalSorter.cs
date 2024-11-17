using System.Collections.Generic;

namespace Algorithms.Sorters.External;

public interface IExternalSorter<T>
{
    
    void Sort(ISequentialStorage<T> mainMemory, ISequentialStorage<T> temporaryMemory, IComparer<T> comparer);
}
