using System.Collections.Generic;

namespace Algorithms.Sorters.Comparison;

public class ShellSorter<T> : IComparisonSorter<T>
{
    
    public void Sort(T[] array, IComparer<T> comparer)
    {
        for (var step = array.Length / 2; step > 0; step /= 2)
        {
            for (var i = 0; i < step; i++)
            {
                GappedBubbleSort(array, comparer, i, step);
            }
        }
    }

    private static void GappedBubbleSort(T[] array, IComparer<T> comparer, int start, int step)
    {
        for (var j = start; j < array.Length - step; j += step)
        {
            var wasChanged = false;
            for (var k = start; k < array.Length - j - step; k += step)
            {
                if (comparer.Compare(array[k], array[k + step]) > 0)
                {
                    var temp = array[k];
                    array[k] = array[k + step];
                    array[k + step] = temp;
                    wasChanged = true;
                }
            }

            if (!wasChanged)
            {
                break;
            }
        }
    }
}
