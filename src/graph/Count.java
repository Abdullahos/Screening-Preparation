package graph;

import java.util.*;

public class Count {
    public int countPaths(int n, int[][] roads) {
        Map<Integer, List<int[]>> graph = new HashMap<>();

        for (int[] road : roads) {
            graph.computeIfAbsent(road[0], a -> new ArrayList<>()).add(new int[] {road[1], road[2]});

            graph.computeIfAbsent(road[1], a -> new ArrayList<>()).add(new int[] {road[0], road[2]});
        }

        int minTime = getMinTimeToReach(0, n - 1, graph);

        return count(0, n - 1, minTime, new HashSet<>(), graph, new int[] {0, 0});

    }

    private int count(int src, int dst, int min, Set<Integer> path, Map<Integer, List<int[]>> graph, int[] curr) {
        int u = curr[0];
        int t = curr[1];

        if (u == dst && t == min) {
            return 1;
        }

        if (t >= min) {
            return 0;
        }

        int counts = 0;

        path.add(u);

        for (int[] mapping : graph.get(u)) {
            if (t + mapping[1] <= min && !path.contains(mapping[0])) {
                counts += count(src, dst, min, path, graph, new int[] {mapping[0], t + mapping[1]});
            }
        }

        path.remove(u);

        return counts;
    }


    private int getMinTimeToReach(int src, int dst, Map<Integer, List<int[]>> graph) {

        Map<Integer, Integer> timeNode = new HashMap<>();

        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        pq.offer(new int[] {src, 0});

        while (!pq.isEmpty()) {
            int[] n = pq.remove();

            int u = n[0];
            int t = n[1];

            if (timeNode.containsKey(u) && timeNode.get(u) <= t) {
                continue;
            }

            if (u == dst) {
                return t;
            }

            timeNode.put(u, t);

            for (int[] mapping : graph.get(u)) {
                if (timeNode.containsKey(mapping[0]) && timeNode.get(mapping[0]) <= mapping[1]) {
                    continue;
                }

                pq.offer(new int[] {mapping[0], t + mapping[1]});
            }
        }

        return Integer.MAX_VALUE;

    }

    public static void main(String[] args) {
        Count c = new Count();
        int[][] arr = {
                {0, 6, 7},
                {0, 1, 2},
                {1, 2, 3},
                {1, 3, 3},
                {6, 3, 3},
                {3, 5, 1},
                {6, 5, 1},
                {2, 5, 1},
                {0, 4, 5},
                {4, 6, 2}
        };
        c.countPaths(7, arr);
    }
}
