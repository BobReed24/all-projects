package com.thealgorithms.others;

import java.util.BitSet;

public final class CRC32 {
    private CRC32() {
    }

    public static void main(String[] args) {
        System.out.println(Integer.toHexString(crc32("Hello World")));
    }

    public static int crc32(String str) {
        return crc32(str.getBytes());
    }

    public static int crc32(byte[] data) {
        BitSet bitSet = BitSet.valueOf(data);
        int crc32 = 0xFFFFFFFF; 
        for (int i = 0; i < data.length * 8; i++) {
            if (((crc32 >>> 31) & 1) != (bitSet.get(i) ? 1 : 0)) {
                crc32 = (crc32 << 1) ^ 0x04C11DB7; 
            } else {
                crc32 = (crc32 << 1);
            }
        }
        crc32 = Integer.reverse(crc32); 
        return crc32 ^ 0xFFFFFFFF; 
    }
}
