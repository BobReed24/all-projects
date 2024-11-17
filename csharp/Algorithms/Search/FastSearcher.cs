using System;
using Utilities.Exceptions;

namespace Algorithms.Search;

public class FastSearcher
{
    
    public int FindIndex(Span<int> array, int item)
    {
        if (array.Length == 0)
        {
            throw new ItemNotFoundException();
        }

        if (item < array[0] || item > array[^1])
        {
            throw new ItemNotFoundException();
        }

        if (array[0] == array[^1])
        {
            return item == array[0] ? 0 : throw new ItemNotFoundException();
        }

        var (left, right) = ComputeIndices(array, item);
        var (from, to) = SelectSegment(array, left, right, item);

        return from + FindIndex(array.Slice(from, to - from + 1), item);
    }

    private (int Left, int Right) ComputeIndices(Span<int> array, int item)
    {
        var indexBinary = array.Length / 2;

        int[] section =
        {
            array.Length - 1,
            item - array[0],
            array[^1] - array[0],
        };
        var indexInterpolation = section[0] * section[1] / section[2];

        return indexInterpolation > indexBinary
            ? (indexBinary, indexInterpolation)
            : (indexInterpolation, indexBinary);
    }

    private (int From, int To) SelectSegment(Span<int> array, int left, int right, int item)
    {
        if (item < array[left])
        {
            return (0, left - 1);
        }

        if (item < array[right])
        {
            return (left, right - 1);
        }

        return (right, array.Length - 1);
    }
}
