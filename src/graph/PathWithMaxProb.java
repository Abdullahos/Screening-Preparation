package graph;

import java.util.*;

public class PathWithMaxProb {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        Map<Integer, List<double[]>> graph = new HashMap<>();

        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            graph.computeIfAbsent(edge[0], a -> new ArrayList<>()).add(new double[]{edge[1], succProb[i]});
            graph.computeIfAbsent(edge[1], a -> new ArrayList<>()).add(new double[]{edge[0], succProb[i]});
        }

        Queue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[2], a[2]));

        pq.offer(new double[]{start_node, start_node, 1.0});    //from, to, prob

        double[] visited = new double[n];
        Arrays.fill(visited, -1);

        while (!pq.isEmpty()) {
            double[] e = pq.remove();

            int u = (int) e[0];
            int v = (int) e[1];
            double w = e[2];

            if (v == end_node) {
                return w;
            }

            if (visited[v] >= w) {
                continue;
            }

            visited[v] = w;

            if (!graph.containsKey(v)) {
                continue;
            }

            for (double[] mapping : graph.get(v)) {
                if (mapping[0] != u) {
                    pq.offer(new double[]{v, mapping[0], w * mapping[1]});
                }
            }

        }

        return 0;
    }

    public static void main(String[] args) {
        PathWithMaxProb path = new PathWithMaxProb();

        int[][] arr = new int[][]{
                {0, 1},
                {1, 2},
                {0, 2}
        };

        double[] successProb = new double[]{0.5,0.5,0.2};

        path.maxProbability(3, arr, successProb, 0, 2);

    }
}
