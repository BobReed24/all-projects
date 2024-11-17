using System;

namespace DataStructures.Heap.FibonacciHeap;

public class FHeapNode<T> where T : IComparable
{
    
    public FHeapNode(T key)
    {
        Key = key;

        Left = Right = this;
        Parent = Child = null;
    }

    public T Key { get; set; }

    public FHeapNode<T>? Parent { get; set; }

    public FHeapNode<T> Left { get; set; }

    public FHeapNode<T> Right { get; set; }

    public FHeapNode<T>? Child { get; set; }

    public bool Mark { get; set; }

    public int Degree { get; set; }

    public void SetSiblings(FHeapNode<T> left, FHeapNode<T> right)
    {
        Left = left;
        Right = right;
    }

    public void AddRight(FHeapNode<T> node)
    {
        Right.Left = node;
        node.Right = Right;
        node.Left = this;
        Right = node;
    }

    public void AddChild(FHeapNode<T> node)
    {
        Degree++;

        if (Child == null)
        {
            Child = node;
            Child.Parent = this;
            Child.Left = Child.Right = Child;

            return;
        }

        Child.AddRight(node);
    }

    public void Remove()
    {
        Left.Right = Right;
        Right.Left = Left;
    }

    public void ConcatenateRight(FHeapNode<T> otherList)
    {
        Right.Left = otherList.Left;
        otherList.Left.Right = Right;

        Right = otherList;
        otherList.Left = this;
    }
}
