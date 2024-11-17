package com.thealgorithms.maths;

public final class NonRepeatingElement {
    private NonRepeatingElement() {
    }

    public static int[] findNonRepeatingElements(int[] arr) {
        if (arr.length % 2 != 0) {
            throw new IllegalArgumentException("Array should contain an even number of elements");
        }

        int xorResult = 0;

        for (int num : arr) {
            xorResult ^= num;
        }

        int rightmostSetBit = xorResult & (-xorResult);
        int num1 = 0;
        int num2 = 0;

        for (int num : arr) {
            if ((num & rightmostSetBit) != 0) {
                num1 ^= num;
            } else {
                num2 ^= num;
            }
        }

        return new int[] {num1, num2};
    }
}
