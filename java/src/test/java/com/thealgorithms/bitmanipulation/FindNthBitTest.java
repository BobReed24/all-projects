package com.thealgorithms.bitmanipulation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public final class FindNthBitTest {

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void findNthBitParameterizedTest(int num, int n, int expected) {
        assertEquals(expected, FindNthBit.findNthBit(num, n));
    }

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(Arguments.of(13, 2, 0), 
            Arguments.of(13, 3, 1), 
            Arguments.of(4, 2, 0), 
            Arguments.of(4, 3, 1), 
            Arguments.of(1, 1, 1) 
        );
    }
}
