using System;
using System.Collections.Generic;

namespace DataStructures.RedBlackTree;

public class RedBlackTree<TKey>
{
    
    public int Count { get; private set; }

    private readonly Comparer<TKey> comparer;

    private RedBlackTreeNode<TKey>? root;

    public RedBlackTree()
    {
        comparer = Comparer<TKey>.Default;
    }

    public RedBlackTree(Comparer<TKey> customComparer)
    {
        comparer = customComparer;
    }

    public void Add(TKey key)
    {
        if (root is null)
        {
            
            root = new RedBlackTreeNode<TKey>(key, null)
            {
                Color = NodeColor.Black,
            };
            Count++;
            return;
        }

        var node = Add(root, key);

        var childDir = comparer.Compare(node.Key, node.Parent!.Key);

        node = node.Parent;

        int addCase;
        do
        {
            addCase = GetAddCase(node);

            switch(addCase)
            {
                case 1:
                    break;
                case 2:
                    var oldParent = node.Parent;
                    node = AddCase2(node);

                    if (node is not null)
                    {
                        childDir = comparer.Compare(oldParent!.Key, oldParent.Parent!.Key);
                    }

                    break;
                case 4:
                    node.Color = NodeColor.Black;
                    break;
                case 56:
                    AddCase56(node, comparer.Compare(node.Key, node.Parent!.Key), childDir);
                    break;
                default:
                    throw new InvalidOperationException("It should not be possible to get here!");
            }
        }
        while (addCase == 2 && node is not null);

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
        
        var node = Remove(root, key);

        node = RemoveSimpleCases(node);

        if (node is null)
        {
            return;
        }

        DeleteLeaf(node.Parent!, comparer.Compare(node.Key, node.Parent!.Key));

        do
        {
            node = RemoveRecolor(node);
        }
        while (node is not null && node.Parent is not null);    

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
            throw new InvalidOperationException("Tree is empty!");
        }

        return GetMin(root).Key;
    }

    public TKey GetMax()
    {
        if (root is null)
        {
            throw new InvalidOperationException("Tree is empty!");
        }

        return GetMax(root).Key;
    }

    public IEnumerable<TKey> GetKeysInOrder()
    {
        var result = new List<TKey>();
        InOrderWalk(root);
        return result;

        void InOrderWalk(RedBlackTreeNode<TKey>? node)
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

        void PreOrderWalk(RedBlackTreeNode<TKey>? node)
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

        void PostOrderWalk(RedBlackTreeNode<TKey>? node)
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

    private RedBlackTreeNode<TKey> Add(RedBlackTreeNode<TKey> node, TKey key)
    {
        int compareResult;
        RedBlackTreeNode<TKey> newNode;
        while (true)
        {
            compareResult = comparer.Compare(key, node!.Key);
            if (compareResult < 0)
            {
                if (node.Left is null)
                {
                    newNode = new RedBlackTreeNode<TKey>(key, node);
                    node.Left = newNode;
                    break;
                }
                else
                {
                    node = node.Left;
                }
            }
            else if (compareResult > 0)
            {
                if (node.Right is null)
                {
                    newNode = new RedBlackTreeNode<TKey>(key, node);
                    node.Right = newNode;
                    break;
                }
                else
                {
                    node = node.Right;
                }
            }
            else
            {
                throw new ArgumentException($"Key \"{key}\" already exists in tree!");
            }
        }

        return newNode;
    }

    private RedBlackTreeNode<TKey>? AddCase2(RedBlackTreeNode<TKey> node)
    {
        var grandparent = node.Parent;
        var parentDir = comparer.Compare(node.Key, node.Parent!.Key);
        var uncle = parentDir < 0 ? grandparent!.Right : grandparent!.Left;

        node.Color = NodeColor.Black;
        uncle!.Color = NodeColor.Black;
        grandparent.Color = NodeColor.Red;

        if (node.Parent.Parent is null)
        {
            node.Parent.Color = NodeColor.Black;
        }

        return node.Parent.Parent;
    }

    private void AddCase56(RedBlackTreeNode<TKey> node, int parentDir, int childDir)
    {
        if (parentDir < 0)
        {
            
            if (childDir > 0)
            {
                node = RotateLeft(node);
            }

            node = RotateRight(node.Parent!);
            node.Color = NodeColor.Black;
            node.Right!.Color = NodeColor.Red;
        }
        else
        {
            
            if (childDir < 0)
            {
                node = RotateRight(node);
            }

            node = RotateLeft(node.Parent!);
            node.Color = NodeColor.Black;
            node.Left!.Color = NodeColor.Red;
        }
    }

    private int GetAddCase(RedBlackTreeNode<TKey> node)
    {
        if (node.Color == NodeColor.Black)
        {
            return 1;
        }
        else if (node.Parent is null)
        {
            return 4;
        }
        else
        {
            
            var grandparent = node.Parent;
            var parentDir = comparer.Compare(node.Key, node.Parent.Key);
            var uncle = parentDir < 0 ? grandparent.Right : grandparent.Left;

            if (uncle is null || uncle.Color == NodeColor.Black)
            {
                return 56;
            }

            return 2;
        }
    }

    private RedBlackTreeNode<TKey> Remove(RedBlackTreeNode<TKey>? node, TKey key)
    {
        if (node is null)
        {
            throw new InvalidOperationException("Tree is empty!");
        }
        else if (!Contains(key))
        {
            throw new KeyNotFoundException($"Key {key} is not in the tree!");
        }
        else
        {
            
            int dir;
            while (true)
            {
                dir = comparer.Compare(key, node!.Key);
                if (dir < 0)
                {
                    node = node.Left;
                }
                else if (dir > 0)
                {
                    node = node.Right;
                }
                else
                {
                    break;
                }
            }

            return node;
        }
    }

    private RedBlackTreeNode<TKey>? RemoveRecolor(RedBlackTreeNode<TKey> node)
    {
        var removeCase = GetRemoveCase(node);

        var dir = comparer.Compare(node.Key, node.Parent!.Key);

        var sibling = dir < 0 ? node.Parent.Right : node.Parent.Left;
        var closeNewphew = dir < 0 ? sibling!.Left : sibling!.Right;
        var distantNephew = dir < 0 ? sibling!.Right : sibling!.Left;

        switch (removeCase)
        {
            case 1:
                sibling.Color = NodeColor.Red;
                return node.Parent;
            case 3:
                RemoveCase3(node, closeNewphew, dir);
                break;
            case 4:
                RemoveCase4(sibling);
                break;
            case 5:
                RemoveCase5(node, sibling, dir);
                break;
            case 6:
                RemoveCase6(node, distantNephew!, dir);
                break;
            default:
                throw new InvalidOperationException("It should not be possible to get here!");
        }

        return null;
    }

    private RedBlackTreeNode<TKey>? RemoveSimpleCases(RedBlackTreeNode<TKey> node)
    {
        
        if (node.Parent is null && node.Left is null && node.Right is null)
        {
            root = null;
            Count--;
            return null;
        }

        if (node.Left is not null && node.Right is not null)
        {
            var successor = GetMin(node.Right);
            node.Key = successor.Key;
            node = successor;
        }

        if (node.Color == NodeColor.Red)
        {
            
            DeleteLeaf(node.Parent!, comparer.Compare(node.Key, node.Parent!.Key));

            Count--;
            return null;
        }
        else
        {
            
            return RemoveBlackNode(node);
        }
    }

    private RedBlackTreeNode<TKey>? RemoveBlackNode(RedBlackTreeNode<TKey> node)
    {
        
        var child = node.Left ?? node.Right;

        if (child is null)
        {
            return node;
        }

        child.Color = NodeColor.Black;
        child.Parent = node.Parent;

        var childDir = node.Parent is null ? 0 : comparer.Compare(node.Key, node.Parent.Key);

        Transplant(node.Parent, child, childDir);

        Count--;
        return null;
    }

    private void RemoveCase3(RedBlackTreeNode<TKey> node, RedBlackTreeNode<TKey>? closeNephew, int childDir)
    {
        
        var sibling = childDir < 0 ? RotateLeft(node.Parent!) : RotateRight(node.Parent!);
        sibling.Color = NodeColor.Black;
        if (childDir < 0)
        {
            sibling.Left!.Color = NodeColor.Red;
        }
        else
        {
            sibling.Right!.Color = NodeColor.Red;
        }

        sibling = closeNephew!;
        var distantNephew = childDir < 0 ? sibling.Right : sibling.Left;

        if (distantNephew is not null && distantNephew.Color == NodeColor.Red)
        {
            RemoveCase6(node, distantNephew, childDir);
            return;
        }

        closeNephew = childDir < 0 ? sibling!.Left : sibling!.Right;

        if (closeNephew is not null && closeNephew.Color == NodeColor.Red)
        {
            RemoveCase5(node, sibling!, childDir);
            return;
        }

        RemoveCase4(sibling!);
    }

    private void RemoveCase4(RedBlackTreeNode<TKey> sibling)
    {
        sibling.Color = NodeColor.Red;
        sibling.Parent!.Color = NodeColor.Black;
    }

    private void RemoveCase5(RedBlackTreeNode<TKey> node, RedBlackTreeNode<TKey> sibling, int childDir)
    {
        sibling = childDir < 0 ? RotateRight(sibling) : RotateLeft(sibling);
        var distantNephew = childDir < 0 ? sibling.Right! : sibling.Left!;

        sibling.Color = NodeColor.Black;
        distantNephew.Color = NodeColor.Red;

        RemoveCase6(node, distantNephew, childDir);
    }

    private void RemoveCase6(RedBlackTreeNode<TKey> node, RedBlackTreeNode<TKey> distantNephew, int childDir)
    {
        var oldParent = node.Parent!;
        node = childDir < 0 ? RotateLeft(oldParent) : RotateRight(oldParent);
        node.Color = oldParent.Color;
        oldParent.Color = NodeColor.Black;
        distantNephew.Color = NodeColor.Black;
    }

    private int GetRemoveCase(RedBlackTreeNode<TKey> node)
    {
        var dir = comparer.Compare(node.Key, node.Parent!.Key);

        var sibling = dir < 0 ? node.Parent.Right : node.Parent.Left;
        var closeNewphew = dir < 0 ? sibling!.Left : sibling!.Right;
        var distantNephew = dir < 0 ? sibling!.Right : sibling!.Left;

        if (sibling.Color == NodeColor.Red)
        {
            return 3;
        }
        else if (distantNephew is not null && distantNephew.Color == NodeColor.Red)
        {
            return 6;
        }
        else if (closeNewphew is not null && closeNewphew.Color == NodeColor.Red)
        {
            return 5;
        }
        else if (node.Parent.Color == NodeColor.Red)
        {
            return 4;
        }
        else
        {
            return 1;
        }
    }

    private void Transplant(RedBlackTreeNode<TKey>? node, RedBlackTreeNode<TKey>? child, int dir)
    {
        if (node is null)
        {
            root = child;
        }
        else if (child is null)
        {
            DeleteLeaf(node, dir);
        }
        else if (dir < 0)
        {
            node.Left = child;
        }
        else
        {
            node.Right = child;
        }
    }

    private void DeleteLeaf(RedBlackTreeNode<TKey> node, int dir)
    {
        if (dir < 0)
        {
            node.Left = null;
        }
        else
        {
            node.Right = null;
        }
    }

    private RedBlackTreeNode<TKey> RotateLeft(RedBlackTreeNode<TKey> node)
    {
        var temp1 = node;
        var temp2 = node!.Right!.Left;

        node = node.Right;
        node.Parent = temp1.Parent;
        if (node.Parent is not null)
        {
            var nodeDir = comparer.Compare(node.Key, node.Parent.Key);
            if (nodeDir < 0)
            {
                node.Parent.Left = node;
            }
            else
            {
                node.Parent.Right = node;
            }
        }

        node.Left = temp1;
        node.Left.Parent = node;

        node.Left.Right = temp2;
        if (temp2 is not null)
        {
            node.Left.Right!.Parent = temp1;
        }

        if (node.Parent is null)
        {
            root = node;
        }

        return node;
    }

    private RedBlackTreeNode<TKey> RotateRight(RedBlackTreeNode<TKey> node)
    {
        var temp1 = node;
        var temp2 = node!.Left!.Right;

        node = node.Left;
        node.Parent = temp1.Parent;
        if (node.Parent is not null)
        {
            var nodeDir = comparer.Compare(node.Key, node.Parent.Key);
            if (nodeDir < 0)
            {
                node.Parent.Left = node;
            }
            else
            {
                node.Parent.Right = node;
            }
        }

        node.Right = temp1;
        node.Right.Parent = node;

        node.Right.Left = temp2;
        if (temp2 is not null)
        {
            node.Right.Left!.Parent = temp1;
        }

        if (node.Parent is null)
        {
            root = node;
        }

        return node;
    }

    private RedBlackTreeNode<TKey> GetMin(RedBlackTreeNode<TKey> node)
    {
        while (node.Left is not null)
        {
            node = node.Left;
        }

        return node;
    }

    private RedBlackTreeNode<TKey> GetMax(RedBlackTreeNode<TKey> node)
    {
        while (node.Right is not null)
        {
            node = node.Right;
        }

        return node;
    }
}
