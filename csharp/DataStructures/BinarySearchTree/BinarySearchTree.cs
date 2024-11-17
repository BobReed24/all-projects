using System;
using System.Collections.Generic;

namespace DataStructures.BinarySearchTree;

public class BinarySearchTree<TKey>
{
    
    private readonly Comparer<TKey> comparer;

    public BinarySearchTreeNode<TKey>? Root { get; private set; }

    public BinarySearchTree()
    {
        Root = null;
        Count = 0;
        comparer = Comparer<TKey>.Default;
    }

    public BinarySearchTree(Comparer<TKey> customComparer)
    {
        Root = null;
        Count = 0;
        comparer = customComparer;
    }

    public int Count { get; private set; }

    public void Add(TKey key)
    {
        if (Root is null)
        {
            Root = new BinarySearchTreeNode<TKey>(key);
        }
        else
        {
            Add(Root, key);
        }

        Count++;
    }

    public void AddRange(IEnumerable<TKey> keys)
    {
        foreach (var key in keys)
        {
            Add(key);
        }
    }

    public BinarySearchTreeNode<TKey>? Search(TKey key) => Search(Root, key);

    public bool Contains(TKey key) => Search(Root, key) is not null;

    public bool Remove(TKey key)
    {
        if (Root is null)
        {
            return false;
        }

        var result = Remove(Root, Root, key);
        if (result)
        {
            Count--;
        }

        return result;
    }

    public BinarySearchTreeNode<TKey>? GetMin()
    {
        if (Root is null)
        {
            return default;
        }

        return GetMin(Root);
    }

    public BinarySearchTreeNode<TKey>? GetMax()
    {
        if (Root is null)
        {
            return default;
        }

        return GetMax(Root);
    }

    public ICollection<TKey> GetKeysInOrder() => GetKeysInOrder(Root);

    public ICollection<TKey> GetKeysPreOrder() => GetKeysPreOrder(Root);

    public ICollection<TKey> GetKeysPostOrder() => GetKeysPostOrder(Root);

    private void Add(BinarySearchTreeNode<TKey> node, TKey key)
    {
        var compareResult = comparer.Compare(node.Key, key);
        if (compareResult > 0)
        {
            if (node.Left is not null)
            {
                Add(node.Left, key);
            }
            else
            {
                var newNode = new BinarySearchTreeNode<TKey>(key);
                node.Left = newNode;
            }
        }
        else if (compareResult < 0)
        {
            if (node.Right is not null)
            {
                Add(node.Right, key);
            }
            else
            {
                var newNode = new BinarySearchTreeNode<TKey>(key);
                node.Right = newNode;
            }
        }

        else
        {
            throw new ArgumentException($"Key \"{key}\" already exists in tree!");
        }
    }

    private bool Remove(BinarySearchTreeNode<TKey>? parent, BinarySearchTreeNode<TKey>? node, TKey key)
    {
        if (node is null || parent is null)
        {
            return false;
        }

        var compareResult = comparer.Compare(node.Key, key);

        if (compareResult > 0)
        {
            return Remove(node, node.Left, key);
        }

        if (compareResult < 0)
        {
            return Remove(node, node.Right, key);
        }

        BinarySearchTreeNode<TKey>? replacementNode;

        if (node.Left is null || node.Right is null)
        {
            replacementNode = node.Left ?? node.Right;
        }

        else
        {
            var predecessorNode = GetMax(node.Left);
            Remove(Root, Root, predecessorNode.Key);
            replacementNode = new BinarySearchTreeNode<TKey>(predecessorNode.Key)
            {
                Left = node.Left,
                Right = node.Right,
            };
        }

        if (node == Root)
        {
            Root = replacementNode;
        }
        else if (parent.Left == node)
        {
            parent.Left = replacementNode;
        }
        else
        {
            parent.Right = replacementNode;
        }

        return true;
    }

    private BinarySearchTreeNode<TKey> GetMax(BinarySearchTreeNode<TKey> node)
    {
        if (node.Right is null)
        {
            return node;
        }

        return GetMax(node.Right);
    }

    private BinarySearchTreeNode<TKey> GetMin(BinarySearchTreeNode<TKey> node)
    {
        if (node.Left is null)
        {
            return node;
        }

        return GetMin(node.Left);
    }

    private IList<TKey> GetKeysInOrder(BinarySearchTreeNode<TKey>? node)
    {
        if (node is null)
        {
            return new List<TKey>();
        }

        var result = new List<TKey>();
        result.AddRange(GetKeysInOrder(node.Left));
        result.Add(node.Key);
        result.AddRange(GetKeysInOrder(node.Right));
        return result;
    }

    private IList<TKey> GetKeysPreOrder(BinarySearchTreeNode<TKey>? node)
    {
        if (node is null)
        {
            return new List<TKey>();
        }

        var result = new List<TKey>();
        result.Add(node.Key);
        result.AddRange(GetKeysPreOrder(node.Left));
        result.AddRange(GetKeysPreOrder(node.Right));
        return result;
    }

    private IList<TKey> GetKeysPostOrder(BinarySearchTreeNode<TKey>? node)
    {
        if (node is null)
        {
            return new List<TKey>();
        }

        var result = new List<TKey>();
        result.AddRange(GetKeysPostOrder(node.Left));
        result.AddRange(GetKeysPostOrder(node.Right));
        result.Add(node.Key);
        return result;
    }

    private BinarySearchTreeNode<TKey>? Search(BinarySearchTreeNode<TKey>? node, TKey key)
    {
        if (node is null)
        {
            return default;
        }

        var compareResult = comparer.Compare(node.Key, key);
        if (compareResult > 0)
        {
            return Search(node.Left, key);
        }

        if (compareResult < 0)
        {
            return Search(node.Right, key);
        }

        return node;
    }
}
