package com.thealgorithms.dynamicprogramming;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class NewManShanksPrimeTest {

    @Test
    void testNthManShanksPrime1() {
        int n = 1;
        int expectedAnswer = 1;
        assertTrue(NewManShanksPrime.nthManShanksPrime(n, expectedAnswer), "The 1st New Man Shanks prime should be 1.");
    }

    @Test
    void testNthManShanksPrime2() {
        int n = 2;
        int expectedAnswer = 3;
        assertTrue(NewManShanksPrime.nthManShanksPrime(n, expectedAnswer), "The 2nd New Man Shanks prime should be 3.");
    }

    @Test
    void testNthManShanksPrime3() {
        int n = 3;
        int expectedAnswer = 7;
        assertTrue(NewManShanksPrime.nthManShanksPrime(n, expectedAnswer), "The 3rd New Man Shanks prime should be 7.");
    }

    @Test
    void testNthManShanksPrime4() {
        int n = 4;
        int expectedAnswer = 17;
        assertTrue(NewManShanksPrime.nthManShanksPrime(n, expectedAnswer), "The 4th New Man Shanks prime should be 17.");
    }

    @Test
    void testNthManShanksPrime5() {
        int n = 5;
        int expectedAnswer = 41;
        assertTrue(NewManShanksPrime.nthManShanksPrime(n, expectedAnswer), "The 5th New Man Shanks prime should be 41.");
    }

    @Test
    void testNthManShanksPrimeIncorrectAnswer() {
        int n = 2;
        int expectedAnswer = 4; 
        assertFalse(NewManShanksPrime.nthManShanksPrime(n, expectedAnswer), "The 2nd New Man Shanks prime should not be 4.");
    }
}
