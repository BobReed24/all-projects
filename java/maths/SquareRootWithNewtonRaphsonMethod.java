package com.thealgorithms.maths;

public final class SquareRootWithNewtonRaphsonMethod {
    private SquareRootWithNewtonRaphsonMethod() {
    }

    public static double squareRoot(int n) {
        double x = n; 
        double root = 0.5 * (x + n / x); 

        while (Math.abs(root - x) > 0.0000001) { 
                                                 
            x = root; 
            root = 0.5 * (x + n / x);
        }

        return root;
    }
}
