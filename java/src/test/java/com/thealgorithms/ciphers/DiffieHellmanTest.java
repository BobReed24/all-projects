package com.thealgorithms.ciphers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigInteger;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class DiffieHellmanTest {

    @ParameterizedTest
    @MethodSource("provideTestData")
    public void testCalculatePublicValue(BigInteger base, BigInteger secret, BigInteger prime, BigInteger publicExpected, BigInteger sharedExpected) {
        DiffieHellman dh = new DiffieHellman(base, secret, prime); 
        assertEquals(publicExpected, dh.calculatePublicValue()); 
    }

    @ParameterizedTest
    @MethodSource("provideTestData")
    public void testCalculateSharedSecret(BigInteger base, BigInteger secret, BigInteger prime, BigInteger publicExpected, BigInteger sharedExpected) {
        DiffieHellman dh = new DiffieHellman(base, secret, prime); 
        assertEquals(sharedExpected, dh.calculateSharedSecret(publicExpected)); 
    }

    private static Stream<Arguments> provideTestData() {
        return Stream.of(createTestArgs(5, 6, 23, 8, 13), createTestArgs(2, 5, 13, 6, 2));
    }

    private static Arguments createTestArgs(long base, long secret, long prime, long publicExpected, long sharedExpected) {
        return Arguments.of(BigInteger.valueOf(base), BigInteger.valueOf(secret), BigInteger.valueOf(prime), BigInteger.valueOf(publicExpected), BigInteger.valueOf(sharedExpected));
    }
}
