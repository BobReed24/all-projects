namespace DataStructures.SegmentTrees;

public class SegmentTreeUpdate : SegmentTree
{
    
    public SegmentTreeUpdate(int[] arr)
        : base(arr)
    {
    }

    public void Update(int node, int value)
    {
        Tree[node + Tree.Length / 2] = value;
        Propagate(Parent(node + Tree.Length / 2));
    }

    private void Propagate(int node)
    {
        if (node == 0)
        {
            
            return;
        }

        Tree[node] = Tree[Left(node)] + Tree[Right(node)];
        Propagate(Parent(node));
    }
}
