using System;
using System.Collections.Generic;
using System.Linq;

namespace DataStructures.Queue;

public class ListBasedQueue<T>
{
    private readonly LinkedList<T> queue;

    public ListBasedQueue() => queue = new LinkedList<T>();

    public void Clear()
    {
        queue.Clear();
    }

    public T Dequeue()
    {
        if (queue.First is null)
        {
            throw new InvalidOperationException("There are no items in the queue.");
        }

        var item = queue.First;
        queue.RemoveFirst();
        return item.Value;
    }

    public bool IsEmpty() => !queue.Any();

    public bool IsFull() => false;

    public T Peek()
    {
        if (queue.First is null)
        {
            throw new InvalidOperationException("There are no items in the queue.");
        }

        return queue.First.Value;
    }

    public void Enqueue(T item)
    {
        queue.AddLast(item);
    }
}
