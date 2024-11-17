package com.thealgorithms.dynamicprogramming;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class MatrixChainMultiplicationTest {

    @Test
    void testMatrixCreation() {
        MatrixChainMultiplication.Matrix matrix1 = new MatrixChainMultiplication.Matrix(1, 10, 20);
        MatrixChainMultiplication.Matrix matrix2 = new MatrixChainMultiplication.Matrix(2, 20, 30);

        assertEquals(1, matrix1.count());
        assertEquals(10, matrix1.col());
        assertEquals(20, matrix1.row());

        assertEquals(2, matrix2.count());
        assertEquals(20, matrix2.col());
        assertEquals(30, matrix2.row());
    }

    @Test
    void testMatrixChainOrder() {
        
        ArrayList<MatrixChainMultiplication.Matrix> matrices = new ArrayList<>();
        matrices.add(new MatrixChainMultiplication.Matrix(1, 10, 20)); 
        matrices.add(new MatrixChainMultiplication.Matrix(2, 20, 30)); 

        MatrixChainMultiplication.Result result = MatrixChainMultiplication.calculateMatrixChainOrder(matrices);

        int expectedCost = 6000; 
        int actualCost = result.getM()[1][2];

        assertEquals(expectedCost, actualCost);
    }

    @Test
    void testOptimalParentheses() {
        
        ArrayList<MatrixChainMultiplication.Matrix> matrices = new ArrayList<>();
        matrices.add(new MatrixChainMultiplication.Matrix(1, 10, 20)); 
        matrices.add(new MatrixChainMultiplication.Matrix(2, 20, 30)); 

        MatrixChainMultiplication.Result result = MatrixChainMultiplication.calculateMatrixChainOrder(matrices);

        assertEquals(1, result.getS()[1][2]); 
    }
}
