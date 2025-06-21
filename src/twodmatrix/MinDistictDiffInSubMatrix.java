package twodmatrix;

import java.util.*;

public class MinDistictDiffInSubMatrix {

    public int[][] minAbsDiff(int[][] grid, int k) {
        int n = grid.length, m = grid[0].length;
        int[][] answer = new int[n - k + 1][m - k + 1];

        for (int i = 0; i + k <= n; i++) {
            for (int j = 0; j + k <= m; j++) {
                answer[i][j] = getMin(grid, i, j, k);
            }
        }

        return answer;

    }

    int getMin(int[][] grid, int i, int j, int k) {
        Set<Integer> set = new HashSet<Integer>();

        for (int x = i; x < i + k; x++) {
            for (int y = j; y < j + k; y++) {
                set.add(grid[x][y]);
            }
        }

        if (set.size() < 2) {
            return 0;
        }

        int[] arr = new int[set.size()];
        int idx = 0;
        for (Integer integer : set) {
            arr[idx++] = integer;
        }

        Arrays.sort(arr);

        int minDiff = Integer.MAX_VALUE;
        for (idx = 1; idx < arr.length; idx++) {
            minDiff = Math.min(minDiff, arr[idx] - arr[idx - 1]);
        }

        return minDiff;
    }

}
