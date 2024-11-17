package com.thealgorithms.datastructures.caches;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class MRUCacheTest {

    private static final int SIZE = 5;

    @Test
    public void putAndGetIntegerValues() {
        MRUCache<Integer, Integer> mruCache = new MRUCache<>(SIZE);

        for (int i = 0; i < SIZE; i++) {
            mruCache.put(i, i);
        }

        for (int i = 0; i < SIZE; i++) {
            assertEquals(i, mruCache.get(i));
        }
    }

    @Test
    public void putAndGetStringValues() {
        MRUCache<String, String> mruCache = new MRUCache<>(SIZE);

        for (int i = 0; i < SIZE; i++) {
            mruCache.put("key" + i, "value" + i);
        }

        for (int i = 0; i < SIZE; i++) {
            assertEquals("value" + i, mruCache.get("key" + i));
        }
    }

    @Test
    public void nullKeysAndValues() {
        MRUCache<Integer, Integer> mruCache = new MRUCache<>(SIZE);
        mruCache.put(null, 2);
        mruCache.put(6, null);

        assertEquals(2, mruCache.get(null));
        assertNull(mruCache.get(6));
    }

    @Test
    public void overCapacity() {
        MRUCache<Integer, Integer> mruCache = new MRUCache<>(SIZE);

        for (int i = 0; i < 10; i++) {
            mruCache.put(i, i);
        }

        assertEquals(9, mruCache.get(9)); 
        assertEquals(0, mruCache.get(0)); 
    }

    @Test
    public void overwriteExistingKey() {
        MRUCache<Integer, String> mruCache = new MRUCache<>(SIZE);
        mruCache.put(1, "one");
        mruCache.put(1, "uno"); 

        assertEquals("uno", mruCache.get(1));
        assertNull(mruCache.get(2)); 
    }

    @Test
    public void evictionOrder() {
        MRUCache<Integer, Integer> mruCache = new MRUCache<>(SIZE);

        for (int i = 0; i < SIZE; i++) {
            mruCache.put(i, i);
        }

        mruCache.get(2);

        mruCache.put(5, 5);
        mruCache.put(6, 6);

        assertEquals(3, mruCache.get(3));
        assertEquals(4, mruCache.get(4)); 
        assertEquals(6, mruCache.get(6)); 
    }

    @Test
    public void cacheHandlesLargeValues() {
        MRUCache<String, String> mruCache = new MRUCache<>(SIZE);

        for (int i = 0; i < SIZE; i++) {
            mruCache.put("key" + i, "value" + i);
        }

        for (int i = 0; i < SIZE; i++) {
            assertEquals("value" + i, mruCache.get("key" + i));
        }

        mruCache.put("largeKey", "largeValue");

        assertEquals("value0", mruCache.get("key0"));
        assertEquals("largeValue", mruCache.get("largeKey"));
    }

    @Test
    public void testEmptyCacheBehavior() {
        MRUCache<Integer, Integer> mruCache = new MRUCache<>(SIZE);

        assertNull(mruCache.get(1));
        assertNull(mruCache.get(100));

        mruCache.put(1, 10);
        assertEquals(10, mruCache.get(1));
    }
}
