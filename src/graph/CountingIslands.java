package graph;

public class CountingIslands {

    public int countIslands(char[][] grid) {
        int h = grid.length;
        int w = grid[0].length;
        boolean[][] visited = new boolean[h][w];
        int counts = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    countDfs(grid, i, j, h, w, visited);
                    counts++;
                }
            }
        }
        return counts;
    }

    private void countDfs(char[][] grid, int r, int c, int h, int w, boolean[][] visited) {
        if (r == grid.length || c == grid[0].length || r == -1 || c == -1 || grid[r][c] == '0' || visited[r][c]) {
            return;
        }
        visited[r][c] = true;
        countDfs(grid, r - 1, c, h, w, visited);
        countDfs(grid, r + 1, c, h, w, visited);
        countDfs(grid, r, c - 1, h, w, visited);
        countDfs(grid, r, c + 1, h, w, visited);
    }

}
