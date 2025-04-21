package binarysearch;

import static binarysearch.SearchInRotatedSortedArray.getRotatedPivotIdx;

public class FindMinInRotatedSortedArray {

    public int findMin(int[] nums) {
        int n = nums.length;
        if (nums[0] <= nums[n - 1]) {
            return nums[0];
        }
        int rotatedPivotIdx = getRotatedPivotIdx(nums);
        if (rotatedPivotIdx + 1 < n) {
            return nums[rotatedPivotIdx + 1];
        }
        return nums[rotatedPivotIdx];
    }

}
