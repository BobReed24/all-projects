package com.thealgorithms.datastructures.hashmap.hashing;

import java.util.Objects;

public class HashMapCuckooHashing {

    private int tableSize; 
    private Integer[] buckets; 
    private final Integer emptySlot; 
    private int size; 
    private int thresh; 

    public HashMapCuckooHashing(int tableSize) {
        this.buckets = new Integer[tableSize];
        this.tableSize = tableSize;
        this.emptySlot = Integer.MIN_VALUE;
        this.size = 0;
        this.thresh = (int) (Math.log(tableSize) / Math.log(2)) + 2;
    }

    public int hashFunction1(int key) {
        int hash = key % tableSize;
        if (hash < 0) {
            hash += tableSize;
        }
        return hash;
    }

    public int hashFunction2(int key) {
        int hash = key / tableSize;
        hash %= tableSize;
        if (hash < 0) {
            hash += tableSize;
        }
        return hash;
    }

    public void insertKey2HashTable(int key) {
        Integer wrappedInt = key;
        Integer temp;
        int hash;
        int loopCounter = 0;

        if (isFull()) {
            System.out.println("Hash table is full, lengthening & rehashing table");
            reHashTableIncreasesTableSize();
        }

        if (checkTableContainsKey(key)) {
            throw new IllegalArgumentException("Key already exists; duplicates are not allowed.");
        }

        while (loopCounter <= thresh) {
            loopCounter++;
            hash = hashFunction1(key);

            if ((buckets[hash] == null) || Objects.equals(buckets[hash], emptySlot)) {
                buckets[hash] = wrappedInt;
                size++;
                checkLoadFactor();
                return;
            }

            temp = buckets[hash];
            buckets[hash] = wrappedInt;
            wrappedInt = temp;
            hash = hashFunction2(temp);
            if (Objects.equals(buckets[hash], emptySlot)) {
                buckets[hash] = wrappedInt;
                size++;
                checkLoadFactor();
                return;
            } else if (buckets[hash] == null) {
                buckets[hash] = wrappedInt;
                size++;
                checkLoadFactor();
                return;
            }

            temp = buckets[hash];
            buckets[hash] = wrappedInt;
            wrappedInt = temp;
        }
        System.out.println("Infinite loop occurred, lengthening & rehashing table");
        reHashTableIncreasesTableSize();
        insertKey2HashTable(key);
    }

    public void reHashTableIncreasesTableSize() {
        HashMapCuckooHashing newT = new HashMapCuckooHashing(tableSize * 2);
        for (int i = 0; i < tableSize; i++) {
            if (buckets[i] != null && !Objects.equals(buckets[i], emptySlot)) {
                newT.insertKey2HashTable(this.buckets[i]);
            }
        }
        this.tableSize *= 2;
        this.buckets = newT.buckets;
        this.thresh = (int) (Math.log(tableSize) / Math.log(2)) + 2;
    }

    public void deleteKeyFromHashTable(int key) {
        Integer wrappedInt = key;
        int hash = hashFunction1(key);
        if (isEmpty()) {
            throw new IllegalArgumentException("Table is empty, cannot delete.");
        }

        if (Objects.equals(buckets[hash], wrappedInt)) {
            buckets[hash] = emptySlot;
            size--;
            return;
        }

        hash = hashFunction2(key);
        if (Objects.equals(buckets[hash], wrappedInt)) {
            buckets[hash] = emptySlot;
            size--;
            return;
        }
        throw new IllegalArgumentException("Key " + key + " not found in the table.");
    }

    public void displayHashtable() {
        for (int i = 0; i < tableSize; i++) {
            if ((buckets[i] == null) || Objects.equals(buckets[i], emptySlot)) {
                System.out.println("Bucket " + i + ": Empty");
            } else {
                System.out.println("Bucket " + i + ": " + buckets[i].toString());
            }
        }
        System.out.println();
    }

    public int findKeyInTable(int key) {
        Integer wrappedInt = key;
        int hash = hashFunction1(key);

        if (isEmpty()) {
            throw new IllegalArgumentException("Table is empty; cannot find keys.");
        }

        if (Objects.equals(buckets[hash], wrappedInt)) {
            return hash;
        }

        hash = hashFunction2(key);
        if (!Objects.equals(buckets[hash], wrappedInt)) {
            throw new IllegalArgumentException("Key " + key + " not found in the table.");
        } else {
            return hash;
        }
    }

    public boolean checkTableContainsKey(int key) {
        return ((buckets[hashFunction1(key)] != null && buckets[hashFunction1(key)].equals(key)) || (buckets[hashFunction2(key)] != null && buckets[hashFunction2(key)].equals(key)));
    }

    public double checkLoadFactor() {
        double factor = (double) size / tableSize;
        if (factor > .7) {
            System.out.printf("Load factor is %.2f, rehashing table.%n", factor);
            reHashTableIncreasesTableSize();
        }
        return factor;
    }

    public boolean isFull() {
        for (int i = 0; i < tableSize; i++) {
            if (buckets[i] == null || Objects.equals(buckets[i], emptySlot)) {
                return false;
            }
        }
        return true;
    }

    public boolean isEmpty() {
        for (int i = 0; i < tableSize; i++) {
            if (buckets[i] != null) {
                return false;
            }
        }
        return true;
    }

    public int getNumberOfKeysInTable() {
        return size;
    }
}
