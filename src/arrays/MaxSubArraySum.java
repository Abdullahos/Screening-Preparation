package arrays;

public class MaxSubArraySum {

    public int maxSubArray(int[] nums) {
        int l = 0, r = 0;
        int max = Integer.MIN_VALUE;
        int acc = 0;
        int n = nums.length;
        while (r < n && nums[r] < 0) {
            max = Math.max(max, nums[r]);
            r++;
            l++;
        }
        while (r < n) {
            acc += nums[r];
            if (acc < 0) {
                acc = 0;
            }
            r++;
            max = Math.max(max, acc);
        }

        return max;
    }

}
