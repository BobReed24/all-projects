package com.thealgorithms.bitmanipulation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class NumberAppearingOddTimesTest {

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void testFindOddOccurrence(int[] input, int expected) {
        assertEquals(expected, NumberAppearingOddTimes.findOddOccurrence(input));
    }

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
            
            Arguments.of(new int[] {5, 6, 7, 8, 6, 7, 5}, 8),

            Arguments.of(new int[] {2, 3, 5, 4, 5, 2, 4, 3, 5, 2, 4, 4, 2}, 5),

            Arguments.of(new int[] {10, 10, 20, 20, 30}, 30),

            Arguments.of(new int[] {-5, -5, -3, -3, -7, -7, -7}, -7),

            Arguments.of(new int[] {1, 2, 1, 2}, 0),

            Arguments.of(new int[] {42}, 42),

            Arguments.of(new int[] {1, 1, 2, 2, 3, 3, 3, 4, 4}, 3));
    }
}
