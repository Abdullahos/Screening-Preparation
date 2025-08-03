package graph;

import java.util.*;

public class PathWithMaxProb {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<Node>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            graph.get(edge[0]).add(new Node(edge[1], succProb[i]));
            graph.get(edge[1]).add(new Node(edge[0], succProb[i]));
        }

        Queue<Node> pq = new PriorityQueue<>((a, b) -> Double.compare(b.prob, a.prob));

        pq.offer(new Node(start_node, 1.0));    //to, prob

        double[] maxProb = new double[n];
        Arrays.fill(maxProb, -1);

        while (!pq.isEmpty()) {
            Node node = pq.remove();

            int u = node.u;
            double w = node.prob;

            if (u == end_node) {
                return w;
            }

            if (maxProb[u] >= w) {
                continue;
            }

            maxProb[u] = w;

            for (Node mapping : graph.get(u)) {
                double accProb = w * mapping.prob;
                if (maxProb[mapping.u] < accProb) {
                    pq.offer(new Node(mapping.u, accProb));
                }
            }

        }

        return 0;
    }

    class Node {
        int u;
        double prob;

        public Node(int u, double prob) {
            this.u = u;
            this.prob = prob;
        }
    }

    public static void main(String[] args) {
        PathWithMaxProb path = new PathWithMaxProb();

        int[][] arr = new int[][]{
                {0, 1},
                {1, 2},
                {0, 2}
        };

        double[] successProb = new double[]{0.5, 0.5, 0.2};

        path.maxProbability(3, arr, successProb, 0, 2);

    }
}
