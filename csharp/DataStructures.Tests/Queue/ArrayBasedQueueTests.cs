using System;
using System.Text;
using DataStructures.Queue;
using NUnit.Framework;

namespace DataStructures.Tests.Queue;

public static class ArrayBasedQueueTests
{
    [Test]
    public static void DequeueWorksCorrectly()
    {
        
        var q = new ArrayBasedQueue<char>(3);
        q.Enqueue('A');
        q.Enqueue('B');
        q.Enqueue('C');
        var result = new StringBuilder();

        for (var i = 0; i < 3; i++)
        {
            result.Append(q.Dequeue());
        }

        Assert.That("ABC", Is.EqualTo(result.ToString()));
        Assert.That(q.IsEmpty(), Is.True, "Queue is empty");
        Assert.That(q.IsFull(), Is.False, "Queue is full");
    }

    [Test]
    public static void PeekWorksCorrectly()
    {
        
        var q = new ArrayBasedQueue<int>(2);
        q.Enqueue(1);
        q.Enqueue(2);
        var peeked = 0;

        for (var i = 0; i < 3; i++)
        {
            peeked = q.Peek();
        }

        Assert.That(1, Is.EqualTo(peeked));
        Assert.That(q.IsEmpty(), Is.False, "Queue is empty");
        Assert.That(q.IsFull(), Is.True, "Queue is full");
    }

    [Test]
    public static void DequeueEmptyQueueThrowsInvalidOperationException()
    {
        
        var q = new ArrayBasedQueue<int>(1);
        Exception? exception = null;

        try
        {
            q.Dequeue();
        }
        catch (Exception ex)
        {
            exception = ex;
        }

        Assert.That(typeof(InvalidOperationException), Is.EqualTo(exception?.GetType()));
    }

    [Test]
    public static void EnqueueFullQueueThrowsInvalidOperationException()
    {
        
        var q = new ArrayBasedQueue<int>(1);
        q.Enqueue(0);
        Exception? exception = null;

        try
        {
            q.Enqueue(1);
        }
        catch (Exception ex)
        {
            exception = ex;
        }

        Assert.That(typeof(InvalidOperationException), Is.EqualTo(exception?.GetType()));
    }

    [Test]
    public static void PeekEmptyQueueThrowsInvalidOperationException()
    {
        
        var q = new ArrayBasedQueue<int>(1);
        Exception? exception = null;

        try
        {
            q.Peek();
        }
        catch (Exception ex)
        {
            exception = ex;
        }

        Assert.That(typeof(InvalidOperationException), Is.EqualTo(exception?.GetType()));
    }

    [Test]
    public static void ClearWorksCorrectly()
    {
        
        var q = new ArrayBasedQueue<int>(2);
        q.Enqueue(1);
        q.Enqueue(2);

        q.Clear();

        Assert.That(q.IsEmpty(), Is.True, "Queue is empty");
        Assert.That(q.IsFull(), Is.False, "Queue is full");
    }
}
