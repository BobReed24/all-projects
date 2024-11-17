package com.thealgorithms.ciphers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class MonoAlphabeticTest {

    @ParameterizedTest
    @MethodSource("provideTestData")
    public void testEncryptDecrypt(String plainText, String key, String encryptedText) {
        
        String actualEncrypted = MonoAlphabetic.encrypt(plainText, key);
        assertEquals(encryptedText, actualEncrypted, "Encryption failed for input: " + plainText + " with key: " + key);

        String actualDecrypted = MonoAlphabetic.decrypt(encryptedText, key);
        assertEquals(plainText, actualDecrypted, "Decryption failed for input: " + encryptedText + " with key: " + key);
    }

    private static Stream<Arguments> provideTestData() {
        return Stream.of(Arguments.of("HELLO", "MNBVCXZLKJHGFDSAPOIUYTREWQ", "LCGGS"), Arguments.of("JAVA", "MNBVCXZLKJHGFDSAPOIUYTREWQ", "JMTM"), Arguments.of("HELLO", "QWERTYUIOPLKJHGFDSAZXCVBNM", "ITKKG"), Arguments.of("JAVA", "QWERTYUIOPLKJHGFDSAZXCVBNM", "PQCQ"));
    }
}
