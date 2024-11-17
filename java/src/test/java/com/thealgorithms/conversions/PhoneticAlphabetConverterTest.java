package com.thealgorithms.conversions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PhoneticAlphabetConverterTest {

    @ParameterizedTest
    @CsvSource({
        "'AB', 'Alpha Bravo'", "'ABC', 'Alpha Bravo Charlie'", "'A1B2C3', 'Alpha One Bravo Two Charlie Three'", "'Hello', 'Hotel Echo Lima Lima Oscar'", "'123', 'One Two Three'",
        "'ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789', 'Alpha Bravo Charlie Delta Echo Foxtrot Golf Hotel India Juliett Kilo Lima Mike November Oscar Papa Quebec Romeo Sierra Tango Uniform Victor Whiskey X-ray Yankee Zulu Zero One Two Three Four Five Six Seven Eight Nine'",
        "'abcdefghijklmnopqrstuvwxyz0123456789', 'Alpha Bravo Charlie Delta Echo Foxtrot Golf Hotel India Juliett Kilo Lima Mike November Oscar Papa Quebec Romeo Sierra Tango Uniform Victor Whiskey X-ray Yankee Zulu Zero One Two Three Four Five Six Seven Eight Nine'",
        "'', ''", 
        "'A B C', 'Alpha Bravo Charlie'", 
        "'A@B#C', 'Alpha @ Bravo # Charlie'", 
        "'A B C 123', 'Alpha Bravo Charlie One Two Three'", 
        "'a b c', 'Alpha Bravo Charlie'", 
        "'123!@#', 'One Two Three ! @ #'", 
        "'HELLO WORLD', 'Hotel Echo Lima Lima Oscar Whiskey Oscar Romeo Lima Delta'" 
    })
    public void
    testTextToPhonetic(String input, String expectedOutput) {
        assertEquals(expectedOutput, PhoneticAlphabetConverter.textToPhonetic(input));
    }
}
