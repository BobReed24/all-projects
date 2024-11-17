package com.thealgorithms.bitmanipulation;

import java.util.ArrayList;
import java.util.List;

public final class GenerateSubsets {
    private GenerateSubsets() {
    }

    public static List<List<Integer>> generateSubsets(int[] set) {
        int n = set.length;
        List<List<Integer>> subsets = new ArrayList<>();

        for (int mask = 0; mask < (1 << n); mask++) {
            List<Integer> subset = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    subset.add(set[i]);
                }
            }
            subsets.add(subset);
        }

        return subsets;
    }
}
