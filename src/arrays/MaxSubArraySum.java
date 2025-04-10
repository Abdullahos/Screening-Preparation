package arrays;

public class MaxSubArraySum {

    public int maxSubArray(int[] nums) {
        int i = 1, sum = nums[0], max = sum;
        int n = nums.length;

        for (; i < n; i++) {
            sum = Math.max(sum + nums[i] ,nums[i]);
            max = Math.max(max, sum);
        }

        return max;
    }

}
