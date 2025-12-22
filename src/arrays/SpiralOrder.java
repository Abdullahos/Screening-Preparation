package arrays;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/spiral-matrix/?envType=problem-list-v2&envId=55vr69d7
public class SpiralOrder {
  //t: O(n * m), s: O(n * m)
  public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> spiralRep = new ArrayList<>();

    int n = matrix.length, m = matrix[0].length;

    boolean[][] visited = new boolean[n][m];

    visited[0][0] = true;
    spiralRep.add(matrix[0][0]);

    constructSpiralRep(matrix, spiralRep, visited, n, m, 0, 0);

    return spiralRep;
  }

  private void constructSpiralRep(
      int[][] matrix, List<Integer> spiralRep, boolean[][] visited, int n, int m, int i, int j) {
    int visitedCount = 1;
    while (visitedCount < n * m) {
      while (i - 1 >= 0 && !visited[i - 1][j]) {
        i--;
        visited[i][j] = true;
        spiralRep.add(matrix[i][j]);
        visitedCount++;
      }
      while (j + 1 < m && !visited[i][j + 1]) {
        j++;
        visited[i][j] = true;
        spiralRep.add(matrix[i][j]);
        visitedCount++;
      }
      while (i + 1 < n && !visited[i + 1][j]) {
        i++;
        visited[i][j] = true;
        spiralRep.add(matrix[i][j]);
        visitedCount++;
      }
      while (j - 1 >= 0 && !visited[i][j - 1]) {
        j--;
        visited[i][j] = true;
        spiralRep.add(matrix[i][j]);
        visitedCount++;
      }
    }
  }
}
