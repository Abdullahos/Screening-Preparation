package arrays;

import java.util.Arrays;

public class LongestConsecutiveSeq {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);
        int longest = 1;
        int cur = 1;

        for (int i = 1; i < nums.length; i++) {
            int diff = nums[i] - nums[i - 1];
            if (diff == 1)  {
                cur++;
                longest = Math.max(longest, cur);
            }
            else if (diff > 0) {
                cur = 1;
            }
        }

        return longest;
    }
}
