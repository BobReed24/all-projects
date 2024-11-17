package com.thealgorithms.datastructures.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public final class EdmondsBlossomAlgorithm {

    private EdmondsBlossomAlgorithm() {
    }

    private static final int UNMATCHED = -1; 

    public static List<int[]> maximumMatching(Iterable<int[]> edges, int vertexCount) {
        List<List<Integer>> graph = new ArrayList<>(vertexCount);

        for (int i = 0; i < vertexCount; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int[] match = new int[vertexCount];
        Arrays.fill(match, UNMATCHED); 
        int[] parent = new int[vertexCount];
        int[] base = new int[vertexCount];
        boolean[] inBlossom = new boolean[vertexCount]; 
        boolean[] inQueue = new boolean[vertexCount]; 

        for (int u = 0; u < vertexCount; u++) {
            if (match[u] == UNMATCHED) {
                
                Arrays.fill(parent, UNMATCHED);
                for (int i = 0; i < vertexCount; i++) {
                    base[i] = i; 
                }
                Arrays.fill(inBlossom, false);
                Arrays.fill(inQueue, false);

                Queue<Integer> queue = new LinkedList<>();
                queue.add(u);
                inQueue[u] = true;

                boolean augmentingPathFound = false;

                while (!queue.isEmpty() && !augmentingPathFound) {
                    int current = queue.poll(); 
                    for (int y : graph.get(current)) {
                        
                        if (match[current] == y) {
                            continue;
                        }

                        if (base[current] == base[y]) {
                            continue; 
                        }

                        if (parent[y] == UNMATCHED) {
                            
                            if (match[y] == UNMATCHED) {
                                parent[y] = current;
                                augmentingPathFound = true;
                                updateMatching(match, parent, y); 
                                break;
                            }

                            int z = match[y];
                            parent[y] = current;
                            parent[z] = y;
                            if (!inQueue[z]) {
                                queue.add(z);
                                inQueue[z] = true;
                            }
                        } else {
                            
                            int baseU = findBase(base, parent, current, y);
                            if (baseU != UNMATCHED) {
                                contractBlossom(new BlossomData(new BlossomAuxData(queue, parent, base, inBlossom, match, inQueue), current, y, baseU));
                            }
                        }
                    }
                }
            }
        }

        List<int[]> matchingResult = new ArrayList<>();
        for (int v = 0; v < vertexCount; v++) {
            if (match[v] != UNMATCHED && v < match[v]) {
                matchingResult.add(new int[] {v, match[v]});
            }
        }

        return matchingResult;
    }

    private static void updateMatching(int[] match, int[] parent, int u) {
        while (u != UNMATCHED) {
            int v = parent[u];
            int next = match[v];
            match[v] = u;
            match[u] = v;
            u = next;
        }
    }

    private static int findBase(int[] base, int[] parent, int u, int v) {
        boolean[] visited = new boolean[base.length];

        int currentU = u;
        while (true) {
            currentU = base[currentU]; 
            visited[currentU] = true;
            if (parent[currentU] == UNMATCHED) {
                break;
            }
            currentU = parent[currentU]; 
        }

        int currentV = v;
        while (true) {
            currentV = base[currentV]; 
            if (visited[currentV]) {
                return currentV;
            }
            currentV = parent[currentV]; 
        }
    }

    private static void contractBlossom(BlossomData blossomData) {
        for (int x = blossomData.u; blossomData.auxData.base[x] != blossomData.lca; x = blossomData.auxData.parent[blossomData.auxData.match[x]]) {
            int baseX = blossomData.auxData.base[x];
            int matchBaseX = blossomData.auxData.base[blossomData.auxData.match[x]];

            blossomData.auxData.inBlossom[baseX] = true;
            blossomData.auxData.inBlossom[matchBaseX] = true;
        }

        for (int x = blossomData.v; blossomData.auxData.base[x] != blossomData.lca; x = blossomData.auxData.parent[blossomData.auxData.match[x]]) {
            int baseX = blossomData.auxData.base[x];
            int matchBaseX = blossomData.auxData.base[blossomData.auxData.match[x]];

            blossomData.auxData.inBlossom[baseX] = true;
            blossomData.auxData.inBlossom[matchBaseX] = true;
        }

        for (int i = 0; i < blossomData.auxData.base.length; i++) {
            if (blossomData.auxData.inBlossom[blossomData.auxData.base[i]]) {
                blossomData.auxData.base[i] = blossomData.lca; 
                if (!blossomData.auxData.inQueue[i]) {
                    blossomData.auxData.queue.add(i); 
                    blossomData.auxData.inQueue[i] = true;
                }
            }
        }
    }

    static class BlossomAuxData {
        Queue<Integer> queue; 
        int[] parent; 
        int[] base; 
        boolean[] inBlossom; 
        int[] match; 
        boolean[] inQueue; 

        BlossomAuxData(Queue<Integer> queue, int[] parent, int[] base, boolean[] inBlossom, int[] match, boolean[] inQueue) {
            this.queue = queue;
            this.parent = parent;
            this.base = base;
            this.inBlossom = inBlossom;
            this.match = match;
            this.inQueue = inQueue;
        }
    }

    static class BlossomData {
        BlossomAuxData auxData; 
        int u; 
        int v; 
        int lca; 

        BlossomData(BlossomAuxData auxData, int u, int v, int lca) {
            this.auxData = auxData;
            this.u = u;
            this.v = v;
            this.lca = lca;
        }
    }
}
