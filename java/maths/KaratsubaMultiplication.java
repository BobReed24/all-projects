package com.thealgorithms.maths;

import java.math.BigInteger;

public final class KaratsubaMultiplication {

    private KaratsubaMultiplication() {
    }

    public static BigInteger karatsuba(BigInteger x, BigInteger y) {
        
        if (x.bitLength() <= 4 || y.bitLength() <= 4) {
            return x.multiply(y);
        }

        int n = Math.max(x.bitLength(), y.bitLength());

        int m = n / 2;

        BigInteger high1 = x.shiftRight(m); 
        BigInteger low1 = x.subtract(high1.shiftLeft(m)); 

        BigInteger high2 = y.shiftRight(m); 
        BigInteger low2 = y.subtract(high2.shiftLeft(m)); 

        BigInteger z0 = karatsuba(low1, low2); 
        BigInteger z1 = karatsuba(low1.add(high1), low2.add(high2)); 
        BigInteger z2 = karatsuba(high1, high2); 

        return z2
            .shiftLeft(2 * m) 
            .add(z1.subtract(z2).subtract(z0).shiftLeft(m)) 
            .add(z0); 
    }
}
