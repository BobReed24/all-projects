using System;
using System.Collections.Generic;

namespace DataStructures.Stack;

public class ListBasedStack<T>
{
    
    private readonly LinkedList<T> stack;

    public ListBasedStack() => stack = new LinkedList<T>();

    public ListBasedStack(T item)
        : this() => Push(item);

    public ListBasedStack(IEnumerable<T> items)
        : this()
    {
        foreach (var item in items)
        {
            Push(item);
        }
    }

    public int Count => stack.Count;

    public void Clear() => stack.Clear();

    public bool Contains(T item) => stack.Contains(item);

    public T Peek()
    {
        if (stack.First is null)
        {
            throw new InvalidOperationException("Stack is empty");
        }

        return stack.First.Value;
    }

    public T Pop()
    {
        if (stack.First is null)
        {
            throw new InvalidOperationException("Stack is empty");
        }

        var item = stack.First.Value;
        stack.RemoveFirst();
        return item;
    }

    public void Push(T item) => stack.AddFirst(item);
}
