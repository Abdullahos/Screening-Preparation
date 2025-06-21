package dp;

import java.util.HashMap;
import java.util.Map;

public class SpecialTriplet {
    public int specialTriplets(int[] nums) {
        int result = 0;

        Map<Integer, Integer> dp = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (dp.containsKey(nums[i])) {
                result += dp.get(nums[i]);
            } else {
                result += countTriplets(nums, i, dp);
            }
            if (dp.containsKey(nums[i] * 2)) {
                int counts = dp.get(nums[i] * 2);
                if (counts <= 1) {
                    dp.remove(nums[i] * 2);
                } else {
                    dp.put(nums[i] * 2, counts - 1);
                }
            }
        }

        return result;
    }

    private int countTriplets(int[] nums, int i, Map<Integer, Integer> dp) {
        int l = i, r = nums.length - 1, counts = 0;

        while (r > l && nums[r] != nums[i]) {
            r--;
        }

        for (l = l + 1; l < r; l++) {
            if (2 * nums[l] == nums[i]) {
                counts++;
            }
        }

        dp.put(nums[i], counts);

        return counts;
    }

    public static void main(String[] args) {
        SpecialTriplet s = new SpecialTriplet();
        s.specialTriplets(new int[]{6,3,3,6,3,6});
    }

    /**
     * class Solution {
     *     int mod = 1_000_000_007;
     *
     *     public int specialTriplets(int[] nums) {
     *         int result = 0;
     *
     *         Map<Integer, Integer> dp = new HashMap<>();
     *
     *         for (int i = 0; i < nums.length; i++) {
     *             if (dp.containsKey(nums[i])) {
     *                 result = (result + dp.get(nums[i])) % mod;
     *             } else {
     *                 result = (result + countTriplets(nums, i, dp)) % mod;
     *             }
     *             if (dp.containsKey(nums[i] * 2)) {
     *                 int counts = dp.get(nums[i] * 2);
     *                 if (counts <= 1) {
     *                     dp.remove(nums[i] * 2);
     *                 } else {
     *                     dp.put(nums[i] * 2, counts - 1);
     *                 }
     *             }
     *         }
     *
     *         return result;
     *     }
     *
     *     private int countTriplets(int[] nums, int i, Map<Integer, Integer> dp) {
     *         int l = i, r = nums.length - 1;
     *         long counts = 0;
     *
     *         while (r > l && nums[r] != nums[i]) {
     *             r--;
     *         }
     *
     *         for (l = l + 1; l < r; l++) {
     *             if (2 * nums[l] == nums[i]) {
     *                 counts++;
     *             }
     *         }
     *
     *         counts %= mod;
     *
     *         dp.put(nums[i], (int) counts);
     *
     *         return (int) counts;
     *     }
     * }
     */


    /**
     * class Solution {
     *     int mod = 1_000_000_007;
     *
     *     public int specialTriplets(int[] nums) {
     *         int result = 0;
     *
     *
     *         for (int i = 0; i < nums.length; i++) {
     *            result += countTriplets(nums, i);
     *         }
     *
     *         return result;
     *     }
     *
     *     private int countTriplets(int[] nums, int i) {
     *         long halfs_counts = 0;
     *         long result = 0;
     *
     *         for (int l = i + 1; l < nums.length; l++) {
     *             if (2 * nums[l] == nums[i]) {
     *                 halfs_counts++;
     *             } else if (nums[l] == nums[i]) {
     *                 result += halfs_counts;
     *             }
     *         }
     *
     *         return (int) result;
     *     }
     * }©leetcode
     */
}
