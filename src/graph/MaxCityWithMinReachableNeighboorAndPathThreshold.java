package graph;

import java.util.*;

public class MaxCityWithMinReachableNeighboorAndPathThreshold {

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // Initialize the graph as an adjacency matrix
        int[][] graph = new int[n][n];

        // Fill the matrix with "infinite" distance
        for (int i = 0; i < n; i++) {
            Arrays.fill(graph[i], Integer.MAX_VALUE);
            graph[i][i] = 0; // distance to itself is zero
        }

        // Fill in the weights from the input edges
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            graph[u][v] = w;
            graph[v][u] = w; // undirected graph
        }

        int min = Integer.MAX_VALUE;
        int city = 0;

        for (int parent = n - 1; parent >= 0; parent--) {
            Set<Integer> reachable = new HashSet<>();
            dfs(graph, parent, distanceThreshold, 0, new boolean[n], reachable);
            if (reachable.size() < min) {
                min = reachable.size();
                city = parent;
            }
        }

        return city;
    }

        void dfs(int[][] graph, int curr, int threshold, int distSoFar, boolean[] visited, Set<Integer> reachable) {
        visited[curr] = true;
        reachable.add(curr);

        for (int neighbor = 0; neighbor < graph.length; neighbor++) {
            if (!visited[neighbor] && graph[curr][neighbor] != Integer.MAX_VALUE && distSoFar + graph[curr][neighbor] <= threshold) {
                dfs(graph, neighbor, threshold, distSoFar + graph[curr][neighbor], visited, reachable);
            } else if (!visited[neighbor] && graph[curr][neighbor] != Integer.MAX_VALUE && distSoFar + graph[curr][neighbor] > threshold) {

            }
        }
        reachable.remove(curr);

        visited[curr] = false;
    }


    class Node {
        int[] edge;
        Set<Integer> visited;

        public Node() {
            edge = new int[4];
            visited = new HashSet<>();
        }

        public Node(int[] edge) {
            this.edge = edge;
            this.visited = new HashSet<>();
        }

        public Node(int[] edge, Set<Integer> visited) {
            this.edge = edge;
            this.visited = new HashSet<>(visited);
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 1, 3},
                {1,2,1},
                {1,3,4},
                {2,3,1}
        };
        MaxCityWithMinReachableNeighboorAndPathThreshold obj = new MaxCityWithMinReachableNeighboorAndPathThreshold();
        obj.findTheCity(4, graph, 2 );
    }
}
