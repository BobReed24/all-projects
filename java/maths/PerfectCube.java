package com.thealgorithms.maths;

public final class PerfectCube {
    private PerfectCube() {
    }

    public static boolean isPerfectCube(int number) {
        number = Math.abs(number); 
        int a = (int) Math.pow(number, 1.0 / 3);
        return a * a * a == number;
    }

    public static boolean isPerfectCubeMathCbrt(int number) {
        double cubeRoot = Math.cbrt(number);
        return cubeRoot == (int) cubeRoot;
    }
}
