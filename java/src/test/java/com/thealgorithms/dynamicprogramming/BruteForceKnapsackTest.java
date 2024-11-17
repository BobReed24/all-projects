package com.thealgorithms.dynamicprogramming;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BruteForceKnapsackTest {

    @Test
    void testKnapSackBasicCase() {
        int[] val = {60, 100, 120};
        int[] wt = {10, 20, 30};
        int w = 50;
        int n = val.length;

        assertEquals(220, BruteForceKnapsack.knapSack(w, wt, val, n));
    }

    @Test
    void testKnapSackNoItems() {
        int[] val = {};
        int[] wt = {};
        int w = 50;
        int n = val.length;

        assertEquals(0, BruteForceKnapsack.knapSack(w, wt, val, n));
    }

    @Test
    void testKnapSackZeroCapacity() {
        int[] val = {60, 100, 120};
        int[] wt = {10, 20, 30};
        int w = 0;
        int n = val.length;

        assertEquals(0, BruteForceKnapsack.knapSack(w, wt, val, n));
    }

    @Test
    void testKnapSackSingleItemFits() {
        int[] val = {100};
        int[] wt = {20};
        int w = 30;
        int n = val.length;

        assertEquals(100, BruteForceKnapsack.knapSack(w, wt, val, n));
    }

    @Test
    void testKnapSackSingleItemDoesNotFit() {
        int[] val = {100};
        int[] wt = {20};
        int w = 10;
        int n = val.length;

        assertEquals(0, BruteForceKnapsack.knapSack(w, wt, val, n));
    }

    @Test
    void testKnapSackAllItemsFit() {
        int[] val = {20, 30, 40};
        int[] wt = {1, 2, 3};
        int w = 6;
        int n = val.length;

        assertEquals(90, BruteForceKnapsack.knapSack(w, wt, val, n));
    }

    @Test
    void testKnapSackNoneFit() {
        int[] val = {100, 200, 300};
        int[] wt = {100, 200, 300};
        int w = 50;
        int n = val.length;

        assertEquals(0, BruteForceKnapsack.knapSack(w, wt, val, n));
    }

    @Test
    void testKnapSackSomeItemsFit() {
        int[] val = {60, 100, 120};
        int[] wt = {10, 20, 30};
        int w = 40;
        int n = val.length;

        assertEquals(180, BruteForceKnapsack.knapSack(w, wt, val, n));
    }
}
