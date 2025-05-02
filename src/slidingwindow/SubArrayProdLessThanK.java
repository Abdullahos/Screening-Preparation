package slidingwindow;

//https://leetcode.com/problems/subarray-product-less-than-k/
public class SubArrayProdLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 0) {
            return 0;
        }

        int l = 0, r = 0;
        int counts = 0;
        int acc = 1;

        while (l <= r && r < nums.length) {
            if (nums[r] < k) {
                while (acc * nums[r] >= k) {
                    acc /= nums[l];
                    l++;
                }
                acc *= nums[r];
                counts += (r - l + 1);

            } else {
                l = r + 1;
                acc = 1;
            }
            r++;
        }
        return counts;
    }
}
