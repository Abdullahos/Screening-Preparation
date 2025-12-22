package arrays;

// https://leetcode.com/problems/search-a-2d-matrix-ii/?envType=problem-list-v2&envId=55vr69d7
public class Search2dMatrix {
  public boolean searchMatrix(int[][] matrix, int target) {
    int n = matrix.length, m = matrix[0].length;
    boolean[][] visited = new boolean[n][m];
    return search(matrix, target, n, m, 0, 0, visited);
  }

  private boolean search(
      int[][] matrix, int target, int n, int m, int i, int j, boolean[][] visited) {
    if (i < 0 || j < 0 || i == n || j == m || visited[i][j]) {
      return false;
    }

    int curr = matrix[i][j];

    if (curr == target) {
      return true;
    }

    visited[i][j] = true;

    if (curr < target) {
      return search(matrix, target, n, m, i, j + 1, visited)
          || search(matrix, target, n, m, i + 1, j, visited);
    } else {
      return search(matrix, target, n, m, i, j - 1, visited)
          || search(matrix, target, n, m, i - 1, j, visited);
    }
  }
}
