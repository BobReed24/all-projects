package com.thealgorithms.bitmanipulation;

public final class LowestSetBit {
    
    private LowestSetBit() {
    }
    
    public static int isolateLowestSetBit(int n) {
        
        return n & -n;
    }
    
    public static int clearLowestSetBit(int n) {
        
        return n & (n - 1);
    }
}
