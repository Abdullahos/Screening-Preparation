package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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


    public Integer majorityElement_NO_Extra_Space(int[] nums) {
        if (nums.length <= 2) {
            return nums[0]; //granted that it must have majority, so if only one elem, or 2 then they have to be the same
        }

        Arrays.sort(nums);
        int freq = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                freq = 1;
            } else {
                freq++;
            }
            if (freq > nums.length / 2) {
                return nums[i];
            }
        }

        return null;
    }



}
