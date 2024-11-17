package com.thealgorithms.bitmanipulation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class NonRepeatingNumberFinderTest {

    @ParameterizedTest
    @MethodSource("testCases")
    void testNonRepeatingNumberFinder(int[] arr, int expected) {
        assertEquals(expected, NonRepeatingNumberFinder.findNonRepeatingNumber(arr));
    }

    private static Arguments[] testCases() {
        return new Arguments[] {
            Arguments.of(new int[] {1, 2, 1, 2, 6}, 6), Arguments.of(new int[] {1, 2, 1, 2}, 0), 
            Arguments.of(new int[] {12}, 12), 
            Arguments.of(new int[] {3, 5, 3, 4, 4}, 5), 
            Arguments.of(new int[] {7, 8, 7, 9, 8, 10, 10}, 9), 
            Arguments.of(new int[] {0, -1, 0, -1, 2}, 2), 
            Arguments.of(new int[] {Integer.MAX_VALUE, 1, 1}, Integer.MAX_VALUE), 
            Arguments.of(new int[] {2, 2, 3, 3, 4, 5, 4}, 5), 
            Arguments.of(new int[] {}, 0) 
        };
    }
}
