package com.thealgorithms.others;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CRCAlgorithmTest {

    @Test
    void test1() {
        CRCAlgorithm c = new CRCAlgorithm("10010101010100101010010000001010010101010", 10, 0.0);

        c.changeMess();
        c.divideMessageWithP(false);
        assertEquals(c.getWrongMess(), 0);
    }

    @Test
    void test2() {
        CRCAlgorithm c = new CRCAlgorithm("10010101010100101010010000001010010101010", 10, 1.0);

        c.changeMess();
        c.divideMessageWithP(false);
        assertEquals(c.getCorrectMess(), 0);
    }
}
