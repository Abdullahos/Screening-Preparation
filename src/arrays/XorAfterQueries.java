package arrays;

public class XorAfterQueries {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int mod = 1_000_000_007;

        for (int[] q : queries) {
            int l = q[0], r = q[1], k = q[2], v = q[3];

            int idx = l;
            while (idx <= r) {
                nums[idx] = (int) ( ((long) nums[idx] * v) % mod);  //Since both nums[idx] and v can be up to 1_000_000_007 - 1, their product can be ~10^18, which doesn’t fit in an int.
                idx += k;
            }
        }

        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res ^= nums[i];
        }

        return res;
    }
}
