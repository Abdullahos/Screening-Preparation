package binarysearch;

import java.util.Arrays;

///Still has bug, but too close i think
public class SearchInRotatedSortedArray2 {
    public boolean search(int[] nums, int target) {
        int length = nums.length;
        if (nums.length == 1) {
            return nums[0] == target;
        }
        int rotatedIdx = getRotetedPivotIdx(nums);
        int l = Arrays.binarySearch(nums, 0, rotatedIdx, target);
        if (l >= 0) {
            return true;
        }
        int r = Arrays.binarySearch(nums, rotatedIdx, nums.length, target);
        return r >= 0;
    }

    private int getRotetedPivotIdx(int[] nums) {
        int l = 0, r = nums.length - 1, mid = l + (r - l) / 2;
        while (l <= r && mid < r && mid > l) {
            if (nums[mid] < nums[l]) {
                r = mid;
            } else if (nums[mid] > nums[r]) {
                l = mid;
            }
            else {
                if (nums[l + (mid - l) / 2] < nums[l] || nums[l + (mid - l) / 2] > nums[r]) {
                    r = mid;
                } else {
                    l = mid;
                }
            }
            mid = l + (r - l) / 2;
        }

        return r + 1 < nums.length && nums[r + 1] >= nums[r] ? r : l;
    }
}
