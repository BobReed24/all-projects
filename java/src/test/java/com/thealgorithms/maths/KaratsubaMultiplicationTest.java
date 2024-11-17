package com.thealgorithms.maths;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigInteger;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class KaratsubaMultiplicationTest {

    static Stream<Arguments> provideTestCases() {
        return Stream.of(
            
            Arguments.of(new BigInteger("1234"), new BigInteger("5678"), new BigInteger("7006652")),
            
            Arguments.of(new BigInteger("342364"), new BigInteger("393958"), new BigInteger("134877036712")),
            
            Arguments.of(BigInteger.ZERO, new BigInteger("5678"), BigInteger.ZERO),
            
            Arguments.of(BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO),
            
            Arguments.of(new BigInteger("9"), new BigInteger("8"), new BigInteger("72")));
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void testKaratsubaMultiplication(BigInteger x, BigInteger y, BigInteger expected) {
        assertEquals(expected, KaratsubaMultiplication.karatsuba(x, y));
    }
}
