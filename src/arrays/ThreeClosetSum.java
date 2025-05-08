package arrays;

import java.util.Arrays;

public class ThreeClosetSum {
    //O(n^3)
    public int threeSumClosestBruteForce(int[] nums, int target) {
        Integer closetSum = null;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int idx = Arrays.binarySearch(nums, j + 1, nums.length, target - (nums[i] + nums[j]));
                if (idx < 0) {
                    idx = -1 - idx;
                    while ((idx == nums.length || idx == j || idx == i) && idx >= 0) {
                        idx--;
                    }
                    while ((idx < 0 || idx == j || idx == i) && idx < nums.length) {
                        idx++;
                    }
                }
                int acc = nums[i] + nums[j] + nums[idx];
                if (closetSum == null) {
                    closetSum = acc;
                }
                else if (Math.abs(target - closetSum) > Math.abs(target - acc)) {
                    closetSum = acc;
                }
                if (target == closetSum) {
                    return closetSum;
                }
            }
        }
        return closetSum;
    }

    //O(n * log(n) * n)
    public int threeSumClosestBinarySearch(int[] nums, int target) {
        Integer closetSum = null;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int idx = Arrays.binarySearch(nums, j + 1, nums.length, target - (nums[i] + nums[j]));
                int acc = nums[i] + nums[j];
                if (idx < 0) {
                    idx = -1-idx;
                    while ((idx == nums.length || idx == j || idx == i) && idx >= 0) {
                        idx--;
                    }
                    while ((idx < 0 || idx == j || idx == i) && idx < nums.length) {
                        idx++;
                    }
                    if (idx + 1 < nums.length && idx + 1 != j && idx + 1 != i && Math.abs(nums[idx + 1] + acc - target) < Math.abs(nums[idx] + acc - target)) {
                        idx++;
                    }
                    if (idx - 1 >= 0 && idx - 1 != j && idx - 1 != i && Math.abs(nums[idx - 1] + acc - target) < Math.abs(nums[idx] + acc - target)) {
                        idx--;
                    }
                }
                acc += nums[idx];
                if (closetSum == null) {
                    closetSum = acc;
                }
                else if (Math.abs(target - closetSum) > Math.abs(target - acc)) {
                    closetSum = acc;
                }
                if (target == closetSum) {
                    return closetSum;
                }
            }
        }
        return closetSum;
    }


    //O(n^2)
    public int threeSumClosest_twoPointers(int[] nums, int target) {
        Arrays.sort(nums);
        int closetSum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[l] + nums[r];
                closetSum = Math.abs(target - closetSum) > Math.abs(target - (nums[i] + sum)) ? nums[i] + sum : closetSum;
                if (closetSum == target) {
                    return closetSum;
                }
                if (sum > target - nums[i]) {
                    r--;
                }
                else {
                    l++;
                }
            }
        }
        return closetSum;
    }

    public static void main(String[] args) {
        ThreeClosetSum threeClosetSum = new ThreeClosetSum();
        System.out.println(threeClosetSum.threeSumClosestBruteForce(new int[]{-1000,-5,-5,-5,-5,-5,-5,-1,-1,-1}, -14));
    }
}
