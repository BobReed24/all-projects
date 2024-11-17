package com.thealgorithms.bitmanipulation;

public class CountSetBits {

    public long countSetBits(long num) {
        long cnt = 0;
        while (num > 0) {
            cnt++;
            num &= (num - 1);
        }
        return cnt;
    }

    public int lookupApproach(int num) {
        int[] table = new int[256];
        table[0] = 0;

        for (int i = 1; i < 256; i++) {
            table[i] = (i & 1) + table[i >> 1]; 
        }

        int res = 0;
        for (int i = 0; i < 4; i++) {
            res += table[num & 0xff];
            num >>= 8;
        }

        return res;
    }
}
