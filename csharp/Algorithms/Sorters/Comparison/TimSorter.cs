using System;
using System.Collections.Generic;
using Algorithms.Sorters.Utils;

namespace Algorithms.Sorters.Comparison;

public class TimSorter<T> : IComparisonSorter<T>
{
    private readonly int minMerge;
    private readonly int initMinGallop;

    private readonly TimChunk<T>[] chunkPool = new TimChunk<T>[2];

    private readonly int[] runBase;
    private readonly int[] runLengths;

    private int minGallop;
    private int stackSize;

    private IComparer<T> comparer = default!;

    private class TimChunk<Tc>
    {
        public Tc[] Array { get; set; } = default!;

        public int Index { get; set; }

        public int Remaining { get; set; }

        public int Wins { get; set; }
    }

    public TimSorter(TimSorterSettings settings, IComparer<T> comparer)
    {
        initMinGallop = minGallop;
        runBase = new int[85];
        runLengths = new int[85];

        stackSize = 0;

        minGallop = settings.MinGallop;
        minMerge = settings.MinMerge;

        this.comparer = comparer ?? Comparer<T>.Default;
    }

    public void Sort(T[] array, IComparer<T> comparer)
    {
        this.comparer = comparer;
        var start = 0;
        var remaining = array.Length;

        if (remaining < minMerge)
        {
            if (remaining < 2)
            {
                
                return;
            }

            BinarySort(array, start, remaining, start);
            return;
        }

        var minRun = MinRunLength(remaining, minMerge);

        do
        {
            
            var runLen = CountRunAndMakeAscending(array, start);

            if (runLen < minRun)
            {
                var force = Math.Min(minRun, remaining);
                BinarySort(array, start, start + force, start + runLen);
                runLen = force;
            }

            runBase[stackSize] = start;
            runLengths[stackSize] = runLen;
            stackSize++;

            MergeCollapse(array);

            start += runLen;
            remaining -= runLen;
        }
        while (remaining != 0);

        MergeForceCollapse(array);
    }

    private static int MinRunLength(int total, int minRun)
    {
        var r = 0;
        while (total >= minRun)
        {
            r |= total & 1;
            total >>= 1;
        }

        return total + r;
    }

    private static void ReverseRange(T[] array, int start, int end)
    {
        end--;
        while (start < end)
        {
            var t = array[start];
            array[start++] = array[end];
            array[end--] = t;
        }
    }

    private static bool NeedsMerge(TimChunk<T> left, TimChunk<T> right, ref int dest)
    {
        right.Array[dest++] = right.Array[right.Index++];
        if (--right.Remaining == 0)
        {
            Array.Copy(left.Array, left.Index, right.Array, dest, left.Remaining);
            return false;
        }

        if (left.Remaining == 1)
        {
            Array.Copy(right.Array, right.Index, right.Array, dest, right.Remaining);
            right.Array[dest + right.Remaining] = left.Array[left.Index];
            return false;
        }

        return true;
    }

    private static void FinalizeMerge(TimChunk<T> left, TimChunk<T> right, int dest)
    {
        if (left.Remaining == 1)
        {
            Array.Copy(right.Array, right.Index, right.Array, dest, right.Remaining);
            right.Array[dest + right.Remaining] = left.Array[left.Index];
        }
        else if (left.Remaining == 0)
        {
            throw new ArgumentException("Comparison method violates its general contract!");
        }
        else
        {
            Array.Copy(left.Array, left.Index, right.Array, dest, left.Remaining);
        }
    }

    private int CountRunAndMakeAscending(T[] array, int start)
    {
        var runHi = start + 1;
        if (runHi == array.Length)
        {
            return 1;
        }

        if (comparer.Compare(array[runHi++], array[start]) < 0)
        { 
            while (runHi < array.Length && comparer.Compare(array[runHi], array[runHi - 1]) < 0)
            {
                runHi++;
            }

            ReverseRange(array, start, runHi);
        }
        else
        { 
            while (runHi < array.Length && comparer.Compare(array[runHi], array[runHi - 1]) >= 0)
            {
                runHi++;
            }
        }

        return runHi - start;
    }

    private void BinarySort(T[] array, int start, int end, int first)
    {
        if (first >= end || first <= start)
        {
            first = start + 1;
        }

        for (; first < end; first++)
        {
            var target = array[first];
            var targetInsertLocation = BinarySearch(array, start, first - 1, target);
            Array.Copy(array, targetInsertLocation, array, targetInsertLocation + 1, first - targetInsertLocation);

            array[targetInsertLocation] = target;
        }
    }

    private int BinarySearch(T[] array, int left, int right, T target)
    {
        while (left < right)
        {
            var mid = (left + right) >> 1;
            if (comparer.Compare(target, array[mid]) < 0)
            {
                right = mid;
            }
            else
            {
                left = mid + 1;
            }
        }

        return comparer.Compare(target, array[left]) < 0
            ? left
            : left + 1;
    }

    private void MergeCollapse(T[] array)
    {
        while (stackSize > 1)
        {
            var n = stackSize - 2;
            if (n > 0 && runLengths[n - 1] <= runLengths[n] + runLengths[n + 1])
            {
                if (runLengths[n - 1] < runLengths[n + 1])
                {
                    n--;
                }

                MergeAt(array, n);
            }
            else if (runLengths[n] <= runLengths[n + 1])
            {
                MergeAt(array, n);
            }
            else
            {
                break;
            }
        }
    }

    private void MergeForceCollapse(T[] array)
    {
        while (stackSize > 1)
        {
            var n = stackSize - 2;
            if (n > 0 && runLengths[n - 1] < runLengths[n + 1])
            {
                n--;
            }

            MergeAt(array, n);
        }
    }

    private void MergeAt(T[] array, int index)
    {
        var baseA = runBase[index];
        var lenA = runLengths[index];
        var baseB = runBase[index + 1];
        var lenB = runLengths[index + 1];

        runLengths[index] = lenA + lenB;

        if (index == stackSize - 3)
        {
            runBase[index + 1] = runBase[index + 2];
            runLengths[index + 1] = runLengths[index + 2];
        }

        stackSize--;

        var k = GallopingStrategy<T>.GallopRight(array, array[baseB], baseA, lenA, comparer);

        baseA += k;
        lenA -= k;

        if (lenA <= 0)
        {
            return;
        }

        lenB = GallopingStrategy<T>.GallopLeft(array, array[baseA + lenA - 1], baseB, lenB, comparer);

        if (lenB <= 0)
        {
            return;
        }

        Merge(array, baseA, lenA, baseB, lenB);
    }

    private void Merge(T[] array, int baseA, int lenA, int baseB, int lenB)
    {
        var endA = baseA + lenA;
        var dest = baseA;

        TimChunk<T> left = new()
        {
            Array = array[baseA..endA],
            Remaining = lenA,
        };

        TimChunk<T> right = new()
        {
            Array = array,
            Index = baseB,
            Remaining = lenB,
        };

        if (!TimSorter<T>.NeedsMerge(left, right, ref dest))
        {
            
            return;
        }

        var gallop = minGallop;

        while (RunMerge(left, right, ref dest, ref gallop))
        {
            
            gallop = gallop > 0
                ? gallop + 2
                : 2;
        }

        minGallop = gallop >= 1
            ? gallop
            : 1;

        FinalizeMerge(left, right, dest);
    }

    private bool RunMerge(TimChunk<T> left, TimChunk<T> right, ref int dest, ref int gallop)
    {
        
        left.Wins = 0;
        right.Wins = 0;

        if (StableMerge(left, right, ref dest, gallop))
        {
            
            return false;
        }

        do
        {
            if (GallopMerge(left, right, ref dest))
            {
                
                return false;
            }

            gallop--;
        }
        while (left.Wins >= initMinGallop || right.Wins >= initMinGallop);

        return true;
    }

    private bool StableMerge(TimChunk<T> left, TimChunk<T> right, ref int dest, int gallop)
    {
        do
        {
            if (comparer.Compare(right.Array[right.Index], left.Array[left.Index]) < 0)
            {
                right.Array[dest++] = right.Array[right.Index++];
                right.Wins++;
                left.Wins = 0;
                if (--right.Remaining == 0)
                {
                    return true;
                }
            }
            else
            {
                right.Array[dest++] = left.Array[left.Index++];
                left.Wins++;
                right.Wins = 0;
                if (--left.Remaining == 1)
                {
                    return true;
                }
            }
        }
        while ((left.Wins | right.Wins) < gallop);

        return false;
    }

    private bool GallopMerge(TimChunk<T> left, TimChunk<T> right, ref int dest)
    {
        left.Wins = GallopingStrategy<T>.GallopRight(left.Array, right.Array[right.Index], left.Index, left.Remaining, comparer);
        if (left.Wins != 0)
        {
            Array.Copy(left.Array, left.Index, right.Array, dest, left.Wins);
            dest += left.Wins;
            left.Index += left.Wins;
            left.Remaining -= left.Wins;
            if (left.Remaining <= 1)
            {
                return true;
            }
        }

        right.Array[dest++] = right.Array[right.Index++];
        if (--right.Remaining == 0)
        {
            return true;
        }

        right.Wins = GallopingStrategy<T>.GallopLeft(right.Array, left.Array[left.Index], right.Index, right.Remaining, comparer);
        if (right.Wins != 0)
        {
            Array.Copy(right.Array, right.Index, right.Array, dest, right.Wins);
            dest += right.Wins;
            right.Index += right.Wins;
            right.Remaining -= right.Wins;
            if (right.Remaining == 0)
            {
                return true;
            }
        }

        right.Array[dest++] = left.Array[left.Index++];
        if (--left.Remaining == 1)
        {
            return true;
        }

        return false;
    }
}
