package com.thealgorithms.strings;

import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class WordLadderTest {

    @Test
    public void testWordLadder() {

        List<String> wordList1 = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        assertEquals(WordLadder.ladderLength("hit", "cog", wordList1), 5);
    }

    @Test
    public void testWordLadder2() {

        List<String> wordList2 = Arrays.asList("hot", "dot", "dog", "lot", "log");
        assertEquals(WordLadder.ladderLength("hit", "cog", wordList2), 0);
    }

    @Test
    public void testWordLadder3() {

        List<String> wordList3 = emptyList();
        assertEquals(WordLadder.ladderLength("hit", "cog", wordList3), 0);
    }

    @ParameterizedTest
    @CsvSource({"'a', 'c', 'b,c', 2", "'a', 'c', 'a', 0", "'a', 'a', 'a', 0", "'ab', 'cd', 'ad,bd,cd', 3", "'a', 'd', 'b,c,d', 2", "'a', 'd', 'b,c,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,d', 2"})
    void testLadderLength(String beginWord, String endWord, String wordListStr, int expectedLength) {
        List<String> wordList = List.of(wordListStr.split(","));
        int result = WordLadder.ladderLength(beginWord, endWord, wordList);
        assertEquals(expectedLength, result);
    }
}
