package com.thealgorithms.maths;

public final class FastExponentiation {

    private FastExponentiation() {
    }

    public static long fastExponentiation(long base, long exp, long mod) {
        if (mod <= 0) {
            throw new IllegalArgumentException("Modulus must be positive.");
        }

        if (exp < 0) {
            throw new ArithmeticException("Negative exponent is not supported.");
        }

        long result = 1;
        base = base % mod; 

        while (exp > 0) {
            
            if ((exp & 1) == 1) { 
                result = result * base % mod;
            }
            
            base = base * base % mod; 
            exp >>= 1; 
        }

        return result;
    }
}
