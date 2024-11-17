package com.thealgorithms.maths;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class LongDivisionTest {

    @Test
    void testOne() {
        assertEquals(3, LongDivision.divide(10, 3));
    }

    @Test
    void testTwo() {
        assertEquals(-2, LongDivision.divide(7, -3));
    }

    @Test
    void testThree() {
        assertEquals(10, LongDivision.divide(105, 10));
    }

    @Test
    void testNegativeDividend() {
        assertEquals(-1, LongDivision.divide(-5, 3));
    }

    @Test
    void testDividendLessThanDivisor() {
        assertEquals(0, LongDivision.divide(3, 5));
    }

    @Test
    void testDividendIsZero() {
        assertEquals(0, LongDivision.divide(0, 5));
    }

    @Test
    void testDivisionByZero() {
        assertEquals(0, LongDivision.divide(5, 0));
    }
}
