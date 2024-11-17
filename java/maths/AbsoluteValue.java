package com.thealgorithms.maths;

public final class AbsoluteValue {
    private AbsoluteValue() {
    }

    public static int getAbsValue(int number) {
        return number < 0 ? -number : number;
    }
}
