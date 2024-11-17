using System;

namespace DataStructures.AVLTree;

internal class AvlTreeNode<TKey>
{
    
    public TKey Key { get; set; }

    public int BalanceFactor { get; private set; }

    public AvlTreeNode<TKey>? Left { get; set; }

    public AvlTreeNode<TKey>? Right { get; set; }

    private int Height { get; set; }

    public AvlTreeNode(TKey key)
    {
        Key = key;
    }

    public void UpdateBalanceFactor()
    {
        if (Left is null && Right is null)
        {
            Height = 0;
            BalanceFactor = 0;
        }
        else if (Left is null)
        {
            Height = Right!.Height + 1;
            BalanceFactor = Height;
        }
        else if (Right is null)
        {
            Height = Left!.Height + 1;
            BalanceFactor = -Height;
        }
        else
        {
            Height = Math.Max(Left.Height, Right.Height) + 1;
            BalanceFactor = Right.Height - Left.Height;
        }
    }
}
