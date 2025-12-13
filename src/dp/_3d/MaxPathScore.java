package dp._3d;

import java.util.Arrays;

public class MaxPathScore {
    public int maxPathScore(int[][] grid, int k) {
        int n = grid.length, m = grid[0].length;

        int cost = k;

        int[][][] dp = new int[n][m][k + 1];

        for (int[][] _2d : dp) {
            for (int[] _1d : _2d) {
                Arrays.fill(_1d, -1);
            }
        }

        int maxScore = maxPathScoreDfs(grid, cost, 0, 0, n, m, dp);

        return Math.max(maxScore, -1);
    }

    int maxPathScoreDfs(int[][] grid, int cost, int i, int j, int n, int m, int[][][] dp) {
        if (i >= n || j >= m) return Integer.MIN_VALUE;

        int cur = grid[i][j];

        cost -= cur == 0 ? 0 : 1;

        if (cost < 0) return Integer.MIN_VALUE;

        if (dp[i][j][cost] != -1) return dp[i][j][cost];

        if (i == n - 1 && j == m - 1) return cur;

        int right = maxPathScoreDfs(grid, cost, i + 1, j, n, m, dp);
        int down = maxPathScoreDfs(grid, cost , i, j + 1, n, m, dp);

        int max = Math.max(right, down);

        if (max == Integer.MIN_VALUE) {
            return dp[i][j][cost] = max;
        }

        return dp[i][j][cost] = cur + max;
    }
}
