package com.thealgorithms.datastructures.trees;

public class FenwickTree {

    private int n;
    private int[] fenTree;

    public FenwickTree(int n) {
        this.n = n;
        this.fenTree = new int[n + 1];
    }

    public void update(int i, int val) {
        
        i += 1;
        while (i <= n) {
            fenTree[i] += val;
            i += i & (-i);
        }
    }

    public int query(int i) {
        
        i += 1;
        int cumSum = 0;
        while (i > 0) {
            cumSum += fenTree[i];
            i -= i & (-i);
        }
        return cumSum;
    }
}
