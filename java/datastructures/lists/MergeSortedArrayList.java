package com.thealgorithms.datastructures.lists;

import java.util.Collection;
import java.util.List;

public final class MergeSortedArrayList {

    private MergeSortedArrayList() {
    }

    public static void merge(List<Integer> listA, List<Integer> listB, Collection<Integer> listC) {
        if (listA == null || listB == null || listC == null) {
            throw new NullPointerException("Input lists and result collection must not be null.");
        }

        int pa = 0;
        int pb = 0;

        while (pa < listA.size() && pb < listB.size()) {
            if (listA.get(pa) <= listB.get(pb)) {
                listC.add(listA.get(pa++));
            } else {
                listC.add(listB.get(pb++));
            }
        }

        while (pa < listA.size()) {
            listC.add(listA.get(pa++));
        }
        
        while (pb < listB.size()) {
            listC.add(listB.get(pb++));
        }
    }
}
