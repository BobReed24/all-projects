using DataStructures.Stack;
using NUnit.Framework;
using System;
using System.Text;

namespace DataStructures.Tests.Stack;

public static class QueueBasedStackTests
{
    [Test]
    public static void PopWorksCorrectly()
    {
        
        QueueBasedStack<char> s = new QueueBasedStack<char>();
        s.Push('A');
        s.Push('B');
        s.Push('C');
        var result = new StringBuilder();

        for (int i = 0; i < 3; i++)
        {
            result.Append(s.Pop());
        }

        Assert.That("CBA", Is.EqualTo(result.ToString()));
        Assert.That(s.IsEmpty(), Is.True, "Stack is Empty");
    }
    [Test]
    public static void PeekWorksCorrectly()
    {
        
        QueueBasedStack<int> s = new QueueBasedStack<int>();
        s.Push(1);
        s.Push(2);
        s.Push(3);
        var peeked = 0;

        for (int i = 0; i < 3; i++)
        {
            peeked = s.Peek();
        }

        Assert.That(3, Is.EqualTo(peeked));
        Assert.That(s.IsEmpty(), Is.False, "Stack is Empty");
    }
    [Test]
    public static void PopEmptyStackThrowsInvalidOperationException()
    {
        
        var s = new QueueBasedStack<int>();
        Exception? exception = null;

        try
        {
            s.Pop();
        }
        catch (Exception ex)
        {
            exception = ex;
        }

        Assert.That(exception?.GetType(), Is.EqualTo(typeof(InvalidOperationException)));
    }
    [Test]
    public static void PeekEmptyStackThrowsInvalidOperationException()
    {
        
        var s = new QueueBasedStack<int>();
        Exception? exception = null;

        try
        {
            s.Peek();
        }
        catch (Exception ex)
        {
            exception = ex;
        }

        Assert.That(exception?.GetType(), Is.EqualTo(typeof(InvalidOperationException)));
    }
    [Test]
    public static void ClearWorksCorrectly()
    {
        
        var s = new QueueBasedStack<int>();
        s.Push(1);
        s.Push(2);

        s.Clear();

        Assert.That(s.IsEmpty(), Is.True, "Queue is empty");

    }
    [Test]
    public static void LengthWorksCorrectly()
    {
        
        var s = new QueueBasedStack<int>();
        s.Push(1);
        s.Push(2);
        var length = 0;

        length = s.Length();

        Assert.That(2, Is.EqualTo(length));

    }
}
