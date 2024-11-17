using System.Collections.Generic;

namespace Algorithms.Sorters.Comparison;

public abstract class QuickSorter<T> : IComparisonSorter<T>
{
    
    public void Sort(T[] array, IComparer<T> comparer) => Sort(array, comparer, 0, array.Length - 1);

    protected abstract T SelectPivot(T[] array, IComparer<T> comparer, int left, int right);

    private void Sort(T[] array, IComparer<T> comparer, int left, int right)
    {
        if (left >= right)
        {
            return;
        }

        var p = Partition(array, comparer, left, right);
        Sort(array, comparer, left, p);
        Sort(array, comparer, p + 1, right);
    }

    private int Partition(T[] array, IComparer<T> comparer, int left, int right)
    {
        var pivot = SelectPivot(array, comparer, left, right);
        var nleft = left;
        var nright = right;
        while (true)
        {
            while (comparer.Compare(array[nleft], pivot) < 0)
            {
                nleft++;
            }

            while (comparer.Compare(array[nright], pivot) > 0)
            {
                nright--;
            }

            if (nleft >= nright)
            {
                return nright;
            }

            var t = array[nleft];
            array[nleft] = array[nright];
            array[nright] = t;

            nleft++;
            nright--;
        }
    }
}
