package graph;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinCostConnectPoints {
    public int minCostConnectPoints(int[][] points) {

        int n = points.length;
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        boolean[] visited = new boolean[n];

        pq.offer(new int[] {0,0});

        int edgesUses = 0;
        int minCost = 0;

        while (n > edgesUses) {
            int[] e = pq.remove();

            int w = e[0];
            int u = e[1];

            if (visited[u]) {
                continue;
            }

            minCost += w;

            visited[u] = true;
            edgesUses++;

            //Natural Selection
            for (int v = 0; v < n; v++) {
                if (visited[v]) {
                    continue;
                }
                int d = Math.abs(points[u][0] - points[v][0]) + Math.abs(points[u][1] - points[v][1]);
                pq.offer(new int[] {d, v});
            }
        }

        return minCost;

    }
}
