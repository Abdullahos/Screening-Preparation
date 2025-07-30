package algorithms.graph;

public class DisjointSet {

    int[] parent;
    int[] rank;

    public DisjointSet(int n) {
        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]); //updating as dp instead of going all the way up every time
    }

    public  boolean union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);

        if (parentA == parentB) {
            return false;
        }

        if (rank[parentA] < rank[parentB]) {
            parent[parentA] = parentB;
        } else if (rank[parentA] > rank[parentB]) {
            parent[parentB] = parentA;
        } else {
            parent[parentB] = parentA;
            rank[parentA]++;
        }

        parent[parentA] = parentB;

        return true;
    }

}

/**
 * to study: https://www.geeksforgeeks.org/dsa/kruskals-minimum-spanning-tree-algorithm-greedy-algo-2/
 * to practice: https://leetcode.com/contest/weekly-contest-458/problems/minimize-maximum-component-cost/
 */
