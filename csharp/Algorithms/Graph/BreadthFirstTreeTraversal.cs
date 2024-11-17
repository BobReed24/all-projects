using System;
using System.Collections.Generic;
using DataStructures.BinarySearchTree;

namespace Algorithms.Graph;

public static class BreadthFirstTreeTraversal<TKey>
{
    
    public static TKey[] LevelOrderTraversal(BinarySearchTree<TKey> tree)
    {
        BinarySearchTreeNode<TKey>? root = tree.Root;
        TKey[] levelOrder = new TKey[tree.Count];
        if (root is null)
        {
            return Array.Empty<TKey>();
        }

        Queue<BinarySearchTreeNode<TKey>> breadthTraversal = new Queue<BinarySearchTreeNode<TKey>>();
        breadthTraversal.Enqueue(root);
        for (int i = 0; i < levelOrder.Length; i++)
        {
            BinarySearchTreeNode<TKey> current = breadthTraversal.Dequeue();
            levelOrder[i] = current.Key;
            if (current.Left is not null)
            {
                breadthTraversal.Enqueue(current.Left);
            }

            if (current.Right is not null)
            {
                breadthTraversal.Enqueue(current.Right);
            }
        }

        return levelOrder;
    }

    public static TKey? DeepestNode(BinarySearchTree<TKey> tree)
    {
        BinarySearchTreeNode<TKey>? root = tree.Root;
        if (root is null)
        {
            return default(TKey);
        }

        Queue<BinarySearchTreeNode<TKey>> breadthTraversal = new Queue<BinarySearchTreeNode<TKey>>();
        breadthTraversal.Enqueue(root);
        TKey deepest = root.Key;
        while (breadthTraversal.Count > 0)
        {
            BinarySearchTreeNode<TKey> current = breadthTraversal.Dequeue();
            if (current.Left is not null)
            {
                breadthTraversal.Enqueue(current.Left);
            }

            if (current.Right is not null)
            {
                breadthTraversal.Enqueue(current.Right);
            }

            deepest = current.Key;
        }

        return deepest;
    }
}
