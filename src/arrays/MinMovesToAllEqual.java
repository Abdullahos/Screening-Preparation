package arrays;

//https://leetcode.com/contest/biweekly-contest-169/problems/minimum-moves-to-equal-array-elements-iii/
import java.util.Arrays;

public class MinMovesToAllEqual {

    //t: O(nlog(n)), s: O(1)
    public int minMoves_not_necessary_sort(int[] nums) {
        Arrays.sort(nums);

        int minMoves = 0;

        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            minMoves += nums[n - 1] - nums[i];
        }

        return minMoves;
    }

    //t: O(n), s: O(1)
    public int minMoves(int[] nums) {

        int minMoves = 0;

        int n = nums.length;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            max = Math.max(max, num);
        }

        for (int num : nums) {
            minMoves += max - num;
        }

        return minMoves;
    }
}
