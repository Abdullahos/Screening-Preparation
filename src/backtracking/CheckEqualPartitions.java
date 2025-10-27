package backtracking;

import java.util.*;

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
        long mult = 1;

        for (int num : nums) {
            mult *= num;
        }

        if (mult < target) {
            return false;
        }

        Set<CompositeKey> dp = new HashSet<>();

        return backtrack(nums, target, 1, mult, 0, dp);
    }

    private boolean backtrack(int[] nums, long target, long multAcc, long rest, int start, Set<CompositeKey> dp) {
        if (multAcc == rest && multAcc== target) {
            return true;
        }

        if (start == nums.length) {
            return false;
        }
        CompositeKey key = getKey(multAcc, start);

        if (dp.contains(key)) {
            return false;
        }

        if (multAcc > target) {
            return false;
        }

        boolean found = backtrack(nums, target, multAcc * nums[start], rest / nums[start], start + 1, dp) || backtrack(nums, target, multAcc, rest, start + 1, dp);

        if (!found) {
            dp.add(key);
        }

        return found;
    }

    private CompositeKey getKey(long multAcc, int start) {
        return new CompositeKey(start, multAcc);
    }

    class CompositeKey {
        private final Integer index;
        private final Long product;

        public CompositeKey(Integer index, Long product) {
            this.index = index;
            this.product = product;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            CompositeKey that = (CompositeKey) o;
            return Objects.equals(index, that.index) &&
                    Objects.equals(product, that.product);
        }

        @Override
        public int hashCode() {
            return Objects.hash(index, product);
        }
    }
}
