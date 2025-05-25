package dfs;

import java.util.HashMap;
import java.util.Map;

public class CountingIslands {

    public int numIslands(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        int islandsCounts = 0;

        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    visit(grid, i, j, n, m, visited);
                    islandsCounts++;
                }
            }
        }

        return islandsCounts;
    }

    private void visit(char[][] grid, int i, int j, int n, int m, boolean[][] visited) {
        if (i < 0 || i == n|| j < 0 || j == m || visited[i][j] || grid[i][j] != '1') {
            return;
        }

        visited[i][j] = true;

        int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int[] dir : dirs) {
            int di = dir[0], dj = dir[1];

            visit(grid, i + di, j + dj, n, m, visited);
        }
    }

}
