package com.thealgorithms.others;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

class BestFitCPUTest {

    int[] sizeOfBlocks;
    int[] sizeOfProcesses;
    ArrayList<Integer> memAllocation = new ArrayList<>();
    ArrayList<Integer> testMemAllocation;
    MemoryManagementAlgorithms bestFit = new BestFitCPU();

    @Test
    void testFitForUseOfOneBlock() {
        
        sizeOfBlocks = new int[] {5, 12, 17, 10};
        sizeOfProcesses = new int[] {10, 5, 15, 2};
        memAllocation = bestFit.fitProcess(sizeOfBlocks, sizeOfProcesses);
        testMemAllocation = new ArrayList<>(Arrays.asList(3, 0, 2, 2));
        assertEquals(testMemAllocation, memAllocation);
    }

    @Test
    void testFitForEqualProcecesses() {
        
        sizeOfBlocks = new int[] {5, 12, 17, 10};
        sizeOfProcesses = new int[] {10, 10, 10, 10};
        memAllocation = bestFit.fitProcess(sizeOfBlocks, sizeOfProcesses);
        testMemAllocation = new ArrayList<>(Arrays.asList(3, 1, 2, -255));
        assertEquals(testMemAllocation, memAllocation);
    }

    @Test
    void testFitForNoEmptyBlockCell() {
        
        sizeOfBlocks = new int[] {5, 12, 17};
        sizeOfProcesses = new int[] {5, 12, 10, 7};
        memAllocation = bestFit.fitProcess(sizeOfBlocks, sizeOfProcesses);
        testMemAllocation = new ArrayList<>(Arrays.asList(0, 1, 2, 2));
        assertEquals(testMemAllocation, memAllocation);
    }

    @Test
    void testFitForSameInputDifferentQuery() {
        
        sizeOfBlocks = new int[] {5, 12, 17};
        sizeOfProcesses = new int[] {5, 7, 10, 12};
        memAllocation = bestFit.fitProcess(sizeOfBlocks, sizeOfProcesses);
        testMemAllocation = new ArrayList<>(Arrays.asList(0, 1, 2, -255));
        assertEquals(testMemAllocation, memAllocation);
    }

    @Test
    void testFitForMoreBlocksNoFit() {
        
        sizeOfBlocks = new int[] {5, 4, -1, 3, 6};
        sizeOfProcesses = new int[] {10, 11};
        memAllocation = bestFit.fitProcess(sizeOfBlocks, sizeOfProcesses);
        testMemAllocation = new ArrayList<>(Arrays.asList(-255, -255));
        assertEquals(testMemAllocation, memAllocation);
    }
}
