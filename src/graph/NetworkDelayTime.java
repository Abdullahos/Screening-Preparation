package graph;

import java.util.*;

//https://leetcode.com/problems/network-delay-time/description/
public class NetworkDelayTime {

    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();

        for (int[] time : times) {
            graph.computeIfAbsent(time[0], m -> new ArrayList<>()).add(new int[] {time[0], time[1]});
        }

        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        boolean[] visited = new boolean[n + 1];

        pq.offer(new int[]{k, 0});  //u, cost

        int noOfNodes = 0;

        while (!pq.isEmpty()) {
            int[] e = pq.remove();

            int u = e[0];
            int w = e[1];

            if (visited[u]) {
                continue;
            }

            visited[u] = true;

            if (++noOfNodes == n) {
                return w;
            }

            List<int[]> mapping = graph.get(u);

            if (mapping == null) {
                continue;
            }

            for (int[] m : mapping) {
                if (!visited[m[0]]) {
                    pq.offer(new int[]{m[0], w + m[1]});
                }
            }

        }

        return -1;
    }
}
