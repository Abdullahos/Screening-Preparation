package binarysearch;

import java.util.Arrays;

public class SearchInRotatedSortedArray {
    public static int search(int[] nums, int target) {
        if (nums[0] <= nums[nums.length - 1]) {
            int idx = Arrays.binarySearch(nums, target);
            return idx >= 0 ? idx : -1;
        }
        else {
            int rotatedIdx = getRotatedPivotIdx(nums);
            int l = Arrays.binarySearch(nums, 0, rotatedIdx + 1, target);
            if (l >= 0) {
                return l;
            }
            int r = Arrays.binarySearch(nums, rotatedIdx + 1, nums.length, target);
            return r >= 0 ? r : -1;
        }

    }

    public static int getRotatedPivotIdx(int[] nums) {
        int l = 0, r = nums.length - 1, mid = l + (r - l) / 2;
        while (l <= r) {
            if (nums[mid] < nums[l]) {
                r = mid;
            }
            else if (nums[mid] == nums[l] || nums[mid] == nums[r]) {
                return mid;
            }
            else {
                l = mid;
            }
            mid = l + (r - l) / 2;
        }
        return l;
    }
}
