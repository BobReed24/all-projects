namespace DataStructures.Fenwick;

public class BinaryIndexedTree
{
    private readonly int[] fenwickTree;

    public BinaryIndexedTree(int[] array)
    {
        fenwickTree = new int[array.Length + 1];

        for (var i = 0; i < array.Length; i++)
        {
            UpdateTree(i, array[i]);
        }
    }

    public int GetSum(int index)
    {
        var sum = 0;
        var startFrom = index + 1;

        while (startFrom > 0)
        {
            sum += fenwickTree[startFrom];
            startFrom -= startFrom & (-startFrom);
        }

        return sum;
    }

    public void UpdateTree(int index, int val)
    {
        var startFrom = index + 1;

        while (startFrom <= fenwickTree.Length)
        {
            fenwickTree[startFrom] += val;
            startFrom += startFrom & (-startFrom);
        }
    }
}
