using System;

namespace DataStructures.SegmentTrees;

public class SegmentTree
{
    
    public SegmentTree(int[] arr)
    {
        
        var pow = (int)Math.Pow(2, Math.Ceiling(Math.Log(arr.Length, 2)));
        Tree = new int[2 * pow];

        Array.Copy(arr, 0, Tree, pow, arr.Length);

        for (var i = pow - 1; i > 0; --i)
        {
            Tree[i] = Tree[Left(i)] + Tree[Right(i)];
        }
    }

    public int[] Tree { get; }

    public int Query(int l, int r) =>
        Query(++l, ++r, 1, Tree.Length / 2, 1);

    protected int Right(int node) => 2 * node + 1;

    protected int Left(int node) => 2 * node;

    protected int Parent(int node) => node / 2;

    protected virtual int Query(int l, int r, int a, int b, int i)
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

        return Query(l, r, a, m, Left(i)) + Query(l, r, m + 1, b, Right(i));
    }
}
