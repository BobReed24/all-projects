package com.thealgorithms.datastructures.graphs;

import java.util.ArrayList;
import java.util.Arrays;

public final class BipartiteGraphDFS {
    private BipartiteGraphDFS() {
    }

    private static boolean bipartite(int v, ArrayList<ArrayList<Integer>> adj, int[] color, int node) {
        if (color[node] == -1) {
            color[node] = 1;
        }
        for (Integer it : adj.get(node)) {
            if (color[it] == -1) {
                color[it] = 1 - color[node];
                if (!bipartite(v, adj, color, it)) {
                    return false;
                }
            } else if (color[it] == color[node]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isBipartite(int v, ArrayList<ArrayList<Integer>> adj) {
        int[] color = new int[v + 1];
        Arrays.fill(color, -1);
        for (int i = 0; i < v; i++) {
            if (color[i] == -1) {
                if (!bipartite(v, adj, color, i)) {
                    return false;
                }
            }
        }
        return true;
    }
}
