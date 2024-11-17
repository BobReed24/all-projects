package com.thealgorithms.strings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AhoCorasickTest {
    private String[] patterns; 
    private String text; 

    @BeforeEach
    void setUp() {
        patterns = new String[] {"ACC", "ATC", "CAT", "GCG", "C", "T"};
        text = "GCATCG";
    }

    @Test
    void testSearch() {
        
        final var expected = Map.of("ACC", new ArrayList<>(List.of()), "ATC", new ArrayList<>(List.of(2)), "CAT", new ArrayList<>(List.of(1)), "GCG", new ArrayList<>(List.of()), "C", new ArrayList<>(List.of(1, 4)), "T", new ArrayList<>(List.of(3)));
        assertEquals(expected, AhoCorasick.search(text, patterns));
    }

    @Test
    void testEmptyPatterns() {
        
        final var emptyPatterns = new String[] {};
        assertTrue(AhoCorasick.search(text, emptyPatterns).isEmpty());
    }

    @Test
    void testPatternNotFound() {
        
        final var searchPatterns = new String[] {"XYZ", "123"};
        final var expected = Map.of("XYZ", new ArrayList<Integer>(), "123", new ArrayList<Integer>());
        assertEquals(expected, AhoCorasick.search(text, searchPatterns));
    }

    @Test
    void testPatternAtBeginning() {
        
        final var searchPatterns = new String[] {"GC", "GCA", "GCAT"};
        final var expected = Map.of("GC", new ArrayList<>(List.of(0)), "GCA", new ArrayList<>(List.of(0)), "GCAT", new ArrayList<>(List.of(0)));
        assertEquals(expected, AhoCorasick.search(text, searchPatterns));
    }

    @Test
    void testPatternAtEnd() {
        
        final var searchPatterns = new String[] {"CG", "TCG", "ATCG"};
        final var expected = Map.of("CG", new ArrayList<>(List.of(4)), "TCG", new ArrayList<>(List.of(3)), "ATCG", new ArrayList<>(List.of(2)));
        assertEquals(expected, AhoCorasick.search(text, searchPatterns));
    }

    @Test
    void testMultipleOccurrencesOfPattern() {
        
        final var searchPatterns = new String[] {"AT", "T"};
        final var expected = Map.of("AT", new ArrayList<>(List.of(2)), "T", new ArrayList<>(List.of(3)));
        assertEquals(expected, AhoCorasick.search(text, searchPatterns));
    }

    @Test
    void testCaseInsensitiveSearch() {
        
        final var searchPatterns = new String[] {"gca", "aTc", "C"};
        final var expected = Map.of("gca", new ArrayList<Integer>(), "aTc", new ArrayList<Integer>(), "C", new ArrayList<>(Arrays.asList(1, 4)));
        assertEquals(expected, AhoCorasick.search(text, searchPatterns));
    }
}
