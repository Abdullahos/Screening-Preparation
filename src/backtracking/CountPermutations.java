package backtracking;


import java.util.Arrays;

public class CountPermutations {

    int mod = 1_000_000_007;

    public int countPermutations(int[] complexity) {
        int n = complexity.length;

        int[][] dp = new int[1 << n][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return dfs(1, 0, n, complexity, dp) % mod;
    }

    int dfs(int mask, int last, int n, int[] complexity, int[][] dp) {
        if (mask == (1 << n) - 1) {
            return 1;
        }

        if (mask < 0 || mask > (1 << n) - 1) {
            return 0;
        }

        if (dp[mask][last] != -1) {
            return dp[mask][last];
        }

        int minSoFar = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if ((mask & (1 << i)) != 0 && complexity[i] < minSoFar) {
                minSoFar = complexity[i];
            }
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            if ((mask & (1 << i)) == 0 && complexity[i] > minSoFar) {
                count = (count + dfs(mask | (1 << i), i, n, complexity, dp)) % mod;
            }
        }

        dp[mask][last] = count;
        return count;
    }

    public static void main(String[] args) {
        CountPermutations c = new CountPermutations();
        System.out.println(c.countPermutations(new int[]{3470,9997,31628,55082,43915,14129,49183,99427,71495,31577,74287,96625,55548,56522,45502,20407,24812,48500,48200,57692,20660,50351,29619,88947,65929,3471,37527,17931,62499,69198,45737,38605,94241,68261,61653,97116,97217,79694,58943,54248,24192,39712,34398,84847,89541,90309,17607,67739,84663,35600}));
//        System.out.println(c.countPermutations(new int[]{20, 308, 6, 483, 376, 89, 191, 149, 441, 498}));
    }
}
