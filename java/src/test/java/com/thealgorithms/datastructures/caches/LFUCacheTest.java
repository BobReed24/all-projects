package com.thealgorithms.datastructures.caches;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class LFUCacheTest {

    @Test
    void testLFUCacheWithIntegerValueShouldPass() {
        LFUCache<Integer, Integer> lfuCache = new LFUCache<>(5);
        lfuCache.put(1, 10);
        lfuCache.put(2, 20);
        lfuCache.put(3, 30);
        lfuCache.put(4, 40);
        lfuCache.put(5, 50);

        assertEquals(10, lfuCache.get(1));

        lfuCache.put(6, 60);

        assertNull(lfuCache.get(2));

        assertEquals(60, lfuCache.get(6));

        lfuCache.put(7, 70);

        assertNull(lfuCache.get(2));
        assertEquals(70, lfuCache.get(7));
    }

    @Test
    void testLFUCacheWithStringValueShouldPass() {
        LFUCache<Integer, String> lfuCache = new LFUCache<>(5);
        lfuCache.put(1, "Alpha");
        lfuCache.put(2, "Beta");
        lfuCache.put(3, "Gamma");
        lfuCache.put(4, "Delta");
        lfuCache.put(5, "Epsilon");

        assertEquals("Alpha", lfuCache.get(1));

        lfuCache.put(6, "Digamma");

        assertNull(lfuCache.get(2));

        assertEquals("Digamma", lfuCache.get(6));

        lfuCache.put(7, "Zeta");

        assertNull(lfuCache.get(2));
        assertEquals("Zeta", lfuCache.get(7));
    }

    @Test
    void testUpdateValueShouldPreserveFrequency() {
        LFUCache<Integer, String> lfuCache = new LFUCache<>(3);
        lfuCache.put(1, "A");
        lfuCache.put(2, "B");
        lfuCache.put(3, "C");

        assertEquals("A", lfuCache.get(1)); 
        lfuCache.put(4, "D"); 

        assertNull(lfuCache.get(2)); 
        assertEquals("C", lfuCache.get(3)); 
        assertEquals("A", lfuCache.get(1)); 

        lfuCache.put(1, "Updated A"); 
        assertEquals("Updated A", lfuCache.get(1)); 
    }

    @Test
    void testEvictionPolicyWhenFull() {
        LFUCache<Integer, String> lfuCache = new LFUCache<>(2);
        lfuCache.put(1, "One");
        lfuCache.put(2, "Two");

        assertEquals("One", lfuCache.get(1)); 
        lfuCache.put(3, "Three"); 

        assertNull(lfuCache.get(2)); 
        assertEquals("One", lfuCache.get(1)); 
        assertEquals("Three", lfuCache.get(3)); 
    }

    @Test
    void testGetFromEmptyCacheShouldReturnNull() {
        LFUCache<Integer, String> lfuCache = new LFUCache<>(3);
        assertNull(lfuCache.get(1)); 
    }

    @Test
    void testPutNullValueShouldStoreNull() {
        LFUCache<Integer, String> lfuCache = new LFUCache<>(3);
        lfuCache.put(1, null); 

        assertNull(lfuCache.get(1)); 
    }

    @Test
    void testInvalidCacheCapacityShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> new LFUCache<>(0));
        assertThrows(IllegalArgumentException.class, () -> new LFUCache<>(-1));
    }

    @Test
    void testMultipleAccessPatterns() {
        LFUCache<Integer, String> lfuCache = new LFUCache<>(5);
        lfuCache.put(1, "A");
        lfuCache.put(2, "B");
        lfuCache.put(3, "C");
        lfuCache.put(4, "D");

        assertEquals("A", lfuCache.get(1)); 
        lfuCache.put(5, "E"); 
        lfuCache.put(6, "F"); 

        assertNull(lfuCache.get(2)); 
        assertEquals("C", lfuCache.get(3)); 
        assertEquals("D", lfuCache.get(4)); 
        assertEquals("A", lfuCache.get(1)); 
        assertEquals("E", lfuCache.get(5)); 
        assertEquals("F", lfuCache.get(6)); 
    }
}
