using System;
using System.Collections.Generic;

namespace Algorithms.Search;

public class RecursiveBinarySearcher<T> where T : IComparable<T>
{
    
    public int FindIndex(IList<T>? collection, T item)
    {
        if (collection is null)
        {
            throw new ArgumentNullException(nameof(collection));
        }

        var leftIndex = 0;
        var rightIndex = collection.Count - 1;

        return FindIndex(collection, item, leftIndex, rightIndex);
    }

    private int FindIndex(IList<T> collection, T item, int leftIndex, int rightIndex)
    {
        if (leftIndex > rightIndex)
        {
            return -1;
        }

        var middleIndex = leftIndex + (rightIndex - leftIndex) / 2;
        var result = item.CompareTo(collection[middleIndex]);

        return result switch
        {
            var r when r == 0 => middleIndex,
            var r when r > 0 => FindIndex(collection, item, middleIndex + 1, rightIndex),
            var r when r < 0 => FindIndex(collection, item, leftIndex, middleIndex - 1),
            _ => -1,
        };
    }
}
