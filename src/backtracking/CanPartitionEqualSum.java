package backtracking;

//https://leetcode.com/problems/partition-equal-subset-sum/
public class CanPartitionEqualSum {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;

        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0) {
            return false;
        }

        boolean[][] dp = new boolean[n][sum + 1];

        return canPartitionBackTrack(nums, sum / 2, 0, 0, dp);
    }

    boolean canPartitionBackTrack(int[] nums, int target, int acc, int idx, boolean[][] dp) {
        if (acc == target) {
            return true;
        }
        if (acc > target || idx == nums.length || dp[idx][acc]) {
            return false;
        }
        dp[idx][acc] = true;
        return canPartitionBackTrack(nums, target, acc + nums[idx], idx + 1, dp) || canPartitionBackTrack(nums, target, acc, idx + 1, dp);
    }
}
