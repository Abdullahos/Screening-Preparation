package algorithms.graph;

import java.util.*;

public class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<int[]> vertexs = new ArrayList<>();
        Map<String, Integer> map = new HashMap();
        int labels = 0;

        for (int[] point : points) {
            for (int j = 0; j < n; j++) {
                String key = point[0] + "," + point[1];
                map.put(key, labels);
                labels++;
            }
        }

        for (int i = 0; i < n - 1; i++) {
            int xi = points[i][0];
            int yi = points[i][1];
            for (int j = i + 1; j < n; j++) {
                int xj = points[j][0];
                int yj = points[j][1];
                int w = Math.abs(xi - xj) + Math.abs(yi - yj);

                int[] v = new int[] {map.get(xi + "," + yi), map.get(xj + "," + yj), w};
                vertexs.add(v);
            }
        }

        vertexs.sort(Comparator.comparingInt(arr -> arr[2]));

        DisJointSet disJoinSet = new DisJointSet(labels + 1);
        int minCost = 0;
        int idx = 0;
        int counts = 0;

        while (counts < n - 1 && idx < vertexs.size()) {
            int[] v = vertexs.get(idx);
            if (disJoinSet.union(v[0], v[1])) {
                minCost += v[2];
                counts++;
            }
            idx++;
        }

        return minCost;


    }

    class DisJointSet {
        int[] parent;

        public DisJointSet(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int find(int x) {
            if (parent[x] == x) {
                return x;
            }
            return parent[x] = find(parent[x]);
        }

        boolean union(int a, int b) {
            int parentA = find(a), parentB = find(b);

            if (parentA == parentB) {
                return false;
            }

            parent[parentA] = parentB;
            return true;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] vertex = new int[][]{{0,0},{2,2},{3,10},{5,2},{7,0}};
        int[][] vertex2 = new int[][] {{3,12},{-2,5},{-4,1}};
        System.out.println(solution.minCostConnectPoints(vertex));
        System.out.println(solution.minCostConnectPoints(vertex2));
    }
}