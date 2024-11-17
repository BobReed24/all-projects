namespace DataStructures.AATree;

public class AaTreeNode<TKey>
{
    
    public AaTreeNode(TKey key, int level)
    {
        Key = key;
        Level = level;
    }

    public TKey Key { get; set; }

    public int Level { get; set; }

    public AaTreeNode<TKey>? Left { get; set; }

    public AaTreeNode<TKey>? Right { get; set; }
}
