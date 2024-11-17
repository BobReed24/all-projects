package com.thealgorithms.datastructures.queues;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SlidingWindowMaximumTest {

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void testMaxSlidingWindow(int[] nums, int k, int[] expected) {
        assertArrayEquals(expected, SlidingWindowMaximum.maxSlidingWindow(nums, k));
    }

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
            
            Arguments.of(new int[] {1, 3, -1, -3, 5, 3, 6, 7}, 3, new int[] {3, 3, 5, 5, 6, 7}),

            Arguments.of(new int[] {4, 4, 4, 4, 4}, 2, new int[] {4, 4, 4, 4}),

            Arguments.of(new int[] {2, 1, 5, 3, 6}, 5, new int[] {6}),

            Arguments.of(new int[] {7}, 1, new int[] {7}),

            Arguments.of(new int[] {1, 2, 3}, 4, new int[] {}),

            Arguments.of(new int[] {9, 8, 7, 6, 5, 4}, 3, new int[] {9, 8, 7, 6}),

            Arguments.of(new int[] {1, 2, 3, 4, 5}, 2, new int[] {2, 3, 4, 5}),

            Arguments.of(new int[] {1, 3, -1, -3, 5, 3, 6, 7}, 0, new int[] {}),

            Arguments.of(new int[] {-4, -2, -5, -1, -3}, 3, new int[] {-2, -1, -1}),

            Arguments.of(new int[] {}, 3, new int[] {}));
    }
}
