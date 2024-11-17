using System;
using System.Collections.Generic;

namespace DataStructures.Tries;

internal class TrieNode
{
    
    internal TrieNode(char value)
        : this(value, null)
    {
    }

    internal TrieNode(char value, TrieNode? parent)
    {
        Children = new SortedList<char, TrieNode>();
        Parent = parent;
        Value = value;
    }

    internal SortedList<char, TrieNode> Children { get; private set; }

    internal TrieNode? Parent { get; private set; }

    internal char Value { get; private set; }

    public TrieNode? this[char c]
    {
        get => Children.ContainsKey(c) ? Children[c] : null;
        set => Children[c] = value ?? throw new NullReferenceException();
    }

    public bool IsLeaf()
    {
        return Children.Count == 0;
    }
}
