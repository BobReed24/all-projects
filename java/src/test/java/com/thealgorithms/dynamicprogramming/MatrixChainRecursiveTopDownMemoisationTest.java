package com.thealgorithms.dynamicprogramming;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MatrixChainRecursiveTopDownMemoisationTest {

    @Test
    void testFourMatrices() {
        int[] dimensions = {1, 2, 3, 4, 5};
        int expected = 38;
        int actual = MatrixChainRecursiveTopDownMemoisation.memoizedMatrixChain(dimensions);
        assertEquals(expected, actual, "The minimum number of multiplications should be 38.");
    }

    @Test
    void testThreeMatrices() {
        int[] dimensions = {10, 20, 30, 40};
        int expected = 18000;
        int actual = MatrixChainRecursiveTopDownMemoisation.memoizedMatrixChain(dimensions);
        assertEquals(expected, actual, "The minimum number of multiplications should be 18000.");
    }

    @Test
    void testTwoMatrices() {
        int[] dimensions = {5, 10, 20};
        int expected = 1000;
        int actual = MatrixChainRecursiveTopDownMemoisation.memoizedMatrixChain(dimensions);
        assertEquals(expected, actual, "The minimum number of multiplications should be 1000.");
    }

    @Test
    void testSingleMatrix() {
        int[] dimensions = {10, 20}; 
        int expected = 0;
        int actual = MatrixChainRecursiveTopDownMemoisation.memoizedMatrixChain(dimensions);
        assertEquals(expected, actual, "The minimum number of multiplications should be 0.");
    }

    @Test
    void testVaryingDimensions() {
        int[] dimensions = {2, 3, 4, 5, 6}; 
        int expected = 124; 
        int actual = MatrixChainRecursiveTopDownMemoisation.memoizedMatrixChain(dimensions);
        assertEquals(expected, actual, "The minimum number of multiplications should be 124.");
    }
}
