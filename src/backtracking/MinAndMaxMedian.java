package backtracking;

import java.util.*;

public class MinAndMaxMedian {

//    public int[] getMinAndMaxMedian(int[] nums, int k) {
//
//        Arrays.sort(nums);
//
//        Set<Integer> medians = new HashSet<>();
//
//        backtrack(nums, k, 0, 0, medians, new ArrayList<>());
//
//
//        int[] result = getMinAndMaxFromMap(medians);
//
//        return result;
//    }
//
//    private int[] getMinAndMaxFromMap(Set<Integer> medians) {
//        int[] result = new int[2];
//
//        int min = Integer.MAX_VALUE;
//        int max = Integer.MIN_VALUE;
//
//        for (Integer median : medians) {
//            if (median < min) {
//                min = median;
//                result[0] = median;
//            }
//            if (median > max) {
//                max = median;
//                result[1] = median;
//            }
//        }
//        return result;
//    }
//
//
//    private void backtrack(int[] nums, int k, int start, int end, Set<Integer> medians, List<Integer> subArray) {
//        if (start == nums.length) {
//            return;
//        }
//
//        if (end - start == k) {
//            int median = getMedian(subArray);
//            medians.add(median);
//            return;
//        }
//
//        for (int i = end; i - start + 1 < k; i++) {
//            subArray.add(nums[i]);
//
//            backtrack(nums, k, start, i + 1, medians, subArray);
//
//            subArray.remove(subArray.size() - 1);
//        }
//
//    }
//
//    private int getMedian(List<Integer> nums) {
//        int n = nums.size();
//
//        if (n % 2 == 0) {
//            return (nums.get(n / 2) + nums.get(n / 2 - 1)) / 2;
//        }
//
//        return nums.get(n / 2);
//    }


    public int[] getMinAndMaxMedian(int[] nums, int k) {

        Arrays.sort(nums);

        int min = getMedian(nums, 0, k);
        int max = getMedian(nums, nums.length - k - 1, k);

        return new int[] {min, max};
    }

    private int getMedian(int[] nums, int start, int k) {

        if (k % 2 == 0) {
            return (nums[start + (k - start) / 2] + nums[start + (k - start) / 2 - 1]) / 2;
        }

        return nums[start + (k - start) / 2];
    }



}
