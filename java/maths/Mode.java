package com.thealgorithms.maths;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public final class Mode {
    private Mode() {
    }

    public static int[] mode(final int[] numbers) {
        if (numbers.length == 0) {
            return null;
        }

        HashMap<Integer, Integer> count = new HashMap<>();

        for (int num : numbers) {
            if (count.containsKey(num)) {
                count.put(num, count.get(num) + 1);
            } else {
                count.put(num, 1);
            }
        }

        int max = Collections.max(count.values());
        ArrayList<Integer> modes = new ArrayList<>();

        for (final var entry : count.entrySet()) {
            if (entry.getValue() == max) {
                modes.add(entry.getKey());
            }
        }
        return modes.stream().mapToInt(n -> n).toArray();
    }
}
