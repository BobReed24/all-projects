package com.thealgorithms.misc;

import java.util.HashMap;
import java.util.Optional;
import org.apache.commons.lang3.tuple.Pair;

public final class TwoSumProblem {
    private TwoSumProblem() {
    }

    public static Optional<Pair<Integer, Integer>> twoSum(final int[] values, final int target) {
        HashMap<Integer, Integer> valueToIndex = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            final var remainder = target - values[i];
            if (valueToIndex.containsKey(remainder)) {
                return Optional.of(Pair.of(valueToIndex.get(remainder), i));
            }
            if (!valueToIndex.containsKey(values[i])) {
                valueToIndex.put(values[i], i);
            }
        }
        return Optional.empty();
    }
}
