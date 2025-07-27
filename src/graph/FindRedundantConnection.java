package graph;

//https://leetcode.com/problems/redundant-connection/
import algorithms.graph.DisjointSet;

public class FindRedundantConnection {

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DisjointSet disjoint = new DisjointSet(n + 1);
        int[] redundantConnection = null;

        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];

            if (!disjoint.union(a, b)) {
                redundantConnection = new int[] {a, b};
            }
        }

        return redundantConnection;
    }

}
