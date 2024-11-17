package com.thealgorithms.bitmanipulation;

public final class IsEven {
    private IsEven() {
    }
    public static boolean isEven(int number) {
        return (number & 1) == 0;
    }
}
