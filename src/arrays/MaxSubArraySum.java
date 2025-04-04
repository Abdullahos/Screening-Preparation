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
            while (acc < 0 && l < n)  {
                acc -= nums[l];
                l++;
                if (r < l && l < n) {
                    r = l;
                    acc += nums[r];
                }
            }
            r++;
            max = Math.max(max, acc);
        }

        return max;
    }

}
