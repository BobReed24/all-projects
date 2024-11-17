package com.thealgorithms.stacks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class InfixToPrefixTest {

    @ParameterizedTest
    @MethodSource("provideValidExpressions")
    void testValidExpressions(String infix, String expectedPrefix) throws Exception {
        assertEquals(expectedPrefix, InfixToPrefix.infix2Prefix(infix));
    }

    @Test
    void testEmptyString() {
        
        assertEquals("", InfixToPrefix.infix2Prefix(""));
    }

    @Test
    void testNullValue() {
        
        assertThrows(NullPointerException.class, () -> InfixToPrefix.infix2Prefix(null));
    }

    private static Stream<Arguments> provideValidExpressions() {
        return Stream.of(Arguments.of("3+2", "+32"), 
            Arguments.of("1+(2+3)", "+1+23"), 
            Arguments.of("(3+4)*5-6", "-*+3456"), 
            Arguments.of("a+b*c", "+a*bc"), 
            Arguments.of("a+b*c/d", "+a/*bcd"), 
            Arguments.of("a+b*c-d", "-+a*bcd"), 
            Arguments.of("a+b*c/d-e", "-+a/*bcde"), 
            Arguments.of("a+b*(c-d)", "+a*b-cd"), 
            Arguments.of("a+b*(c-d)/e", "+a/*b-cde") 
        );
    }
}
