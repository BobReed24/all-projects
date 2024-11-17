using System;
using System.Collections.Generic;
using System.Linq;

namespace DataStructures.Heap;

public class MinMaxHeap<T>
{
    private readonly List<T> heap;

    public MinMaxHeap(IEnumerable<T>? collection = null, IComparer<T>? comparer = null)
    {
        Comparer = comparer ?? Comparer<T>.Default;
        collection ??= Enumerable.Empty<T>();

        heap = collection.ToList();
        for (var i = Count / 2 - 1; i >= 0; --i)
        {
            PushDown(i);
        }
    }

    public IComparer<T> Comparer { get; }

    public int Count => heap.Count;

    public void Add(T item)
    {
        heap.Add(item);
        PushUp(Count - 1);
    }

    public T ExtractMax()
    {
        if (Count == 0)
        {
            throw new InvalidOperationException("Heap is empty");
        }

        var max = GetMax();
        RemoveNode(GetMaxNodeIndex());
        return max;
    }

    public T ExtractMin()
    {
        if (Count == 0)
        {
            throw new InvalidOperationException("Heap is empty");
        }

        var min = GetMin();
        RemoveNode(0);
        return min;
    }

    public T GetMax()
    {
        if (Count == 0)
        {
            throw new InvalidOperationException("Heap is empty");
        }

        return heap[GetMaxNodeIndex()];
    }

    public T GetMin()
    {
        if (Count == 0)
        {
            throw new InvalidOperationException("Heap is empty");
        }

        return heap[0];
    }

    private int IndexOfMaxChildOrGrandchild(int index)
    {
        var descendants = new[]
        {
            2 * index + 1,
            2 * index + 2,
            4 * index + 3,
            4 * index + 4,
            4 * index + 5,
            4 * index + 6,
        };
        var resIndex = descendants[0];
        foreach (var descendant in descendants)
        {
            if (descendant >= Count)
            {
                break;
            }

            if (Comparer.Compare(heap[descendant], heap[resIndex]) > 0)
            {
                resIndex = descendant;
            }
        }

        return resIndex;
    }

    private int IndexOfMinChildOrGrandchild(int index)
    {
        var descendants = new[] { 2 * index + 1, 2 * index + 2, 4 * index + 3, 4 * index + 4, 4 * index + 5, 4 * index + 6 };
        var resIndex = descendants[0];
        foreach (var descendant in descendants)
        {
            if (descendant >= Count)
            {
                break;
            }

            if (Comparer.Compare(heap[descendant], heap[resIndex]) < 0)
            {
                resIndex = descendant;
            }
        }

        return resIndex;
    }

    private int GetMaxNodeIndex()
    {
        return Count switch
        {
            0 => throw new InvalidOperationException("Heap is empty"),
            1 => 0,
            2 => 1,
            _ => Comparer.Compare(heap[1], heap[2]) > 0 ? 1 : 2,
        };
    }

    private bool HasChild(int index) => index * 2 + 1 < Count;

    private bool IsGrandchild(int node, int grandchild) => grandchild > 2 && Grandparent(grandchild) == node;

    private bool IsMinLevelIndex(int index)
    {
        
        const uint minLevelsBits = 0x55555555;
        const uint maxLevelsBits = 0xAAAAAAAA;
        return ((index + 1) & minLevelsBits) > ((index + 1) & maxLevelsBits);
    }

    private int Parent(int index) => (index - 1) / 2;

    private int Grandparent(int index) => ((index - 1) / 2 - 1) / 2;

    private void PushDown(int index)
    {
        if (IsMinLevelIndex(index))
        {
            PushDownMin(index);
        }
        else
        {
            PushDownMax(index);
        }
    }

    private void PushDownMax(int index)
    {
        if (!HasChild(index))
        {
            return;
        }

        var maxIndex = IndexOfMaxChildOrGrandchild(index);

        if (IsGrandchild(index, maxIndex))
        {
            if (Comparer.Compare(heap[maxIndex], heap[index]) > 0)
            {
                SwapNodes(maxIndex, index);
                if (Comparer.Compare(heap[maxIndex], heap[Parent(maxIndex)]) < 0)
                {
                    SwapNodes(maxIndex, Parent(maxIndex));
                }

                PushDownMax(maxIndex);
            }
        }
        else
        {
            if (Comparer.Compare(heap[maxIndex], heap[index]) > 0)
            {
                SwapNodes(maxIndex, index);
            }
        }
    }

    private void PushDownMin(int index)
    {
        if (!HasChild(index))
        {
            return;
        }

        var minIndex = IndexOfMinChildOrGrandchild(index);

        if (IsGrandchild(index, minIndex))
        {
            if (Comparer.Compare(heap[minIndex], heap[index]) < 0)
            {
                SwapNodes(minIndex, index);
                if (Comparer.Compare(heap[minIndex], heap[Parent(minIndex)]) > 0)
                {
                    SwapNodes(minIndex, Parent(minIndex));
                }

                PushDownMin(minIndex);
            }
        }
        else
        {
            if (Comparer.Compare(heap[minIndex], heap[index]) < 0)
            {
                SwapNodes(minIndex, index);
            }
        }
    }

    private void PushUp(int index)
    {
        if (index == 0)
        {
            return;
        }

        var parent = Parent(index);

        if (IsMinLevelIndex(index))
        {
            if (Comparer.Compare(heap[index], heap[parent]) > 0)
            {
                SwapNodes(index, parent);
                PushUpMax(parent);
            }
            else
            {
                PushUpMin(index);
            }
        }
        else
        {
            if (Comparer.Compare(heap[index], heap[parent]) < 0)
            {
                SwapNodes(index, parent);
                PushUpMin(parent);
            }
            else
            {
                PushUpMax(index);
            }
        }
    }

    private void PushUpMax(int index)
    {
        if (index > 2)
        {
            var grandparent = Grandparent(index);
            if (Comparer.Compare(heap[index], heap[grandparent]) > 0)
            {
                SwapNodes(index, grandparent);
                PushUpMax(grandparent);
            }
        }
    }

    private void PushUpMin(int index)
    {
        if (index > 2)
        {
            var grandparent = Grandparent(index);
            if (Comparer.Compare(heap[index], heap[grandparent]) < 0)
            {
                SwapNodes(index, grandparent);
                PushUpMin(grandparent);
            }
        }
    }

    private void RemoveNode(int index)
    {
        SwapNodes(index, Count - 1);
        heap.RemoveAt(Count - 1);
        if (Count != 0)
        {
            PushDown(index);
        }
    }

    private void SwapNodes(int i, int j)
    {
        var temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}
