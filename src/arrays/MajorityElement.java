package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/majority-element/submissions/1800515693/?envType=study-plan-v2&envId=top-interview-150

public class MajorityElement {

    //t: O(n) , s: O(n)
    public Integer majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            int f = map.getOrDefault(n, 0);
            map.put(n, f + 1);
            if (f  + 1> nums.length / 2) {
                return n;
            }
        }
        return null;
    }


    //t: O(log n), s: O(1)
    public int majorityElement_NO_Extra_Space(int[] nums) {
        if (nums.length <= 2) {
            return nums[0]; //granted that it must have majority, so if only one elem, or 2 then they have to be the same
        }

        Arrays.sort(nums);

        return nums[nums.length - 1];
    }



}
