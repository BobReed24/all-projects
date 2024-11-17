package com.thealgorithms.misc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class MedianOfMatrix {
    private MedianOfMatrix() {
    }

    public static int median(Iterable<List<Integer>> matrix) {
        
        List<Integer> linear = new ArrayList<>();
        for (List<Integer> row : matrix) {
            linear.addAll(row);
        }

        Collections.sort(linear);

        int mid = (0 + linear.size() - 1) / 2;

        return linear.get(mid);
    }
}
