package bfs;

import java.util.*;

public class PacificAtlantic {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        List<List<Integer>> res = new ArrayList<>();
        int n = heights.length, m = heights[0].length;

        boolean[][] visited_P = new boolean[n][m];
        boolean[][] visited_A = new boolean[n][m];

        Queue<Integer[]> p_q = new LinkedList<>();
        Queue<Integer[]> a_q = new LinkedList<>();

        //pacific
        for (int i = 0; i < n; i++){
            p_q.add(new Integer[] {i, 0});
            visited_P[i][0] = true;
        }

        for (int j = 1; j < m; j++) {
            p_q.add(new Integer[] {0, j});
            visited_P[0][j] = true;
        }

        //atlantic
        for (int i = 0; i < n; i++){
            a_q.add(new Integer[] {i, m - 1});
            visited_A[i][m - 1] = true;
        }

        for (int j = 0; j < m - 1; j++){
            a_q.add(new Integer[] {n - 1, j});
            visited_A[n - 1][j] = true;
        }

        bfs(p_q, visited_P, n, m, heights);
        bfs(a_q, visited_A, n, m, heights);


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited_P[i][j] && visited_A[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }

        return res;
    }

    private void bfs(Queue<Integer[]> q, boolean[][] visited, int n, int m, int[][] heights) {
        int[][] dirs = new int[][] {{0,1}, {0,-1}, {1,0}, {-1,0}};
        while (!q.isEmpty()) {

            Integer[] cell = q.remove();
            int i = cell[0], j = cell[1];

            for (int[] d : dirs) {
                int di = d[0], dj = d[1];
                if (i + di >= 0 && i + di < n && j + dj >= 0 && j + dj < m && !visited[i + di][j + dj] && heights[i][j] <= heights[i +  di][j + dj]) {
                    visited[i +  di][j + dj] = true;
                    q.add(new Integer[]{i +  di, j + dj});
                }
            }


        }
    }
}
