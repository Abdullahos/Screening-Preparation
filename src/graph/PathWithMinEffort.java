package graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PathWithMinEffort {
    public int minimumEffortPath(int[][] heights) {

        int n = heights.length, m = heights[0].length;

        Queue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.maxDiffSoFar));

        int[][] dp = new int[n][m];

        for (int[] mem : dp) {
            Arrays.fill(mem, Integer.MAX_VALUE);
        }

        pq.offer(new Node(0, 0, 0));

        int[][] dirs = new int[][] {
                {-1, 0},
                {0, 1},
                {1, 0},
                {0, -1}
        };

        while (!pq.isEmpty()) {
            Node node = pq.remove();

            if (dp[node.i][node.j] <= node.maxDiffSoFar) {
                continue;
            }

            dp[node.i][node.j] = node.maxDiffSoFar;

            if (node.i == n - 1 && node.j == m - 1) {
                return node.maxDiffSoFar;
            }

            for (int[] dir : dirs) {
                int newI = node.i + dir[0], newJ = node.j + dir[1];

                if (newI < 0 || newJ < 0 || newI > n - 1 || newJ >  m - 1) {
                    continue;
                }

                int newMaxSoFar = Math.max(
                        node.maxDiffSoFar,
                        Math.abs(heights[newI][newJ] - heights[node.i][node.j])
                );

                if (dp[newI][newJ] > newMaxSoFar) {
                    pq.offer(
                            new Node(
                                    newI,
                                    newJ,
                                    newMaxSoFar
                            )
                    );
                }
            }
        }

        return dp[n - 1][m - 1];
    }


    class Node {
        int i,j;
        int maxDiffSoFar;

        public Node (int i, int j, int maxDiffSoFar) {
            this.i = i;
            this.j = j;
            this.maxDiffSoFar = maxDiffSoFar;
        }
    }
}
