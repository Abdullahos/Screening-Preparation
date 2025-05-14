package greedy;

/**
 * Given an array of positive integers nums and a positive integer target
 * Return the minimal length of a subarray whose sum is greater than or equal
 * to target. If there is no such subarray, return 0 instead.
 * <p>
 * Input: target = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: The subarray [4,3] has the minimal length under the problem constraint.
 * <p>
 * Input: target = 4, nums = [1,4,4]
 * Output: 1
 * <p>
 * Input: target = 11, nums = [1,1,1,1,1,1,1,1]
 * Output: 0
 */

public class MinSubArrayLen {

    //Greedy but not correct, as trying to reduce the window size by removing elements either from the left or the right, based on which is smaller (nums[l] <= nums[r]). But this doesn’t consider all possible contiguous subarrays. Here’s why that logic is flawed:
    //You can remove a smaller element and still miss a valid smaller-length subarray that sums to ≥ target.
    //The key constraint is contiguous subarray, and greedily shrinking from both ends misses valid internal windows. (only look under his shoes)
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num == target) return 1;
            sum += num;
        }

        int l = 0, r = nums.length - 1;
        while (l < r) {
            while (sum >= target) {
                minLength = Math.min(minLength, r - l + 1);
                if (nums[l] <= nums[r]) {
                    sum -= nums[l++];
                } else {
                    sum -= nums[r--];
                }
            }
            if (l - 1 < 0 && r + 1 < nums.length) {
                sum += nums[r++];
            } else if (r + 1 == nums.length && l - 1 >= 0) {
                sum += nums[l--];
            } else if (l - 1 < 0 && r + 1 == nums.length) {
                break;
            }
            if (nums[l - 1] >= nums[r + 1]) {
                sum += nums[l - 1];
                l--;
            } else {
                sum += nums[r];
                r++;
            }

        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
