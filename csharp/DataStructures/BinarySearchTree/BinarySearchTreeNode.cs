namespace DataStructures.BinarySearchTree;

public class BinarySearchTreeNode<TKey>
{
    
    public BinarySearchTreeNode(TKey key) => Key = key;

    public TKey Key { get; }

    public BinarySearchTreeNode<TKey>? Left { get; set; }

    public BinarySearchTreeNode<TKey>? Right { get; set; }
}
