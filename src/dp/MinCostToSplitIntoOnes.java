package dp;

//https://leetcode.com/contest/weekly-contest-491/problems/minimum-cost-to-split-into-ones/
public class MinCostToSplitIntoOnes {
    public int minCost(int n) {
        if (n == 1) {
            return 0;
        }

        if (n == 2) {
            return 1;
        }

        Integer[] dp = new Integer[n + 1];
        dp[0] = Integer.MAX_VALUE;
        dp[1] = 0;
        dp[2] = 1;

        return fn(n, dp);
    }

    private int fn(int n, Integer[] dp) {
        if (dp[n] != null) {
            return dp[n];
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i < n - 1; i++) {
            min = Math.min(min, (i * (n - i) + fn(i, dp) + fn(n - i, dp)));
        }

        return dp[n] = min;
    }
}
