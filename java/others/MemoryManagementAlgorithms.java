package com.thealgorithms.others;

import java.util.ArrayList;

public abstract class MemoryManagementAlgorithms {

    public abstract ArrayList<Integer> fitProcess(int[] sizeOfBlocks, int[] sizeOfProcesses);

    protected static final int NO_ALLOCATION = -255;
}

class BestFitCPU extends MemoryManagementAlgorithms {

    private static int findMaxElement(int[] array) {
        int max = -1;
        for (int value : array) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    private static int findBestFit(int[] blockSizes, int processSize) {
        
        int minDiff = findMaxElement(blockSizes);
        int index = NO_ALLOCATION; 
                                   
        for (int i = 0; i < blockSizes.length; i++) { 
            if (blockSizes[i] - processSize < minDiff && blockSizes[i] - processSize >= 0) {
                minDiff = blockSizes[i] - processSize;
                index = i;
            }
        }
        return index;
    }

    public ArrayList<Integer> fitProcess(int[] sizeOfBlocks, int[] sizeOfProcesses) {
        
        ArrayList<Integer> memAlloc = new ArrayList<>();
        
        for (int processSize : sizeOfProcesses) {
            int chosenBlockIdx = findBestFit(sizeOfBlocks, processSize); 
            memAlloc.add(chosenBlockIdx); 
            if (chosenBlockIdx != NO_ALLOCATION) { 
                sizeOfBlocks[chosenBlockIdx] -= processSize; 
            }
        }
        return memAlloc;
    }
}

class WorstFitCPU extends MemoryManagementAlgorithms {

    private static int findWorstFit(int[] blockSizes, int processSize) {
        int max = -1;
        int index = -1;
        for (int i = 0; i < blockSizes.length; i++) { 
            if (blockSizes[i] > max) {
                max = blockSizes[i];
                index = i;
            }
        }
        
        if (processSize > blockSizes[index]) {
            return NO_ALLOCATION;
        }
        return index;
    }

    public ArrayList<Integer> fitProcess(int[] sizeOfBlocks, int[] sizeOfProcesses) {
        
        ArrayList<Integer> memAlloc = new ArrayList<>();
        
        for (int processSize : sizeOfProcesses) {
            int chosenBlockIdx = findWorstFit(sizeOfBlocks, processSize); 
            memAlloc.add(chosenBlockIdx); 
            if (chosenBlockIdx != NO_ALLOCATION) { 
                sizeOfBlocks[chosenBlockIdx] -= processSize; 
            }
        }
        return memAlloc;
    }
}

class FirstFitCPU extends MemoryManagementAlgorithms {

    private static int findFirstFit(int[] blockSizes, int processSize) {
        for (int i = 0; i < blockSizes.length; i++) {
            if (blockSizes[i] >= processSize) {
                return i;
            }
        }
        
        return NO_ALLOCATION;
    }

    public ArrayList<Integer> fitProcess(int[] sizeOfBlocks, int[] sizeOfProcesses) {
        
        ArrayList<Integer> memAlloc = new ArrayList<>();
        
        for (int processSize : sizeOfProcesses) {
            int chosenBlockIdx = findFirstFit(sizeOfBlocks, processSize); 
            memAlloc.add(chosenBlockIdx); 
            if (chosenBlockIdx != NO_ALLOCATION) { 
                sizeOfBlocks[chosenBlockIdx] -= processSize; 
            }
        }
        return memAlloc;
    }
}

class NextFit extends MemoryManagementAlgorithms {

    private int counter = 0; 

    private int findNextFit(int[] blockSizes, int processSize) {
        for (int i = 0; i < blockSizes.length; i++) {
            if (counter + i >= blockSizes.length) {
                counter = -i; 
            }
            if (blockSizes[i + counter] >= processSize) {
                counter += i;
                return counter;
            }
        }
        
        counter += blockSizes.length; 
        return NO_ALLOCATION;
    }

    public ArrayList<Integer> fitProcess(int[] sizeOfBlocks, int[] sizeOfProcesses) {
        
        ArrayList<Integer> memAlloc = new ArrayList<>();
        
        for (int processSize : sizeOfProcesses) {
            int chosenBlockIdx = findNextFit(sizeOfBlocks, processSize); 
            memAlloc.add(chosenBlockIdx); 
            if (chosenBlockIdx != NO_ALLOCATION) { 
                sizeOfBlocks[chosenBlockIdx] -= processSize; 
            }
        }
        return memAlloc;
    }
}
