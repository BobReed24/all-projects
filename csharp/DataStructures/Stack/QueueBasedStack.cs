using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DataStructures.Stack;

public class QueueBasedStack<T>
{
    private readonly Queue<T> queue;

    public QueueBasedStack() => queue = new Queue<T>();

    public void Clear() => queue.Clear();

    public bool IsEmpty() => queue.Count == 0;

    public void Push(T item) => queue.Enqueue(item);

    public T Pop()
    {
        if (IsEmpty())
        {
            throw new InvalidOperationException("The stack contains no items.");
        }

        for (int i = 0; i < queue.Count - 1; i++)
        {
            queue.Enqueue(queue.Dequeue());
        }

        return queue.Dequeue();
    }

    public T Peek()
    {
        if (IsEmpty())
        {
            throw new InvalidOperationException("The stack contains no items.");
        }

        for (int i = 0; i < queue.Count - 1; i++)
        {
            queue.Enqueue(queue.Dequeue());
        }

        var item = queue.Peek();
        queue.Enqueue(queue.Dequeue());
        return item;
    }

    public int Length() => queue.Count;
}
