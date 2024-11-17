package com.thealgorithms.divideandconquer;

public class BinaryExponentiation {

    public static long calculatePower(long x, long y) {
        
        if (y == 0) {
            return 1;
        }
        if (y % 2 == 1) { 
            return x * calculatePower(x, y - 1);
        }
        return calculatePower(x * x, y / 2); 
    }

    long power(long n, long m) {
        long power = n;
        long sum = 1;
        while (m > 0) {
            if ((m & 1) == 1) {
                sum *= power;
            }
            power = power * power;
            m = m >> 1;
        }
        return sum;
    }
}
