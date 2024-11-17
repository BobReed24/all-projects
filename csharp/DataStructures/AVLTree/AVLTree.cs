using System;
using System.Collections.Generic;

namespace DataStructures.AVLTree;

public class AvlTree<TKey>
{
    
    public int Count { get; private set; }

    private readonly Comparer<TKey> comparer;

    private AvlTreeNode<TKey>? root;

    public AvlTree()
    {
        comparer = Comparer<TKey>.Default;
    }

    public AvlTree(Comparer<TKey> customComparer)
    {
        comparer = customComparer;
    }

    public void Add(TKey key)
    {
        if (root is null)
        {
            root = new AvlTreeNode<TKey>(key);
        }
        else
        {
            root = Add(root, key);
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

    public void Remove(TKey key)
    {
        root = Remove(root, key);
        Count--;
    }

    public bool Contains(TKey key)
    {
        var node = root;
        while (node is not null)
        {
            var compareResult = comparer.Compare(key, node.Key);
            if (compareResult < 0)
            {
                node = node.Left;
            }
            else if (compareResult > 0)
            {
                node = node.Right;
            }
            else
            {
                return true;
            }
        }

        return false;
    }

    public TKey GetMin()
    {
        if (root is null)
        {
            throw new InvalidOperationException("AVL tree is empty.");
        }

        return GetMin(root).Key;
    }

    public TKey GetMax()
    {
        if (root is null)
        {
            throw new InvalidOperationException("AVL tree is empty.");
        }

        return GetMax(root).Key;
    }

    public IEnumerable<TKey> GetKeysInOrder()
    {
        List<TKey> result = new();
        InOrderWalk(root);
        return result;

        void InOrderWalk(AvlTreeNode<TKey>? node)
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
        PreOrderWalk(root);
        return result;

        void PreOrderWalk(AvlTreeNode<TKey>? node)
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
        PostOrderWalk(root);
        return result;

        void PostOrderWalk(AvlTreeNode<TKey>? node)
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

    private static AvlTreeNode<TKey> Rebalance(AvlTreeNode<TKey> node)
    {
        if (node.BalanceFactor > 1)
        {
            if (node.Right!.BalanceFactor == -1)
            {
                node.Right = RotateRight(node.Right);
            }

            return RotateLeft(node);
        }

        if (node.BalanceFactor < -1)
        {
            if (node.Left!.BalanceFactor == 1)
            {
                node.Left = RotateLeft(node.Left);
            }

            return RotateRight(node);
        }

        return node;
    }

    private static AvlTreeNode<TKey> RotateLeft(AvlTreeNode<TKey> node)
    {
        var temp1 = node;
        var temp2 = node.Right!.Left;
        node = node.Right;
        node.Left = temp1;
        node.Left.Right = temp2;

        node.Left.UpdateBalanceFactor();
        node.UpdateBalanceFactor();

        return node;
    }

    private static AvlTreeNode<TKey> RotateRight(AvlTreeNode<TKey> node)
    {
        var temp1 = node;
        var temp2 = node.Left!.Right;
        node = node.Left;
        node.Right = temp1;
        node.Right.Left = temp2;

        node.Right.UpdateBalanceFactor();
        node.UpdateBalanceFactor();

        return node;
    }

    private static AvlTreeNode<TKey> GetMin(AvlTreeNode<TKey> node)
    {
        while (node.Left is not null)
        {
            node = node.Left;
        }

        return node;
    }

    private static AvlTreeNode<TKey> GetMax(AvlTreeNode<TKey> node)
    {
        while (node.Right is not null)
        {
            node = node.Right;
        }

        return node;
    }

    private AvlTreeNode<TKey> Add(AvlTreeNode<TKey> node, TKey key)
    {
        
        var compareResult = comparer.Compare(key, node.Key);
        if (compareResult < 0)
        {
            if (node.Left is null)
            {
                var newNode = new AvlTreeNode<TKey>(key);
                node.Left = newNode;
            }
            else
            {
                node.Left = Add(node.Left, key);
            }
        }
        else if (compareResult > 0)
        {
            if (node.Right is null)
            {
                var newNode = new AvlTreeNode<TKey>(key);
                node.Right = newNode;
            }
            else
            {
                node.Right = Add(node.Right, key);
            }
        }
        else
        {
            throw new ArgumentException(
                $"Key \"{key}\" already exists in AVL tree.");
        }

        node.UpdateBalanceFactor();

        return Rebalance(node);
    }

    private AvlTreeNode<TKey>? Remove(AvlTreeNode<TKey>? node, TKey key)
    {
        if (node == null)
        {
            throw new KeyNotFoundException(
                $"Key \"{key}\" is not in the AVL tree.");
        }

        var compareResult = comparer.Compare(key, node.Key);
        if (compareResult < 0)
        {
            node.Left = Remove(node.Left, key);
        }
        else if (compareResult > 0)
        {
            node.Right = Remove(node.Right, key);
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
                node.Right = Remove(node.Right!, successor.Key);
                node.Key = successor.Key;
            }
            else
            {
                var predecessor = GetMax(node.Left!);
                node.Left = Remove(node.Left!, predecessor.Key);
                node.Key = predecessor.Key;
            }
        }

        node.UpdateBalanceFactor();

        return Rebalance(node);
    }
}
