package com.thealgorithms.bitmanipulation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public final class SingleElementTest {

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void testFindSingleElement(int[] arr, int expected) {
        assertEquals(expected, SingleElement.findSingleElement(arr));
    }

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(Arguments.of(new int[] {1, 1, 2, 2, 4, 4, 3}, 3), Arguments.of(new int[] {1, 2, 2, 3, 3}, 1), Arguments.of(new int[] {10}, 10));
    }
}
