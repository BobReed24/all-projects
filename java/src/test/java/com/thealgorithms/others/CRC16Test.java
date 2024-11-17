package com.thealgorithms.others;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CRC16Test {
    @Test
    void testCRC16() {
        
        String textToCRC16 = "hacktoberfest!";

        String resultCRC16 = CRC16.crc16(textToCRC16); 

        assertEquals("10FC", resultCRC16);
    }
}
