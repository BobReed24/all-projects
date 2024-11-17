package com.thealgorithms.ciphers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class AtbashTest {

    @ParameterizedTest
    @MethodSource("cipherTestProvider")
    public void testAtbashCipher(String input, String expected) {
        AtbashCipher cipher = new AtbashCipher(input);
        assertEquals(expected, cipher.convert());
    }

    private static Stream<Arguments> cipherTestProvider() {
        return Stream.of(
            
            Arguments.of("Hello", "Svool"), Arguments.of("WORLD", "DLIOW"),

            Arguments.of("Hello World!", "Svool Dliow!"), Arguments.of("123 ABC xyz", "123 ZYX cba"),

            Arguments.of("madam", "nzwzn"), Arguments.of("Palindrome", "Kzormwilnv"),

            Arguments.of("@cipher 123!", "@xrksvi 123!"), Arguments.of("no-change", "ml-xszmtv"),

            Arguments.of("", ""), Arguments.of("A", "Z"), Arguments.of("z", "a"),

            Arguments.of("!@#123", "!@#123"),

            Arguments.of("Hello World! 123, @cipher abcDEF ZYX 987 madam zzZ Palindrome!", "Svool Dliow! 123, @xrksvi zyxWVU ABC 987 nzwzn aaA Kzormwilnv!"),
            Arguments.of("Svool Dliow! 123, @xrksvi zyxWVU ABC 987 nzwzn aaA Kzormwilnv!", "Hello World! 123, @cipher abcDEF ZYX 987 madam zzZ Palindrome!"));
    }
}
