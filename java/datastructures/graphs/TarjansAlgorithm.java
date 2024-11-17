package com.thealgorithms.datastructures.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TarjansAlgorithm {

    private int time;

    private final List<List<Integer>> sccList = new ArrayList<>();

    public List<List<Integer>> stronglyConnectedComponents(int v, List<List<Integer>> graph) {
        
        int[] lowTime = new int[v];
        int[] insertionTime = new int[v];
        for (int i = 0; i < v; i++) {
            insertionTime[i] = -1;
            lowTime[i] = -1;
        }

        boolean[] isInStack = new boolean[v];

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < v; i++) {
            if (insertionTime[i] == -1) {
                stronglyConnCompsUtil(i, lowTime, insertionTime, isInStack, st, graph);
            }
        }

        return sccList;
    }

    private void stronglyConnCompsUtil(int u, int[] lowTime, int[] insertionTime, boolean[] isInStack, Stack<Integer> st, List<List<Integer>> graph) {
        
        insertionTime[u] = time;
        lowTime[u] = time;
        time++;

        isInStack[u] = true;
        st.push(u);

        for (Integer vertex : graph.get(u)) {
            if (insertionTime[vertex] == -1) {
                stronglyConnCompsUtil(vertex, lowTime, insertionTime, isInStack, st, graph);
                
                lowTime[u] = Math.min(lowTime[u], lowTime[vertex]);
            } else if (isInStack[vertex]) {
                
                lowTime[u] = Math.min(lowTime[u], insertionTime[vertex]);
            }
        }

        if (lowTime[u] == insertionTime[u]) {
            int w = -1;
            List<Integer> scc = new ArrayList<>();

            while (w != u) {
                w = st.pop();
                scc.add(w);
                isInStack[w] = false;
            }
            sccList.add(scc);
        }
    }
}
