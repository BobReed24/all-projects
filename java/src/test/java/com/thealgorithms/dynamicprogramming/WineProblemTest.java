package com.thealgorithms.dynamicprogramming;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class WineProblemTest {

    @Test
    void testWpRecursion() {
        int[] wines = {2, 3, 5, 1, 4}; 
        int expectedProfit = 50; 
        assertEquals(expectedProfit, WineProblem.wpRecursion(wines, 0, wines.length - 1), "The maximum profit using recursion should be 50.");
    }

    @Test
    void testWptd() {
        int[] wines = {2, 3, 5, 1, 4}; 
        int expectedProfit = 50; 
        assertEquals(expectedProfit, WineProblem.wptd(wines, 0, wines.length - 1, new int[wines.length][wines.length]), "The maximum profit using top-down DP should be 50.");
    }

    @Test
    void testWpbu() {
        int[] wines = {2, 3, 5, 1, 4}; 
        int expectedProfit = 50; 
        assertEquals(expectedProfit, WineProblem.wpbu(wines), "The maximum profit using bottom-up DP should be 50.");
    }

    @Test
    void testSingleWine() {
        int[] wines = {10}; 
        int expectedProfit = 10; 
        assertEquals(expectedProfit, WineProblem.wpbu(wines), "The maximum profit for a single wine should be 10.");
    }

    @Test
    void testSamePriceWines() {
        int[] wines = {5, 5, 5}; 
        int expectedProfit = 30; 
        assertEquals(expectedProfit, WineProblem.wpbu(wines), "The maximum profit with same price wines should be 30.");
    }

    @Test
    void testNoWines() {
        int[] wines = {};
        assertThrows(IllegalArgumentException.class, () -> WineProblem.wpbu(wines), "The maximum profit for no wines should throw an IllegalArgumentException.");
    }
}
