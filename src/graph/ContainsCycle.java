package graph;

public class ContainsCycle {
    public boolean containsCycle(char[][] grid) {
        int n = grid.length, m = grid[0].length;

        boolean isCycle = false;
        boolean[][] noCycleDp = new boolean[n][m];
        boolean[][] visited = new boolean[n][m];

        int[][] dirs = new int[][]{
                {0, 1},
                {0, -1},
                {1, 0},
                {-1, 0}
        };

        outerloop:
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < m; y++) {
                isCycle = dfs(grid, visited, n, m, 0, 0, x, y, true, noCycleDp, dirs);
                if (isCycle) {
                    break outerloop;
                }
            }
        }

        return isCycle;
    }

    private boolean dfs(char[][] grid, boolean[][] visited, int n, int m, int srcX, int srcY, int x, int y,
                        boolean noSrc, boolean[][] dp, int[][] dirs) {
        if (dp[x][y]) {
            return false;
        }

        if (visited[x][y]) {
            return true;
        }

        visited[x][y] = true;

        boolean isCycle = false;

        for (int[] dir : dirs) {
            int newX = x + dir[0];
            int newY = y + dir[1];

            if (newX >= 0 && newX < n && newY >= 0 && newY < m && grid[newX][newY] == grid[x][y]
                    && (noSrc || (newX != srcX || newY != srcY))) {
                isCycle = dfs(grid, visited, n, m, x, y, newX, newY, false, dp, dirs);
                if (isCycle) {
                    break;
                }
            }
        }

        dp[x][y] = !isCycle;

        return isCycle;
    }

    public static void main(String[] args) {
        ContainsCycle cycle = new ContainsCycle();
        char[][] grid = {
                {'f', 'a', 'a', 'c', 'b'},
                {'e', 'a', 'a', 'e', 'c'},
                {'c', 'f', 'b', 'b', 'b'},
                {'c', 'e', 'a', 'b', 'e'},
                {'f', 'e', 'f', 'b', 'f'}
        };
        System.out.println(cycle.containsCycle(grid));
    }
}
