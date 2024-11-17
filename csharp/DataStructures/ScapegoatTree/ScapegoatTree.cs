using System;
using System.Collections.Generic;

namespace DataStructures.ScapegoatTree;

public class ScapegoatTree<TKey> where TKey : IComparable
{
    
    public double Alpha { get; private set; }

    public Node<TKey>? Root { get; private set; }

    public int Size { get; private set; }

    public int MaxSize { get; private set; }

    public event EventHandler? TreeIsUnbalanced;

    public ScapegoatTree()
        : this(alpha: 0.5, size: 0)
    {
    }

    public ScapegoatTree(double alpha)
        : this(alpha, size: 0)
    {
    }

    public ScapegoatTree(Node<TKey> node, double alpha)
        : this(alpha, size: node.GetSize())
    {
        Root = node;
    }

    public ScapegoatTree(TKey key, double alpha = 0.5)
        : this(alpha, size: 1)
    {
        Root = new Node<TKey>(key);
    }

    private ScapegoatTree(double alpha, int size)
    {
        CheckAlpha(alpha);

        Alpha = alpha;

        Size = size;
        MaxSize = size;
    }

    public bool IsAlphaWeightBalanced()
    {
        return Root?.IsAlphaWeightBalanced(Alpha) ?? true;
    }

    public bool Contains(TKey key)
    {
        return Search(key) != null;
    }

    public Node<TKey>? Search(TKey key)
    {
        if (Root == null)
        {
            return null;
        }

        var current = Root;

        while (true)
        {
            var result = current.Key.CompareTo(key);

            switch (result)
            {
                case 0:
                    return current;
                case > 0 when current.Left != null:
                    current = current.Left;
                    break;
                case < 0 when current.Right != null:
                    current = current.Right;
                    break;
                default:
                    return null;
            }
        }
    }

    public bool Insert(TKey key)
    {
        var node = new Node<TKey>(key);

        if (Root == null)
        {
            Root = node;

            UpdateSizes();

            return true;
        }

        var path = new Stack<Node<TKey>>();

        var current = Root;

        var found = false;

        while (!found)
        {
            path.Push(current);

            var result = current.Key.CompareTo(node.Key);

            switch (result)
            {
                case < 0 when current.Right != null:
                    current = current.Right;
                    continue;
                case < 0:
                    current.Right = node;
                    found = true;
                    break;
                case > 0 when current.Left != null:
                    current = current.Left;
                    continue;
                case > 0:
                    current.Left = node;
                    found = true;
                    break;
                default:
                    return false;
            }
        }

        UpdateSizes();

        if (path.Count > Root.GetAlphaHeight(Alpha))
        {
            TreeIsUnbalanced?.Invoke(this, EventArgs.Empty);

            BalanceFromPath(path);

            MaxSize = Math.Max(MaxSize, Size);
        }

        return true;
    }

    public bool Delete(TKey key)
    {
        if (Root == null)
        {
            return false;
        }

        if (Remove(Root, Root, key))
        {
            Size--;

            if (Root != null && Size < Alpha * MaxSize)
            {
                TreeIsUnbalanced?.Invoke(this, EventArgs.Empty);

                var list = new List<Node<TKey>>();

                Extensions.FlattenTree(Root, list);

                Root = Extensions.RebuildFromList(list, 0, list.Count - 1);

                MaxSize = Size;
            }

            return true;
        }

        return false;
    }

    public void Clear()
    {
        Size = 0;
        MaxSize = 0;
        Root = null;
    }

    public void Tune(double value)
    {
        CheckAlpha(value);
        Alpha = value;
    }

    public (Node<TKey>? Parent, Node<TKey> Scapegoat) FindScapegoatInPath(Stack<Node<TKey>> path)
    {
        if (path.Count == 0)
        {
            throw new ArgumentException("The path collection should not be empty.", nameof(path));
        }

        var depth = 1;

        while (path.TryPop(out var next))
        {
            if (depth > next.GetAlphaHeight(Alpha))
            {
                return path.TryPop(out var parent) ? (parent, next) : (null, next);
            }

            depth++;
        }

        throw new InvalidOperationException("Scapegoat node wasn't found. The tree should be unbalanced.");
    }

    private static void CheckAlpha(double alpha)
    {
        if (alpha is < 0.5 or > 1.0)
        {
            throw new ArgumentException("The alpha parameter's value should be in 0.5..1.0 range.", nameof(alpha));
        }
    }

    private bool Remove(Node<TKey>? parent, Node<TKey>? node, TKey key)
    {
        if (node is null || parent is null)
        {
            return false;
        }

        var compareResult = node.Key.CompareTo(key);

        if (compareResult > 0)
        {
            return Remove(node, node.Left, key);
        }

        if (compareResult < 0)
        {
            return Remove(node, node.Right, key);
        }

        Node<TKey>? replacementNode;

        if (node.Left is null || node.Right is null)
        {
            replacementNode = node.Left ?? node.Right;
        }

        else
        {
            var predecessorNode = node.Left.GetLargestKeyNode();
            Remove(Root, Root, predecessorNode.Key);
            replacementNode = new Node<TKey>(predecessorNode.Key)
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

    private void BalanceFromPath(Stack<Node<TKey>> path)
    {
        var (parent, scapegoat) = FindScapegoatInPath(path);

        var list = new List<Node<TKey>>();

        Extensions.FlattenTree(scapegoat, list);

        var tree = Extensions.RebuildFromList(list, 0, list.Count - 1);

        if (parent == null)
        {
            Root = tree;
        }
        else
        {
            var result = parent.Key.CompareTo(tree.Key);

            if (result < 0)
            {
                parent.Right = tree;
            }
            else
            {
                parent.Left = tree;
            }
        }
    }

    private void UpdateSizes()
    {
        Size += 1;
        MaxSize = Math.Max(Size, MaxSize);
    }
}
