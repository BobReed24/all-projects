package com.thealgorithms.dynamicprogramming;

public final class ClimbingStairs {

    private ClimbingStairs() {
    }

    public static int numberOfWays(int n) {

        if (n == 1 || n == 0) {
            return n;
        }

        int prev = 1; 
        int curr = 1; 
        int next; 

        for (int i = 2; i <= n; i++) { 
            next = curr + prev;

            prev = curr;
            curr = next;
        }

        return curr; 
    }
}
