package com.thealgorithms.maths;

public final class MobiusFunction {
    private MobiusFunction() {
    }

    static int mobius(int number) {
        if (number <= 0) {
            
            throw new IllegalArgumentException("Number must be greater than zero.");
        }

        if (number == 1) {
            
            return 1;
        }

        int primeFactorCount = 0;

        for (int i = 1; i <= number; i++) {
            
            if (number % i == 0 && PrimeCheck.isPrime(i)) {
                
                if (number % (i * i) == 0) {
                    
                    return 0;
                }
                
                primeFactorCount++;
            }
        }

        return (primeFactorCount % 2 == 0) ? 1 : -1;
    }
}
