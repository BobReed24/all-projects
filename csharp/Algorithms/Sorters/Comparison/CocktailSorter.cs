using System.Collections.Generic;

namespace Algorithms.Sorters.Comparison;

public class CocktailSorter<T> : IComparisonSorter<T>
{
    
    public void Sort(T[] array, IComparer<T> comparer) => CocktailSort(array, comparer);

    private static void CocktailSort(IList<T> array, IComparer<T> comparer)
    {
        var swapped = true;

        var startIndex = 0;
        var endIndex = array.Count - 1;

        while (swapped)
        {
            for (var i = startIndex; i < endIndex; i++)
            {
                if (comparer.Compare(array[i], array[i + 1]) != 1)
                {
                    continue;
                }

                var highValue = array[i];
                array[i] = array[i + 1];
                array[i + 1] = highValue;
            }

            endIndex--;
            swapped = false;

            for (var i = endIndex; i > startIndex; i--)
            {
                if (comparer.Compare(array[i], array[i - 1]) != -1)
                {
                    continue;
                }

                var highValue = array[i];
                array[i] = array[i - 1];
                array[i - 1] = highValue;

                swapped = true;
            }

            startIndex++;
        }
    }
}
