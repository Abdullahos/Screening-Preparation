package queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MST_Kruskal_ALGO_MIN_COMPONENTS_COST {
    public int minCost(int n, int[][] edges, int k) {
        Arrays.sort(edges, Comparator.comparingInt(a -> a[2]));

        DSU dsu = new DSU(n);
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


    class DSU {
        int[] parent;
        int[] rank;

        public DSU(int n) {
            parent = new int[n];
            rank = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);

            return parent[x];
        }

        boolean union(int a, int b) {
            int aSet = find(a), bSet = find(b);

            if (aSet == bSet) {
                return false;
            }

            if (rank[aSet] < rank[bSet]) {
                parent[aSet] = bSet;
            } else if (rank[aSet] > rank[bSet]) {
                parent[bSet] = aSet;
            } else {
                parent[bSet] = aSet;
                rank[bSet]++;
            }

            return true;
        }
    }
}
