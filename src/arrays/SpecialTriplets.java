package arrays;

import java.util.HashMap;
import java.util.Map;

public class SpecialTriplets {
    long MOD = 1_000_000_007;

    public int specialTriplets(int[] nums) {
        int specialTripletsCounts = 0;

        Map<Integer, Integer> preFix = new HashMap<>();
        Map<Integer, Integer> suffFix = new HashMap<>();

        for (int i = nums.length - 1; i > 1; i--) {
            suffFix.put(nums[i], suffFix.getOrDefault(nums[i], 0) + 1);
        }

        preFix.put(nums[0], 1);

        for (int i = 1; i < nums.length - 1; i++) {
            long left = preFix.getOrDefault(nums[i] * 2, 0);
            long right = suffFix.getOrDefault(nums[i] * 2, 0);

            specialTripletsCounts = (int)((specialTripletsCounts + (left * right) % MOD) % MOD);

            preFix.put(nums[i], preFix.getOrDefault(nums[i], 0) + 1);
            suffFix.put(nums[i + 1], suffFix.get(nums[i + 1]) - 1);
        }

        return specialTripletsCounts;
    }
}
