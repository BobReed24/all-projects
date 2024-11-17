using System;
using System.Collections.Generic;

namespace DataStructures.Heap;

public class BinaryHeap<T>
{
    
    private readonly Comparer<T> comparer;

    private readonly List<T> data;

    public BinaryHeap()
    {
        data = new List<T>();
        comparer = Comparer<T>.Default;
    }

    public BinaryHeap(Comparer<T> customComparer)
    {
        data = new List<T>();
        comparer = customComparer;
    }

    public int Count => data.Count;

    public void Push(T element)
    {
        data.Add(element);
        HeapifyUp(data.Count - 1);
    }

    public T Pop()
    {
        if (Count == 0)
        {
            throw new InvalidOperationException("Heap is empty!");
        }

        var elem = data[0];
        data[0] = data[^1];
        data.RemoveAt(data.Count - 1);
        HeapifyDown(0);

        return elem;
    }

    public T Peek()
    {
        if (Count == 0)
        {
            throw new InvalidOperationException("Heap is empty!");
        }

        return data[0];
    }

    public T PushPop(T element)
    {
        if (Count == 0)
        {
            return element;
        }

        if (comparer.Compare(element, data[0]) < 0)
        {
            var tmp = data[0];
            data[0] = element;
            HeapifyDown(0);
            return tmp;
        }

        return element;
    }

    public bool Contains(T element) => data.Contains(element);

    public void Remove(T element)
    {
        var idx = data.IndexOf(element);

        if (idx == -1)
        {
            throw new ArgumentException($"{element} not in heap!");
        }

        Swap(idx, data.Count - 1);
        var tmp = data[^1];
        data.RemoveAt(data.Count - 1);

        if (idx < data.Count)
        {
            if (comparer.Compare(tmp, data[idx]) > 0)
            {
                HeapifyDown(idx);
            }
            else
            {
                HeapifyUp(idx);
            }
        }
    }

    private void Swap(int idx1, int idx2)
    {
        var tmp = data[idx1];
        data[idx1] = data[idx2];
        data[idx2] = tmp;
    }

    private void HeapifyUp(int elemIdx)
    {
        var parent = (elemIdx - 1) / 2;

        if (parent >= 0 && comparer.Compare(data[elemIdx], data[parent]) > 0)
        {
            Swap(elemIdx, parent);
            HeapifyUp(parent);
        }
    }

    private void HeapifyDown(int elemIdx)
    {
        var left = 2 * elemIdx + 1;
        var right = 2 * elemIdx + 2;

        var leftLargerThanElem = left < Count && comparer.Compare(data[elemIdx], data[left]) < 0;
        var rightLargerThanElem = right < Count && comparer.Compare(data[elemIdx], data[right]) < 0;
        var leftLargerThanRight = left < Count && right < Count && comparer.Compare(data[left], data[right]) > 0;

        if (leftLargerThanElem && leftLargerThanRight)
        {
            Swap(elemIdx, left);
            HeapifyDown(left);
        }
        else if (rightLargerThanElem && !leftLargerThanRight)
        {
            Swap(elemIdx, right);
            HeapifyDown(right);
        }
    }
}
