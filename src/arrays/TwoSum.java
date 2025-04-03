package arrays;

import java.util.HashMap;
import java.util.Map;
//t: O(n), s: O(n)
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> elemToIdx = new HashMap<>();
        for (int idx = 0; idx < nums.length; idx++) {
            Integer i = elemToIdx.get(nums[idx]);
            if (i != null) return new int[] {i, idx};
            elemToIdx.put(target - nums[idx], idx);
        }
        return new int[]{-1, -1};
    }
}
