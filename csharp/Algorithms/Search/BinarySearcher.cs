using System;

namespace Algorithms.Search;

public class BinarySearcher<T> where T : IComparable<T>
{
    
    public int FindIndex(T[] sortedData, T item)
    {
        var leftIndex = 0;
        var rightIndex = sortedData.Length - 1;

        while (leftIndex <= rightIndex)
        {
            var middleIndex = leftIndex + (rightIndex - leftIndex) / 2;

            if (item.CompareTo(sortedData[middleIndex]) > 0)
            {
                leftIndex = middleIndex + 1;
                continue;
            }

            if (item.CompareTo(sortedData[middleIndex]) < 0)
            {
                rightIndex = middleIndex - 1;
                continue;
            }

            return middleIndex;
        }

        return -1;
    }
}
