package com.thealgorithms.maths;

import java.util.ArrayList;
import java.util.List;

public class CollatzConjecture {

    public int nextNumber(final int n) {
        if (n % 2 == 0) {
            return n / 2;
        }
        return 3 * n + 1;
    }

    public List<Integer> collatzConjecture(int firstNumber) {
        if (firstNumber < 1) {
            throw new IllegalArgumentException("Must be a natural number");
        }
        ArrayList<Integer> result = new ArrayList<>();
        result.add(firstNumber);
        while (firstNumber != 1) {
            result.add(nextNumber(firstNumber));
            firstNumber = nextNumber(firstNumber);
        }
        return result;
    }
}
