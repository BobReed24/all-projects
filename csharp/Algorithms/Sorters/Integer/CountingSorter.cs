using System;
using System.Linq;

namespace Algorithms.Sorters.Integer;

public class CountingSorter : IIntegerSorter
{
    
    public void Sort(int[] array)
    {
        if (array.Length == 0)
        {
            return;
        }

        var max = array.Max();
        var min = array.Min();
        var count = new int[max - min + 1];
        var output = new int[array.Length];
        for (var i = 0; i < array.Length; i++)
        {
            count[array[i] - min]++;
        }

        for (var i = 1; i < count.Length; i++)
        {
            count[i] += count[i - 1];
        }

        for (var i = array.Length - 1; i >= 0; i--)
        {
            output[count[array[i] - min] - 1] = array[i];
            count[array[i] - min]--;
        }

        Array.Copy(output, array, array.Length);
    }
}
