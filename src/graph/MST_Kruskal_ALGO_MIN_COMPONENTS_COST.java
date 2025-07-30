package graph;

import algorithms.graph.DisjointSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MST_Kruskal_ALGO_MIN_COMPONENTS_COST {

    public int minCost(int n, int[][] edges, int k) {
            Arrays.sort(edges, Comparator.comparingInt(a -> a[2]));

        DisjointSet dsu = new DisjointSet(n);
        List<Integer> mst = new ArrayList<>();

        for (int[] edge : edges) {
            if (dsu.union(edge[0], edge[1])) {
                mst.add(edge[2]);
            }
        }

        for (int i = 1; i < k; i++) {
            mst.removeLast();
        }

        return mst.isEmpty() ? 0 : mst.removeLast();
    }

}
