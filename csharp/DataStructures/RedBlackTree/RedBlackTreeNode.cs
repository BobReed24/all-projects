namespace DataStructures.RedBlackTree;

public enum NodeColor : byte
{
    
    Red,

    Black,
}

public class RedBlackTreeNode<TKey>
{
    
    public TKey Key { get; set; }

    public NodeColor Color { get; set; }

    public RedBlackTreeNode<TKey>? Parent { get; set; }

    public RedBlackTreeNode<TKey>? Left { get; set; }

    public RedBlackTreeNode<TKey>? Right { get; set; }

    public RedBlackTreeNode(TKey key, RedBlackTreeNode<TKey>? parent)
    {
        Key = key;
        Parent = parent;
    }
}
