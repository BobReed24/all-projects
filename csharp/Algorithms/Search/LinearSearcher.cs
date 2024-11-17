using System;
using Utilities.Exceptions;

namespace Algorithms.Search;

public class LinearSearcher<T>
{
    
    public T Find(T[] data, Func<T, bool> term)
    {
        for (var i = 0; i < data.Length; i++)
        {
            if (term(data[i]))
            {
                return data[i];
            }
        }

        throw new ItemNotFoundException();
    }

    public int FindIndex(T[] data, Func<T, bool> term)
    {
        for (var i = 0; i < data.Length; i++)
        {
            if (term(data[i]))
            {
                return i;
            }
        }

        return -1;
    }
}
