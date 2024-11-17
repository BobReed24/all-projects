using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;

namespace DataStructures.LinkedList.SkipList;

[DebuggerDisplay("Count = {Count}")]
public class SkipList<TValue>
{
    private const double Probability = 0.5;
    private readonly int maxLevels;
    private readonly SkipListNode<TValue> head;
    private readonly SkipListNode<TValue> tail;
    private readonly Random random = new Random();

    public SkipList(int capacity = 255)
    {
        maxLevels = (int)Math.Log2(capacity) + 1;

        head = new(int.MinValue, default(TValue), maxLevels);
        tail = new(int.MaxValue, default(TValue), maxLevels);

        for(int i = 0; i < maxLevels; i++)
        {
            head.Next[i] = tail;
        }
    }

    public int Count { get; private set; }

    public TValue this[int key]
    {
        get
        {
            var previousNode = GetSkipNodes(key).First();
            if(previousNode.Next[0].Key == key)
            {
                return previousNode.Next[0].Value!;
            }
            else
            {
                throw new KeyNotFoundException();
            }
        }

        set => AddOrUpdate(key, value);
    }

    public void AddOrUpdate(int key, TValue value)
    {
        var skipNodes = GetSkipNodes(key);

        var previousNode = skipNodes.First();
        if (previousNode.Next[0].Key == key)
        {
            
            previousNode.Next[0].Value = value;
            return;
        }

        var newNode = new SkipListNode<TValue>(key, value, GetRandomHeight());
        for (var level = 0; level < newNode.Height; level++)
        {
            newNode.Next[level] = skipNodes[level].Next[level];
            skipNodes[level].Next[level] = newNode;
        }

        Count++;
    }

    public bool Contains(int key)
    {
        var previousNode = GetSkipNodes(key).First();
        return previousNode.Next[0].Key == key;
    }

    public bool Remove(int key)
    {
        var skipNodes = GetSkipNodes(key);
        var previousNode = skipNodes.First();
        if (previousNode.Next[0].Key != key)
        {
            return false;
        }

        var nodeToRemove = previousNode.Next[0];
        for (var level = 0; level < nodeToRemove.Height; level++)
        {
            skipNodes[level].Next[level] = nodeToRemove.Next[level];
        }

        Count--;

        return true;
    }

    public IEnumerable<TValue> GetValues()
    {
        var current = head.Next[0];
        while (current.Key != tail.Key)
        {
            yield return current.Value!;
            current = current.Next[0];
        }
    }

    private SkipListNode<TValue>[] GetSkipNodes(int key)
    {
        var skipNodes = new SkipListNode<TValue>[maxLevels];
        var current = head;
        for (var level = head.Height - 1; level >= 0; level--)
        {
            while (current.Next[level].Key < key)
            {
                current = current.Next[level];
            }

            skipNodes[level] = current;
        }

        return skipNodes;
    }

    private int GetRandomHeight()
    {
        int height = 1;
        while (random.NextDouble() < Probability && height < maxLevels)
        {
            height++;
        }

        return height;
    }
}
