package com.thealgorithms.dynamicprogramming;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class CountFriendsPairingTest {

    @Test
    void testSmallCase() {
        int n = 5;
        int[] expectedGolombSequence = {1, 2, 2, 3, 3};

        assertTrue(CountFriendsPairing.countFriendsPairing(n, expectedGolombSequence));
    }

    @Test
    void testMismatchSequence() {
        int n = 5;
        int[] wrongSequence = {1, 2, 2, 2, 3}; 

        assertFalse(CountFriendsPairing.countFriendsPairing(n, wrongSequence));
    }

    @Test
    void testLargerCase() {
        int n = 10;
        int[] expectedGolombSequence = {1, 2, 2, 3, 3, 4, 4, 4, 5, 5};

        assertTrue(CountFriendsPairing.countFriendsPairing(n, expectedGolombSequence));
    }

    @Test
    void testEdgeCaseSingleElement() {
        int n = 1;
        int[] expectedGolombSequence = {1};

        assertTrue(CountFriendsPairing.countFriendsPairing(n, expectedGolombSequence));
    }

    @Test
    void testEmptySequence() {
        int n = 0;
        int[] emptySequence = {};

        assertTrue(CountFriendsPairing.countFriendsPairing(n, emptySequence));
    }
}
