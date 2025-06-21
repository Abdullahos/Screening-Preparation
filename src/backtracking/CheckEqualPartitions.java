package backtracking;

import java.util.HashSet;
import java.util.Set;

/**
 * 3,1,6,8,4
 *
 * ([3,1,6,8,4], 24, 1, [])
 * 	([3,1,6,8,4], 24, 3, [3])
 * 		([3,1,6,8,4], 24, 4837, [3,1,6,8]) //false
 * 		([3,1,6,8,4], 24, 72, [3,1,6,4])   //false
 * 		([3,1,6,8,4], 24, 72, [3,1,6,4])   //false
 * 		([3,1,6,8,4], 24, 24, [3,1,8])
 * 			([3,1,6,8,4], 24, 1, [3,1,8])
 */
public class CheckEqualPartitions {

    public boolean checkEqualPartitions(int[] nums, long target) {
        return dfs(nums, target, 1, new HashSet<>(), 0);
    }

    private boolean dfs(int[] nums, long target, long acc, Set<Integer> inSub, int start) {
        if (acc > target) {
            return false;
        }

        if (acc == target) {
            acc = 1;
            for (int num : nums) {
                if (acc > target) {
                    return false;
                }
                if (!inSub.contains(num)) {
                    acc *= num;
                }
            }
            return acc == target;
        }

        for (int i = start; i < nums.length; i++) {
            if (!inSub.contains(nums[i])) {
                inSub.add(nums[i]);
                if (dfs(nums, target, acc * nums[i], inSub, i + 1)) {
                    return true;
                }
                inSub.remove(nums[i]);
            }
        }

        return false;
    }
}
