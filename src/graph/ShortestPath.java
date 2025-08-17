package graph;

import java.util.*;

public class ShortestPath {

    //More Generic Solution, if nodes has different costs
    class Solution {
        public int shortestPathBinaryMatrix(int[][] grid) {
            int n = grid.length;

            Queue<Path> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.counts));
            pq.offer(new Path(0, 0, 1));

            int[][] dirs = new int[][] {
                    {0, 1},
                    {0, -1},
                    {1, 0},
                    {-1, 0},
                    {1,1},
                    {1,-1},
                    {-1,1},
                    {-1,-1}
            };

            int[][] dp = new int[n][n];
            for (int[] d : dp) {
                Arrays.fill(d, Integer.MAX_VALUE);
            }

            while (!pq.isEmpty()) {
                Path path = pq.remove();
                int x = path.x, y = path.y, counts = path.counts;

                if (grid[x][y] == 1 || dp[x][y] <= counts) {
                    continue;
                }

                dp[x][y] = counts;

                if (x == n - 1 && y == n - 1) {
                    return counts;
                }

                for (int[] dir : dirs) {
                    int newX = x + dir[0], newY = y + dir[1];

                    if (newX < 0 || newX == n || newY < 0 || newY == n || grid[newX][newY] == 1) continue;

                    pq.offer(new Path(newX, newY, counts + 1));
                }

            }

            return -1;

        }

        class Path {
            int x, y;
            int counts;

            public Path(int x, int y, int counts) {
                this.x = x;
                this.y = y;
                this.counts = counts;
            }
        }
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        Queue<Path> pq = new LinkedList<>();
        pq.offer(new Path(0, 0, 1));

        int[][] costs = new int[n][n];

        int[][] dirs = new int[][] {
                {0, 1},
                {0, -1},
                {1, 0},
                {-1, 0},
                {1,1},
                {1,-1},
                {-1,1},
                {-1,-1}
        };


        while (!pq.isEmpty()) {
            Path path = pq.remove();
            int x = path.x, y = path.y, counts = path.counts;

            if (grid[x][y] != 0 || costs[x][y] > 0) {
                continue;
            }

            costs[x][y] = counts;

            if (x == n - 1 && y == n - 1) {
                return counts;
            }

            for (int[] dir : dirs) {
                int newX = x + dir[0], newY = y + dir[1];

                if (newX < 0 || newX == n || newY < 0 || newY == n || grid[newX][newY] != 0) continue;

                pq.offer(new Path(newX, newY, counts + 1));
            }

        }

        return -1;

    }

    class Path {
        int x, y, counts;

        public Path(int x, int y, int counts) {
            this.x = x;
            this.y = y;
            this.counts = counts;
        }
    }
}
