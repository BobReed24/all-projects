package com.thealgorithms.conversions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TurkishToLatinConversionTest {

    @ParameterizedTest
    @CsvSource({
        "'çalışma', 'calisma'", 
        "'ÇALIŞMA', 'CALISMA'", 
        "'İSTANBUL', 'ISTANBUL'", 
        "'istanbul', 'istanbul'", 
        "'GÜL', 'GUL'", 
        "'gül', 'gul'", 
        "'ÖĞRENME', 'OGRENME'", 
        "'öğrenme', 'ogrenme'", 
        "'ŞEHIR', 'SEHIR'", 
        "'şehir', 'sehir'", 
        "'HELLO', 'HELLO'", 
        "'Merhaba Dünya!', 'Merhaba Dunya!'", 
        "'Çift kişilik yataklı odalar', 'Cift kisilik yatakli odalar'", 
        "'', ''" 
    })
    public void
    testConvertTurkishToLatin(String input, String expectedOutput) {
        assertEquals(expectedOutput, TurkishToLatinConversion.convertTurkishToLatin(input));
    }
}
