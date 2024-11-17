package com.thealgorithms.matrixexponentiation;

import java.util.Scanner;

public final class Fibonacci {
    private Fibonacci() {
    }

    private static final int[][] FIB_MATRIX = {{1, 1}, {1, 0}};
    private static final int[][] IDENTITY_MATRIX = {{1, 0}, {0, 1}};
    
    private static final int[][] BASE_FIB_NUMBERS = {{1}, {0}};

    private static int[][] matrixMultiplication(int[][] matrix1, int[][] matrix2) {
        
        int rowsInMatrix1 = matrix1.length;
        int columnsInMatrix1 = matrix1[0].length;

        int rowsInMatrix2 = matrix2.length;
        int columnsInMatrix2 = matrix2[0].length;

        assert columnsInMatrix1 == rowsInMatrix2;
        int[][] product = new int[rowsInMatrix1][columnsInMatrix2];
        for (int rowIndex = 0; rowIndex < rowsInMatrix1; rowIndex++) {
            for (int colIndex = 0; colIndex < columnsInMatrix2; colIndex++) {
                int matrixEntry = 0;
                for (int intermediateIndex = 0; intermediateIndex < columnsInMatrix1; intermediateIndex++) {
                    matrixEntry += matrix1[rowIndex][intermediateIndex] * matrix2[intermediateIndex][colIndex];
                }
                product[rowIndex][colIndex] = matrixEntry;
            }
        }
        return product;
    }

    public static int[][] fib(int n) {
        if (n == 0) {
            return Fibonacci.IDENTITY_MATRIX;
        } else {
            int[][] cachedResult = fib(n / 2);
            int[][] matrixExpResult = matrixMultiplication(cachedResult, cachedResult);
            if (n % 2 == 0) {
                return matrixExpResult;
            } else {
                return matrixMultiplication(Fibonacci.FIB_MATRIX, matrixExpResult);
            }
        }
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] result = matrixMultiplication(fib(n), BASE_FIB_NUMBERS);
        System.out.println("Fib(" + n + ") = " + result[1][0]);
        sc.close();
    }
}
