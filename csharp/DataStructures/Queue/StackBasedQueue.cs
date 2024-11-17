using System;
using System.Collections.Generic;

namespace DataStructures.Queue;

public class StackBasedQueue<T>
{
    private readonly Stack<T> input;
    private readonly Stack<T> output;

    public StackBasedQueue()
    {
        input = new Stack<T>();
        output = new Stack<T>();
    }

    public void Clear()
    {
        input.Clear();
        output.Clear();
    }

    public T Dequeue()
    {
        if (input.Count == 0 && output.Count == 0)
        {
            throw new InvalidOperationException("The queue contains no items.");
        }

        if (output.Count == 0)
        {
            while (input.Count > 0)
            {
                var item = input.Pop();
                output.Push(item);
            }
        }

        return output.Pop();
    }

    public bool IsEmpty() => input.Count == 0 && output.Count == 0;

    public bool IsFull() => false;

    public T Peek()
    {
        if (input.Count == 0 && output.Count == 0)
        {
            throw new InvalidOperationException("The queue contains no items.");
        }

        if (output.Count == 0)
        {
            while (input.Count > 0)
            {
                var item = input.Pop();
                output.Push(item);
            }
        }

        return output.Peek();
    }

    public void Enqueue(T item) => input.Push(item);
}
