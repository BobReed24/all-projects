package com.thealgorithms.maths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class SolovayStrassenPrimalityTestTest {

    private static final int RANDOM_SEED = 123; 
    private SolovayStrassenPrimalityTest testInstance;

    @BeforeEach
    void setUp() {
        testInstance = SolovayStrassenPrimalityTest.getSolovayStrassenPrimalityTest(RANDOM_SEED);
    }

    static Object[][] primeNumbers() {
        return new Object[][] {{2, 1}, {3, 1}, {5, 5}, {7, 10}, {11, 20}, {13, 10}, {17, 5}, {19, 1}};
    }

    @ParameterizedTest
    @MethodSource("primeNumbers")
    void testPrimeNumbersWithDifferentNAndK(int n, int k) {
        assertTrue(testInstance.solovayStrassen(n, k), n + " should be prime");
    }

    static Object[][] compositeNumbers() {
        return new Object[][] {{4, 1}, {6, 5}, {8, 10}, {9, 20}, {10, 1}, {12, 5}, {15, 10}};
    }

    @ParameterizedTest
    @MethodSource("compositeNumbers")
    void testCompositeNumbersWithDifferentNAndK(int n, int k) {
        assertFalse(testInstance.solovayStrassen(n, k), n + " should be composite");
    }

    @Test
    void testEdgeCases() {
        assertFalse(testInstance.solovayStrassen(-1, 10), "-1 should not be prime");
        assertFalse(testInstance.solovayStrassen(0, 10), "0 should not be prime");
        assertFalse(testInstance.solovayStrassen(1, 10), "1 should not be prime");

        assertTrue(testInstance.solovayStrassen(2, 1), "2 is a prime number (single iteration)");
        assertFalse(testInstance.solovayStrassen(9, 1), "9 is a composite number (single iteration)");

        long largePrime = 104729; 
        long largeComposite = 104730; 

        assertTrue(testInstance.solovayStrassen(largePrime, 20), "104729 is a prime number");
        assertFalse(testInstance.solovayStrassen(largeComposite, 20), "104730 is a composite number");

        long veryLargePrime = 512927357; 
        long veryLargeComposite = 512927358; 

        assertTrue(testInstance.solovayStrassen(veryLargePrime, 20), Long.MAX_VALUE - 1 + " is likely a prime number.");

        assertFalse(testInstance.solovayStrassen(veryLargeComposite, 20), Long.MAX_VALUE + " is a composite number.");
    }

    @Test
    void testJacobiSymbolCalculation() {
        
        int jacobi1 = testInstance.calculateJacobi(6, 11); 
        int jacobi2 = testInstance.calculateJacobi(5, 11); 

        assertEquals(-1, jacobi1);
        assertEquals(+1, jacobi2);

        int jacobi4 = testInstance.calculateJacobi(5, -11); 
        int jacobi5 = testInstance.calculateJacobi(5, 0); 

        assertEquals(0, jacobi4);
        assertEquals(0, jacobi5);
    }
}
