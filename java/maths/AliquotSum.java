package com.thealgorithms.maths;

import java.util.stream.IntStream;

public final class AliquotSum {
    private AliquotSum() {
    }

    public static int getAliquotValue(int number) {
        var sumWrapper = new Object() { int value = 0; };

        IntStream.iterate(1, i -> ++i).limit(number / 2).filter(i -> number % i == 0).forEach(i -> sumWrapper.value += i);

        return sumWrapper.value;
    }

    public static int getAliquotSum(int n) {
        if (n <= 0) {
            return -1;
        }
        int sum = 1;
        double root = Math.sqrt(n);
        
        for (int i = 2; i <= root; i++) {
            if (n % i == 0) {
                sum += i + n / i;
            }
        }
        
        if (root == (int) root) {
            sum -= root;
        }
        return sum;
    }
}
