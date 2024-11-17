package com.thealgorithms.bitmanipulation;

public final class Xs3Conversion {
    private Xs3Conversion() {
    }
    
    public static int xs3ToBinary(int xs3) {
        int binary = 0;
        int multiplier = 1;
        while (xs3 > 0) {
            int digit = (xs3 & 0xF) - 3; 
            binary += digit * multiplier;
            multiplier *= 10;
            xs3 >>= 4; 
        }
        return binary;
    }

    public static int binaryToXs3(int binary) {
        int xs3 = 0;
        int shift = 0;
        while (binary > 0) {
            int digit = (binary % 10) + 3; 
            xs3 |= (digit << (shift * 4)); 
            binary /= 10; 
            shift++;
        }
        return xs3;
    }
}
