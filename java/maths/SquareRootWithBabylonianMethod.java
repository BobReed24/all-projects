package com.thealgorithms.maths;

public final class SquareRootWithBabylonianMethod {
    private SquareRootWithBabylonianMethod() {
    }

    public static float squareRoot(float num) {
        float a = num;
        float b = 1;
        double e = 0.000001;
        while (a - b > e) {
            a = (a + b) / 2;
            b = num / a;
        }
        return a;
    }
}
