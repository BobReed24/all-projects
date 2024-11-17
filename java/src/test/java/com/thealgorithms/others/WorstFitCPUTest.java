package com.thealgorithms.others;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

class WorstFitCPUTest {

    int[] sizeOfBlocks;
    int[] sizeOfProcesses;
    ArrayList<Integer> memAllocation = new ArrayList<>();
    ArrayList<Integer> testMemAllocation;
    MemoryManagementAlgorithms worstFit = new WorstFitCPU();

    @Test
    void testFitForUseOfOneBlock() {
        
        sizeOfBlocks = new int[] {5, 12, 17, 10};
        sizeOfProcesses = new int[] {10, 5, 15, 2};
        memAllocation = worstFit.fitProcess(sizeOfBlocks, sizeOfProcesses);
        testMemAllocation = new ArrayList<>(Arrays.asList(2, 1, -255, 3));
        assertEquals(testMemAllocation, memAllocation);
    }

    @Test
    void testFitForEqualProcecesses() {
        
        sizeOfBlocks = new int[] {5, 12, 17, 10};
        sizeOfProcesses = new int[] {10, 10, 10, 10};
        memAllocation = worstFit.fitProcess(sizeOfBlocks, sizeOfProcesses);
        testMemAllocation = new ArrayList<>(Arrays.asList(2, 1, 3, -255));
        assertEquals(testMemAllocation, memAllocation);
    }

    @Test
    void testFitForNoEmptyBlockCell() {
        
        sizeOfBlocks = new int[] {5, 12, 17};
        sizeOfProcesses = new int[] {5, 12, 10, 7};
        memAllocation = worstFit.fitProcess(sizeOfBlocks, sizeOfProcesses);
        testMemAllocation = new ArrayList<>(Arrays.asList(2, 1, 2, -255));
        assertEquals(testMemAllocation, memAllocation);
    }

    @Test
    void testFitForSameInputDifferentQuery() {
        
        sizeOfBlocks = new int[] {5, 12, 17};
        sizeOfProcesses = new int[] {5, 7, 10, 12};
        memAllocation = worstFit.fitProcess(sizeOfBlocks, sizeOfProcesses);
        testMemAllocation = new ArrayList<>(Arrays.asList(2, 1, 2, -255));
        assertEquals(testMemAllocation, memAllocation);
    }

    @Test
    void testFitForMoreBlocksNoFit() {
        
        sizeOfBlocks = new int[] {5, 4, -1, 3, 6};
        sizeOfProcesses = new int[] {10, 11};
        memAllocation = worstFit.fitProcess(sizeOfBlocks, sizeOfProcesses);
        testMemAllocation = new ArrayList<>(Arrays.asList(-255, -255));
        assertEquals(testMemAllocation, memAllocation);
    }

    @Test
    void testFitBadCase() {
        
        sizeOfBlocks = new int[] {7, 17, 7, 5, 6};
        sizeOfProcesses = new int[] {8, 10, 10, 8, 8, 8};
        memAllocation = worstFit.fitProcess(sizeOfBlocks, sizeOfProcesses);
        testMemAllocation = new ArrayList<>(Arrays.asList(1, -255, -255, 1, -255, -255));
        assertEquals(testMemAllocation, memAllocation);
    }
}
