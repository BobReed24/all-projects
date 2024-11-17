package com.thealgorithms.bitmanipulation;

public final class GrayCodeConversion {
    private GrayCodeConversion() {
    }

    public static int binaryToGray(int num) {
        return num ^ (num >> 1);
    }

    public static int grayToBinary(int gray) {
        int binary = gray;
        while (gray > 0) {
            gray >>= 1;
            binary ^= gray;
        }
        return binary;
    }
}
