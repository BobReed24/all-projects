using System.Collections;
using System.Collections.Generic;

namespace DataStructures;

public class SortedList<T> : IEnumerable<T>
{
    private readonly IComparer<T> comparer;
    private readonly List<T> memory;

    public SortedList()
        : this(Comparer<T>.Default)
    {
    }

    public int Count => memory.Count;

    public SortedList(IComparer<T> comparer)
    {
        memory = new List<T>();
        this.comparer = comparer;
    }

    public void Add(T item)
    {
        var index = IndexFor(item, out _);
        memory.Insert(index, item);
    }

    public T this[int i] => memory[i];

    public void Clear()
        => memory.Clear();

    public bool Contains(T item)
    {
        _ = IndexFor(item, out var found);
        return found;
    }

    public bool TryRemove(T item)
    {
        var index = IndexFor(item, out var found);

        if (found)
        {
            memory.RemoveAt(index);
        }

        return found;
    }

    public IEnumerator<T> GetEnumerator()
        => memory.GetEnumerator();

    IEnumerator IEnumerable.GetEnumerator()
        => GetEnumerator();

    private int IndexFor(T item, out bool found)
    {
        var left = 0;
        var right = memory.Count;

        while (right - left > 0)
        {
            var mid = (left + right) / 2;

            switch (comparer.Compare(item, memory[mid]))
            {
                case > 0:
                    left = mid + 1;
                    break;
                case < 0:
                    right = mid;
                    break;
                default:
                    found = true;
                    return mid;
            }
        }

        found = false;
        return left;
    }
}
