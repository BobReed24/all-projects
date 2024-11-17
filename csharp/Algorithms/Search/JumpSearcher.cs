using System;

namespace Algorithms.Search;

public class JumpSearcher<T> where T : IComparable<T>
{
    
    public int FindIndex(T[] sortedArray, T searchItem)
    {
        if (sortedArray is null)
        {
            throw new ArgumentNullException("sortedArray");
        }

        if (searchItem is null)
        {
            throw new ArgumentNullException("searchItem");
        }

        int jumpStep = (int)Math.Floor(Math.Sqrt(sortedArray.Length));
        int currentIndex = 0;
        int nextIndex = jumpStep;

        if (sortedArray.Length != 0)
        {
            while (sortedArray[nextIndex - 1].CompareTo(searchItem) < 0)
            {
                currentIndex = nextIndex;
                nextIndex += jumpStep;

                if (nextIndex >= sortedArray.Length)
                {
                    nextIndex = sortedArray.Length - 1;
                    break;
                }
            }

            for (int i = currentIndex; i <= nextIndex; i++)
            {
                if (sortedArray[i].CompareTo(searchItem) == 0)
                {
                    return i;
                }
            }
        }

        return -1;
    }
}
