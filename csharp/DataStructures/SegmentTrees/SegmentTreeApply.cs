using System;

namespace DataStructures.SegmentTrees;

public class SegmentTreeApply : SegmentTree
{
    
    public SegmentTreeApply(int[] arr)
        : base(arr)
    {
        
        Operand = new int[Tree.Length];
        Array.Fill(Operand, 1);
    }

    public int[] Operand { get; }

    public void Apply(int l, int r, int value)
    {
        
        Apply(++l, ++r, value, 1, Tree.Length / 2, 1);
    }

    protected override int Query(int l, int r, int a, int b, int i)
    {
        if (l <= a && b <= r)
        {
            return Tree[i];
        }

        if (r < a || b < l)
        {
            return 0;
        }

        var m = (a + b) / 2;

        return Operand[i] * (Query(l, r, a, m, Left(i)) + Query(l, r, m + 1, b, Right(i)));
    }

    private void Apply(int l, int r, int value, int a, int b, int i)
    {
        
        if (l <= a && b <= r)
        {
            
            Operand[i] = value * Operand[i];
            Tree[i] = value * Tree[i];
            return;
        }

        if (r < a || b < l)
        {
            return;
        }

        var m = (a + b) / 2;

        Apply(l, r, value, a, m, Left(i));
        Apply(l, r, value, m + 1, b, Right(i));

        Tree[i] = Operand[i] * (Tree[Left(i)] + Tree[Right(i)]);
    }
}
