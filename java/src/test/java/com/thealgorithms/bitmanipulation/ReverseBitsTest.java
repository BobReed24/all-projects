package com.thealgorithms.bitmanipulation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ReverseBitsTest {

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void testReverseBits(int input, int expected) {
        assertEquals(expected, ReverseBits.reverseBits(input));
    }

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
            
            Arguments.of(0, 0),

            Arguments.of(-1, -1),

            Arguments.of(43261596, 964176192),

            Arguments.of(Integer.MAX_VALUE, -2),

            Arguments.of(Integer.MIN_VALUE, 1),

            Arguments.of(1, Integer.MIN_VALUE),

            Arguments.of(0xAAAAAAAA, 0x55555555));
    }
}
