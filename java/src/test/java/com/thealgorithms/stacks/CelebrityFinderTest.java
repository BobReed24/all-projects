package com.thealgorithms.stacks;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class CelebrityFinderTest {

    @ParameterizedTest
    @MethodSource("providePartyMatrices")
    public void testCelebrityFinder(int[][] party, int expected) {
        assertEquals(expected, CelebrityFinder.findCelebrity(party));
    }

    private static Stream<Arguments> providePartyMatrices() {
        return Stream.of(
            
            Arguments.of(new int[][] {{0, 1, 1}, {0, 0, 1}, {0, 0, 0}}, 2),

            Arguments.of(new int[][] {{0, 1, 0}, {1, 0, 1}, {1, 1, 0}}, -1),

            Arguments.of(new int[][] {{0, 1, 1}, {1, 0, 1}, {1, 1, 0}}, -1),

            Arguments.of(new int[][] {{0}}, 0),

            Arguments.of(new int[][] {{0, 1, 1, 1}, {0, 0, 1, 1}, {0, 0, 0, 1}, {0, 0, 0, 0}}, 3),

            Arguments.of(new int[][] {{0, 1, 1, 0}, {1, 0, 0, 1}, {0, 1, 0, 1}, {1, 1, 1, 0}}, -1),

            Arguments.of(new int[][] {{0, 0, 0}, {1, 0, 1}, {1, 1, 0}}, 0));
    }
}
