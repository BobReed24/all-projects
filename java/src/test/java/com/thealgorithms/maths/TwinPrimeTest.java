package com.thealgorithms.maths;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TwinPrimeTest {

    @Test
    void shouldReturn7() {
        
        int number = 5;
        int expectedResult = 7;

        int actualResult = TwinPrime.getTwinPrime(number);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void shouldReturn5() {
        
        int number = 3;
        int expectedResult = 5;

        int actualResult = TwinPrime.getTwinPrime(number);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void shouldReturnNegative1() {
        
        int number = 4;
        int expectedResult = -1;

        int actualResult = TwinPrime.getTwinPrime(number);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void shouldReturn19() {
        
        int number = 17;
        int expectedResult = 19;

        int actualResult = TwinPrime.getTwinPrime(number);

        assertEquals(expectedResult, actualResult);
    }
}
