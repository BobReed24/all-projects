package com.thealgorithms.dynamicprogramming;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class UniqueSubsequencesCount {

    private UniqueSubsequencesCount() {
        throw new UnsupportedOperationException("Utility class");
    }

    public static int countSubseq(String str) {

        int[] dp = new int[str.length() + 1];
        Arrays.fill(dp, -1);

        return countSubsequences(str, 0, dp);
    }

    public static int countSubsequences(String st, int idx, int[] dp) {

        if (idx >= st.length()) {
            return 0;
        }

        if (dp[idx] != -1) {
            return dp[idx];
        }

        Set<Character> set = new HashSet<>();

        int res = 0;

        for (int j = idx; j < st.length(); j++) {

            if (set.contains(st.charAt(j))) {
                continue;
            }

            set.add(st.charAt(j));

            res = 1 + countSubsequences(st, j + 1, dp) + res;
        }

        dp[idx] = res;
        return dp[idx];
    }
}
