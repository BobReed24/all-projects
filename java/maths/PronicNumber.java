package com.thealgorithms.maths;

public final class PronicNumber {
    private PronicNumber() {
    }

    static boolean isPronic(int inputNumber) {
        if (inputNumber == 0) {
            return true;
        }
        
        for (int i = 0; i <= inputNumber; i++) {
            
            if (i * (i + 1) == inputNumber && i != inputNumber) {
                
                return true;
            }
        }

        return false;
    }

    public static boolean isPronicNumber(int number) {
        int squareRoot = (int) Math.sqrt(number); 
        return squareRoot * (squareRoot + 1) == number;
    }
}
