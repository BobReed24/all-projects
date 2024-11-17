package com.thealgorithms.searches;

import com.thealgorithms.devutils.searches.SearchAlgorithm;

public class JumpSearch implements SearchAlgorithm {

    @Override
    public <T extends Comparable<T>> int find(T[] array, T key) {
        int length = array.length;
        int blockSize = (int) Math.sqrt(length);

        int limit = blockSize;
        
        while (limit < length && key.compareTo(array[limit]) > 0) {
            limit = Math.min(limit + blockSize, length - 1);
        }

        for (int i = limit - blockSize; i <= limit && i < length; i++) {
            if (array[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }
}
