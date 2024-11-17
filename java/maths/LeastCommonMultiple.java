package com.thealgorithms.maths;

public final class LeastCommonMultiple {
    private LeastCommonMultiple() {
    }

    public static int lcm(int num1, int num2) {
        int high;
        int num3;
        int cmv = 0;

        if (num1 > num2) {
            high = num1;
            num3 = num1;
        } else {
            high = num2;
            num3 = num2;
        }

        while (num1 != 0) {
            if (high % num1 == 0 && high % num2 == 0) {
                cmv = high;
                break;
            }
            high += num3;
        }
        return cmv;
    }
}
