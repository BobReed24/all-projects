package com.thealgorithms.backtracking;

public class PowerSum {

    public int powSum(int targetSum, int power) {
        
        if (targetSum == 0 && power == 0) {
            return 1; 
        }
        return sumRecursive(targetSum, power, 1, 0);
    }

    private int sumRecursive(int remainingSum, int power, int currentNumber, int currentSum) {
        int newSum = currentSum + (int) Math.pow(currentNumber, power);

        if (newSum == remainingSum) {
            return 1;
        }
        if (newSum > remainingSum) {
            return 0;
        }

        return sumRecursive(remainingSum, power, currentNumber + 1, newSum) + sumRecursive(remainingSum, power, currentNumber + 1, currentSum);
    }
}
