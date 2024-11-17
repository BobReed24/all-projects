namespace Algorithms.Knapsack;

public class BranchAndBoundNode
{
    
    public bool IsTaken { get; }

    public int CumulativeWeight { get; set; }

    public double CumulativeValue { get; set; }

    public double UpperBound { get; set; }

    public int Level { get; }

    public BranchAndBoundNode? Parent { get; }

    public BranchAndBoundNode(int level, bool taken, BranchAndBoundNode? parent = null)
    {
        Level = level;
        IsTaken = taken;
        Parent = parent;
    }
}
