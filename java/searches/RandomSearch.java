package com.thealgorithms.searches;

import com.thealgorithms.devutils.searches.SearchAlgorithm;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomSearch implements SearchAlgorithm {

    private final Random random = new Random();

    @Override
    public <T extends Comparable<T>> int find(T[] array, T key) {
        Set<Integer> visitedIndices = new HashSet<>();
        int size = array.length;

        while (visitedIndices.size() < size) {
            int randomIndex = random.nextInt(size);
            if (array[randomIndex].compareTo(key) == 0) {
                return randomIndex;
            }
            visitedIndices.add(randomIndex);
        }

        return -1;
    }
}
