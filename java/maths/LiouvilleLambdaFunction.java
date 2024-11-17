package com.thealgorithms.maths;

public final class LiouvilleLambdaFunction {
    private LiouvilleLambdaFunction() {
    }

    static int liouvilleLambda(int number) {
        if (number <= 0) {
            
            throw new IllegalArgumentException("Number must be greater than zero.");
        }

        return PrimeFactorization.pfactors(number).size() % 2 == 0 ? 1 : -1;
    }
}
