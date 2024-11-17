package com.thealgorithms.dynamicprogramming;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class RodCuttingTest {

    @Test
    void testCutRodLength1() {
        int[] prices = {1}; 
        int length = 1;
        int expectedValue = 1;
        assertEquals(expectedValue, RodCutting.cutRod(prices, length), "The maximum obtainable value for a rod of length 1 should be 1.");
    }

    @Test
    void testCutRodLength2() {
        int[] prices = {1, 5}; 
        int length = 2;
        int expectedValue = 5; 
        assertEquals(expectedValue, RodCutting.cutRod(prices, length), "The maximum obtainable value for a rod of length 2 should be 5.");
    }

    @Test
    void testCutRodLength3() {
        int[] prices = {1, 5, 8}; 
        int length = 3;
        int expectedValue = 8; 
        assertEquals(expectedValue, RodCutting.cutRod(prices, length), "The maximum obtainable value for a rod of length 3 should be 8.");
    }

    @Test
    void testCutRodLength4() {
        int[] prices = {1, 5, 8, 9}; 
        int length = 4;
        int expectedValue = 10; 
        assertEquals(expectedValue, RodCutting.cutRod(prices, length), "The maximum obtainable value for a rod of length 4 should be 10.");
    }

    @Test
    void testCutRodLength5() {
        int[] prices = {1, 5, 8, 9, 10}; 
        int length = 5;
        int expectedValue = 13; 
        assertEquals(expectedValue, RodCutting.cutRod(prices, length), "The maximum obtainable value for a rod of length 5 should be 13.");
    }

    @Test
    void testCutRodLength0() {
        int[] prices = {1, 5, 8, 9, 10}; 
        int length = 0;
        int expectedValue = 0; 
        assertEquals(expectedValue, RodCutting.cutRod(prices, length), "The maximum obtainable value for a rod of length 0 should be 0.");
    }

    @Test
    void testCutRodEmptyPrices() {
        int[] prices = {};
        int length = 5;
        assertThrows(IllegalArgumentException.class, () -> RodCutting.cutRod(prices, length), "An empty prices array should throw an IllegalArgumentException.");
    }
    @Test
    void testCutRodNegativeLength() {
        int[] prices = {1, 5, 8, 9, 10}; 
        int length = -1;
        assertThrows(IllegalArgumentException.class, () -> RodCutting.cutRod(prices, length), "A negative rod length should throw an IllegalArgumentException.");
    }
}
