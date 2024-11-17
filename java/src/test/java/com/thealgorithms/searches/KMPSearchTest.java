package com.thealgorithms.searches;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class KMPSearchTest {

    @Test
    
    public void kmpSearchTestLast() {
        String txt = "ABABDABACDABABCABAB";
        String pat = "ABABCABAB";
        KMPSearch kmpSearch = new KMPSearch();
        int value = kmpSearch.kmpSearch(pat, txt);
        System.out.println(value);
        assertEquals(value, 10);
    }

    @Test
    
    public void kmpSearchTestFront() {
        String txt = "AAAAABAAABA";
        String pat = "AAAA";
        KMPSearch kmpSearch = new KMPSearch();
        int value = kmpSearch.kmpSearch(pat, txt);
        System.out.println(value);
        assertEquals(value, 0);
    }

    @Test
    
    public void kmpSearchTestMiddle() {
        String txt = "AAACAAAAAC";
        String pat = "AAAA";
        KMPSearch kmpSearch = new KMPSearch();
        int value = kmpSearch.kmpSearch(pat, txt);
        System.out.println(value);
        assertEquals(value, 4);
    }

    @Test
    
    public void kmpSearchTestNotFound() {
        String txt = "AAABAAAA";
        String pat = "AAAA";
        KMPSearch kmpSearch = new KMPSearch();
        int value = kmpSearch.kmpSearch(pat, txt);
        System.out.println(value);
        assertEquals(value, 4);
    }

    @Test
    
    public void kmpSearchTest4() {
        String txt = "AABAAA";
        String pat = "AAAA";
        KMPSearch kmpSearch = new KMPSearch();
        int value = kmpSearch.kmpSearch(pat, txt);
        System.out.println(value);
        assertEquals(value, -1);
    }
}
