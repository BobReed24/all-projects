using System;

namespace Algorithms.Search;

public class FibonacciSearcher<T> where T : IComparable<T>
{
    
    public int FindIndex(T[] array, T item)
    {
        if (array is null)
        {
            throw new ArgumentNullException("array");
        }

        if (item is null)
        {
            throw new ArgumentNullException("item");
        }

        var arrayLength = array.Length;

        if (arrayLength > 0)
        {
            
            var fibonacciNumberBeyondPrevious = 0;
            var fibonacciNumPrevious = 1;
            var fibonacciNum = fibonacciNumPrevious;

            while (fibonacciNum <= arrayLength)
            {
                fibonacciNumberBeyondPrevious = fibonacciNumPrevious;
                fibonacciNumPrevious = fibonacciNum;
                fibonacciNum = fibonacciNumberBeyondPrevious + fibonacciNumPrevious;
            }

            var offset = -1;

            while (fibonacciNum > 1)
            {
                var index = Math.Min(offset + fibonacciNumberBeyondPrevious, arrayLength - 1);

                switch (item.CompareTo(array[index]))
                {
                    
                    case > 0:
                        fibonacciNum = fibonacciNumPrevious;
                        fibonacciNumPrevious = fibonacciNumberBeyondPrevious;
                        fibonacciNumberBeyondPrevious = fibonacciNum - fibonacciNumPrevious;
                        offset = index;
                        break;

                    case < 0:
                        fibonacciNum = fibonacciNumberBeyondPrevious;
                        fibonacciNumPrevious = fibonacciNumPrevious - fibonacciNumberBeyondPrevious;
                        fibonacciNumberBeyondPrevious = fibonacciNum - fibonacciNumPrevious;
                        break;
                    default:
                        return index;
                }
            }

            if (fibonacciNumPrevious == 1 && item.Equals(array[^1]))
            {
                return arrayLength - 1;
            }
        }

        return -1;
    }
}
