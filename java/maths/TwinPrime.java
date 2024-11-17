package com.thealgorithms.maths;

public final class TwinPrime {
    private TwinPrime() {
    }

    static int getTwinPrime(int inputNumber) {

        if (PrimeCheck.isPrime(inputNumber) && PrimeCheck.isPrime(inputNumber + 2)) {
            return inputNumber + 2;
        }
        
        return -1;
    }
}
