package com.thealgorithms.dynamicprogramming;

import java.util.Arrays;

public final class PartitionProblem {
    private PartitionProblem() {
    }

    public static boolean partition(int[] nums) {
        
        int sum = Arrays.stream(nums).sum();

        return (sum & 1) == 0 && SubsetSum.subsetSum(nums, sum / 2);
    }
}
