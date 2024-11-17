package com.thealgorithms.maths;

import static java.util.Collections.singletonList;

import java.util.ArrayList;
import java.util.Map;
import org.apache.commons.lang3.tuple.MutablePair;

public class NthUglyNumber {
    private ArrayList<Long> uglyNumbers = new ArrayList<>(singletonList(1L));
    private ArrayList<MutablePair<Integer, Integer>> positions = new ArrayList<>();

    NthUglyNumber(final int[] baseNumbers) {
        if (baseNumbers.length == 0) {
            throw new IllegalArgumentException("baseNumbers must be non-empty.");
        }

        for (final var baseNumber : baseNumbers) {
            this.positions.add(MutablePair.of(baseNumber, 0));
        }
    }

    public Long get(final int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be non-negative.");
        }

        while (uglyNumbers.size() <= n) {
            addUglyNumber();
        }

        return uglyNumbers.get(n);
    }

    private void addUglyNumber() {
        uglyNumbers.add(computeMinimalCandidate());
        updatePositions();
    }

    private void updatePositions() {
        final var lastUglyNumber = uglyNumbers.get(uglyNumbers.size() - 1);
        for (var entry : positions) {
            if (computeCandidate(entry) == lastUglyNumber) {
                entry.setValue(entry.getValue() + 1);
            }
        }
    }

    private long computeCandidate(final Map.Entry<Integer, Integer> entry) {
        return entry.getKey() * uglyNumbers.get(entry.getValue());
    }

    private long computeMinimalCandidate() {
        long res = Long.MAX_VALUE;
        for (final var entry : positions) {
            res = Math.min(res, computeCandidate(entry));
        }
        return res;
    }
}
