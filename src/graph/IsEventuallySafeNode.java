package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IsEventuallySafeNode {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;

        Boolean[] safeNodesCache = new Boolean[n];
        List<Integer> safeNodes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (isSafeHelper(graph, i, safeNodesCache, new HashSet<>())) {
                safeNodes.add(i);
            }
        }

        return safeNodes;
    }

    private boolean isSafeHelper(int[][] graph, int i, Boolean[] safeNodesCache, Set<Integer> visited) {
        if (safeNodesCache[i] != null) {
            return safeNodesCache[i];
        }

        if (visited.contains(i)) {
            return false;
        }

        visited.add(i);

        int[] adjs = graph[i];

        for (int adj : adjs) {
            if (!isSafeHelper(graph, adj, safeNodesCache, visited)) {
                safeNodesCache[adj] = false;
                safeNodesCache[i] = false;
                return false;
            }
        }

        visited.remove(i);

        safeNodesCache[i] = true;
        return true;
    }
}
