package com.thealgorithms.searches;

class InterpolationSearch {

    public int find(int[] array, int key) {
        
        int start = 0;
        int end = (array.length - 1);

        while (start <= end && key >= array[start] && key <= array[end]) {
            
            int pos = start + (((end - start) / (array[end] - array[start])) * (key - array[start]));

            if (array[pos] == key) {
                return pos;
            }

            if (array[pos] < key) {
                start = pos + 1;
            } 
            else {
                end = pos - 1;
            }
        }
        return -1;
    }
}
