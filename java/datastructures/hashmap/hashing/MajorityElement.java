package com.thealgorithms.datastructures.hashmap.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class MajorityElement {
    private MajorityElement() {
    }

    public static List<Integer> majority(int[] nums) {
        HashMap<Integer, Integer> numToCount = new HashMap<>();
        for (final var num : nums) {
            numToCount.merge(num, 1, Integer::sum);
        }
        List<Integer> majorityElements = new ArrayList<>();
        for (final var entry : numToCount.entrySet()) {
            if (entry.getValue() >= nums.length / 2) {
                majorityElements.add(entry.getKey());
            }
        }
        return majorityElements;
    }
}
