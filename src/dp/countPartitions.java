package dp;

public class countPartitions {
    static final int MOD = 1_000_000_007;

    public int countPartitions(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[0] = 1; // base case: 1 way to partition an empty array

        for (int i = 1; i <= n; i++) {
            int min = nums[i - 1], max = nums[i - 1];

            for (int j = i - 1; j >= 0; j--) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);

                if (max - min > k) break;

                dp[i] += dp[j];
            }
        }

        return dp[n] % MOD;
    }
}
