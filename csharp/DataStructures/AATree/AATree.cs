using System;
using System.Collections.Generic;

namespace DataStructures.AATree;

public class AaTree<TKey>
{
    
    private readonly Comparer<TKey> comparer;

    public AaTree()
        : this(Comparer<TKey>.Default)
    {
    }

    public AaTree(Comparer<TKey> customComparer) => comparer = customComparer;

    public AaTreeNode<TKey>? Root { get; private set; }

    public int Count { get; private set; }

    public void Add(TKey key)
    {
        Root = Add(key, Root);
        Count++;
    }

    public void AddRange(IEnumerable<TKey> keys)
    {
        foreach (var key in keys)
        {
            Root = Add(key, Root);
            Count++;
        }
    }

    public void Remove(TKey key)
    {
        if (!Contains(key, Root))
        {
            throw new InvalidOperationException($"{nameof(key)} is not in the tree");
        }

        Root = Remove(key, Root);
        Count--;
    }

    public bool Contains(TKey key) => Contains(key, Root);

    public TKey GetMax()
    {
        if (Root is null)
        {
            throw new InvalidOperationException("Tree is empty!");
        }

        return GetMax(Root).Key;
    }

    public TKey GetMin()
    {
        if (Root is null)
        {
            throw new InvalidOperationException("Tree is empty!");
        }

        return GetMin(Root).Key;
    }

    public IEnumerable<TKey> GetKeysInOrder()
    {
        var result = new List<TKey>();
        InOrderWalk(Root);
        return result;

        void InOrderWalk(AaTreeNode<TKey>? node)
        {
            if (node is null)
            {
                return;
            }

            InOrderWalk(node.Left);
            result.Add(node.Key);
            InOrderWalk(node.Right);
        }
    }

    public IEnumerable<TKey> GetKeysPreOrder()
    {
        var result = new List<TKey>();
        PreOrderWalk(Root);
        return result;

        void PreOrderWalk(AaTreeNode<TKey>? node)
        {
            if (node is null)
            {
                return;
            }

            result.Add(node.Key);
            PreOrderWalk(node.Left);
            PreOrderWalk(node.Right);
        }
    }

    public IEnumerable<TKey> GetKeysPostOrder()
    {
        var result = new List<TKey>();
        PostOrderWalk(Root);
        return result;

        void PostOrderWalk(AaTreeNode<TKey>? node)
        {
            if (node is null)
            {
                return;
            }

            PostOrderWalk(node.Left);
            PostOrderWalk(node.Right);
            result.Add(node.Key);
        }
    }

    private AaTreeNode<TKey> Add(TKey key, AaTreeNode<TKey>? node)
    {
        if (node is null)
        {
            return new AaTreeNode<TKey>(key, 1);
        }

        if (comparer.Compare(key, node.Key) < 0)
        {
            node.Left = Add(key, node.Left);
        }
        else if (comparer.Compare(key, node.Key) > 0)
        {
            node.Right = Add(key, node.Right);
        }
        else
        {
            throw new ArgumentException($"Key \"{key}\" already in tree!", nameof(key));
        }

        return Split(Skew(node))!;
    }

    private AaTreeNode<TKey>? Remove(TKey key, AaTreeNode<TKey>? node)
    {
        if (node is null)
        {
            return null;
        }

        if (comparer.Compare(key, node.Key) < 0)
        {
            node.Left = Remove(key, node.Left);
        }
        else if (comparer.Compare(key, node.Key) > 0)
        {
            node.Right = Remove(key, node.Right);
        }
        else
        {
            if (node.Left is null && node.Right is null)
            {
                return null;
            }

            if (node.Left is null)
            {
                var successor = GetMin(node.Right!);
                node.Right = Remove(successor.Key, node.Right);
                node.Key = successor.Key;
            }
            else
            {
                var predecessor = GetMax(node.Left);
                node.Left = Remove(predecessor.Key, node.Left);
                node.Key = predecessor.Key;
            }
        }

        node = DecreaseLevel(node);
        node = Skew(node);
        node!.Right = Skew(node.Right);

        if (node.Right is not null)
        {
            node.Right.Right = Skew(node.Right.Right);
        }

        node = Split(node);
        node!.Right = Split(node.Right);
        return node;
    }

    private bool Contains(TKey key, AaTreeNode<TKey>? node) =>
        node is { }
        && comparer.Compare(key, node.Key) is { } v
        && v switch
        {
            { } when v > 0 => Contains(key, node.Right),
            { } when v < 0 => Contains(key, node.Left),
            _ => true,
        };

    private AaTreeNode<TKey> GetMax(AaTreeNode<TKey> node)
    {
        while (true)
        {
            if (node.Right is null)
            {
                return node;
            }

            node = node.Right;
        }
    }

    private AaTreeNode<TKey> GetMin(AaTreeNode<TKey> node)
    {
        while (true)
        {
            if (node.Left is null)
            {
                return node;
            }

            node = node.Left;
        }
    }

    private AaTreeNode<TKey>? Skew(AaTreeNode<TKey>? node)
    {
        if (node?.Left is null || node.Left.Level != node.Level)
        {
            return node;
        }

        var left = node.Left;
        node.Left = left.Right;
        left.Right = node;
        return left;
    }

    private AaTreeNode<TKey>? Split(AaTreeNode<TKey>? node)
    {
        if (node?.Right?.Right is null || node.Level != node.Right.Right.Level)
        {
            return node;
        }

        var right = node.Right;
        node.Right = right.Left;
        right.Left = node;
        right.Level++;
        return right;
    }

    private AaTreeNode<TKey> DecreaseLevel(AaTreeNode<TKey> node)
    {
        var newLevel = Math.Min(GetLevel(node.Left), GetLevel(node.Right)) + 1;
        if (newLevel >= node.Level)
        {
            return node;
        }

        node.Level = newLevel;
        if (node.Right is { } && newLevel < node.Right.Level)
        {
            node.Right.Level = newLevel;
        }

        return node;

        static int GetLevel(AaTreeNode<TKey>? x) => x?.Level ?? 0;
    }
}
