using System;
using System.Collections.Generic;

namespace Algorithms.Search.AStar;

public class PriorityQueue<T>
    where T : IComparable<T>
{
    private readonly bool isDescending;

    private readonly List<T> list;

    public PriorityQueue(bool isDescending = false)
    {
        this.isDescending = isDescending;
        list = new List<T>();
    }

    public PriorityQueue(int capacity, bool isDescending = false)
    {
        list = new List<T>(capacity);
        this.isDescending = isDescending;
    }

    public PriorityQueue(IEnumerable<T> collection, bool isDescending = false)
        : this()
    {
        this.isDescending = isDescending;
        foreach (var item in collection)
        {
            Enqueue(item);
        }
    }

    public int Count => list.Count;

    public void Enqueue(T x)
    {
        list.Add(x);
        var i = Count - 1; 

        while (i > 0)
        {
            var p = (i - 1) / 2; 
            if ((isDescending ? -1 : 1) * list[p].CompareTo(x) <= 0)
            {
                break;
            }

            list[i] = list[p]; 
            i = p; 
        }

        if (Count > 0)
        {
            list[i] = x; 
        }
    }

    public T Dequeue()
    {
        var target = Peek(); 
        var root = list[Count - 1]; 
        list.RemoveAt(Count - 1); 

        var i = 0;
        while (i * 2 + 1 < Count)
        {
            var a = i * 2 + 1; 
            var b = i * 2 + 2; 
            var c = b < Count && (isDescending ? -1 : 1) * list[b].CompareTo(list[a]) < 0
                ? b
                : a; 

            if ((isDescending ? -1 : 1) * list[c].CompareTo(root) >= 0)
            {
                break;
            }

            list[i] = list[c];
            i = c;
        }

        if (Count > 0)
        {
            list[i] = root;
        }

        return target;
    }

    public T Peek()
    {
        if (Count == 0)
        {
            throw new InvalidOperationException("Queue is empty.");
        }

        return list[0];
    }

    public void Clear() => list.Clear();

    public List<T> GetData() => list;
}
