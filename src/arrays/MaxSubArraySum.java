package arrays;
//https://leetcode.com/problems/maximum-subarray/
//notes: find the max WITHIN THE ARRAY, not the max generally ... so [-1,-2] should return -1 not 0

public class MaxSubArraySum {

    public int maxSubArray(int[] nums) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int num : nums) {
            sum += num;
            maxSum = Math.max(maxSum, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return maxSum;
    }

    public int maxSubArray2(int[] nums) {
        int sum = 0, max = Integer.MIN_VALUE;

        for (int num : nums) {
            sum = Math.max(sum + num, num);
            max = Math.max(max, sum);
        }

        return max;
    }

}
