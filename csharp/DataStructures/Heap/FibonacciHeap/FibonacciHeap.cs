using System;
using System.Collections.Generic;
using System.Linq;

namespace DataStructures.Heap.FibonacciHeap;

public class FibonacciHeap<T> where T : IComparable
{
    
    public int Count { get; set; }

    private FHeapNode<T>? MinItem { get; set; }

    public FHeapNode<T> Push(T x)
    {
        Count++;

        var newItem = new FHeapNode<T>(x);

        if (MinItem == null)
        {
            MinItem = newItem;
        }
        else
        {
            MinItem.AddRight(newItem);

            if (newItem.Key.CompareTo(MinItem.Key) < 0)
            {
                MinItem = newItem;
            }
        }

        return newItem;
    }

    public void Union(FibonacciHeap<T> other)
    {
        
        if (other.MinItem == null)
        {
            return;
        }

        if (MinItem == null)
        {
            
            MinItem = other.MinItem;
            Count = other.Count;

            other.MinItem = null;
            other.Count = 0;

            return;
        }

        Count += other.Count;

        MinItem.ConcatenateRight(other.MinItem);

        if (other.MinItem.Key.CompareTo(MinItem.Key) < 0)
        {
            MinItem = other.MinItem;
        }

        other.MinItem = null;
        other.Count = 0;
    }

    public T Pop()
    {
        FHeapNode<T>? z = null;
        if (MinItem == null)
        {
            throw new InvalidOperationException("Heap is empty!");
        }

        z = MinItem;

        if (z.Child != null)
        {
            foreach (var x in SiblingIterator(z.Child))
            {
                x.Parent = null;
            }

            z.ConcatenateRight(z.Child);
        }

        if (Count == 1)
        {
            MinItem = null;
            Count = 0;
            return z.Key;
        }

        MinItem = MinItem.Right;

        z.Remove();

        Consolidate();

        Count -= 1;

        return z.Key;
    }

    public T Peek()
    {
        if (MinItem == null)
        {
            throw new InvalidOperationException("The heap is empty");
        }

        return MinItem.Key;
    }

    public void DecreaseKey(FHeapNode<T> x, T k)
    {
        if (MinItem == null)
        {
            throw new ArgumentException($"{nameof(x)} is not from the heap");
        }

        if (x.Key == null)
        {
            throw new ArgumentException("x has no value");
        }

        if (k.CompareTo(x.Key) > 0)
        {
            throw new InvalidOperationException("Value cannot be increased");
        }

        x.Key = k;
        var y = x.Parent;
        if (y != null && x.Key.CompareTo(y.Key) < 0)
        {
            Cut(x, y);
            CascadingCut(y);
        }

        if (x.Key.CompareTo(MinItem.Key) < 0)
        {
            MinItem = x;
        }
    }

    protected void Cut(FHeapNode<T> x, FHeapNode<T> y)
    {
        if (MinItem == null)
        {
            throw new InvalidOperationException("Heap malformed");
        }

        if (y.Degree == 1)
        {
            y.Child = null;
            MinItem.AddRight(x);
        }
        else if (y.Degree > 1)
        {
            x.Remove();
        }
        else
        {
            throw new InvalidOperationException("Heap malformed");
        }

        y.Degree--;
        x.Mark = false;
        x.Parent = null;
    }

    protected void CascadingCut(FHeapNode<T> y)
    {
        var z = y.Parent;
        if (z != null)
        {
            if (!y.Mark)
            {
                y.Mark = true;
            }
            else
            {
                Cut(y, z);
                CascadingCut(z);
            }
        }
    }

    protected void Consolidate()
    {
        if (MinItem == null)
        {
            return;
        }

        var maxDegree = 1 + (int)Math.Log(Count, (1 + Math.Sqrt(5)) / 2);

        var a = new FHeapNode<T>?[maxDegree];
        var siblings = SiblingIterator(MinItem).ToList();
        foreach (var w in siblings)
        {
            var x = w;
            var d = x.Degree;

            var y = a[d];

            while (y != null)
            {
                if (x.Key.CompareTo(y.Key) > 0)
                {
                    
                    var temp = x;
                    x = y;
                    y = temp;
                }

                FibHeapLink(y, x);

                a[d] = null;

                d++;

                y = a[d];
            }

            a[d] = x;
        }

        ReconstructHeap(a);
    }

    private void ReconstructHeap(FHeapNode<T>?[] a)
    {
        
        MinItem = null;

        for (var i = 0; i < a.Length; i++)
        {
            var r = a[i];
            if (r == null)
            {
                continue;
            }

            if (MinItem == null)
            {
                
                MinItem = r;

                MinItem.SetSiblings(MinItem, MinItem);
                MinItem.Parent = null;
            }
            else
            {
                
                MinItem.AddRight(r);

                if (MinItem.Key.CompareTo(r.Key) > 0)
                {
                    MinItem = a[i];
                }
            }
        }
    }

    private void FibHeapLink(FHeapNode<T> y, FHeapNode<T> x)
    {
        y.Remove();
        x.AddChild(y);
        y.Mark = false;
    }

    private IEnumerable<FHeapNode<T>> SiblingIterator(FHeapNode<T> node)
    {
        var currentNode = node;
        yield return currentNode;

        currentNode = node.Right;
        while (currentNode != node)
        {
            yield return currentNode;
            currentNode = currentNode.Right;
        }
    }
}
