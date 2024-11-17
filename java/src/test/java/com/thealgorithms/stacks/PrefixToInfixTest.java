package com.thealgorithms.stacks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PrefixToInfixTest {

    @ParameterizedTest
    @MethodSource("provideValidPrefixToInfixTestCases")
    void testValidPrefixToInfixConversion(String prefix, String expectedInfix) {
        assertEquals(expectedInfix, PrefixToInfix.getPrefixToInfix(prefix));
    }

    static Stream<Arguments> provideValidPrefixToInfixTestCases() {
        return Stream.of(Arguments.of("A", "A"), 
            Arguments.of("+AB", "(A+B)"), 
            Arguments.of("*+ABC", "((A+B)*C)"), 
            Arguments.of("-+A*BCD", "((A+(B*C))-D)"), 
            Arguments.of("/-A*BC+DE", "((A-(B*C))/(D+E))"), 
            Arguments.of("^+AB*CD", "((A+B)^(C*D))") 
        );
    }

    @Test
    void testEmptyPrefixExpression() {
        assertEquals("", PrefixToInfix.getPrefixToInfix(""));
    }

    @Test
    void testNullPrefixExpression() {
        assertThrows(NullPointerException.class, () -> PrefixToInfix.getPrefixToInfix(null));
    }

    @Test
    void testMalformedPrefixExpression() {
        assertThrows(ArithmeticException.class, () -> PrefixToInfix.getPrefixToInfix("+ABC"));
    }
}
