package com.thealgorithms.dynamicprogramming;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class AbbreviationTest {

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void testAbbreviation(String a, String b, boolean expected) {
        assertEquals(expected, Abbreviation.abbr(a, b));
    }

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
            
            Arguments.of("daBcd", "ABC", Boolean.TRUE),

            Arguments.of("dBcd", "ABC", Boolean.FALSE),

            Arguments.of("ABC", "ABC", Boolean.TRUE),

            Arguments.of("aAbBcC", "ABC", Boolean.TRUE),

            Arguments.of("abcd", "ABCD", Boolean.TRUE),

            Arguments.of("abc", "", Boolean.TRUE),

            Arguments.of("", "A", Boolean.FALSE),

            Arguments.of("daBcAbCd", "ABCD", Boolean.FALSE));
    }
}
