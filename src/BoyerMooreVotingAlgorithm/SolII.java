package BoyerMooreVotingAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class SolII {
    public List<Integer> majorityElement(int[] nums) {
        Integer most = null;
        List<Integer> list = new ArrayList<>();
        if (nums.length <= 2) {
            if (nums.length == 1)
                list.add(nums[0]);
            else {
                list.add(nums[0]);
                if (nums[0] != nums[1]) {
                    list.add(nums[1]);
                }
                return list;
            }
        }

        while (true) {
            most = majorityElementHelper(nums, most, list);
            if (most == Integer.MIN_VALUE) {
                break;
            }
        }

        return list;
    }

    public int majorityElementHelper(int[] nums, Integer prevMost, List<Integer> list) {
        int counts = 0;
        int votes = 0;
        int candidate = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (counts > nums.length / 3) {
                list.add(prevMost);
            }
            if (prevMost != null && nums[i] == prevMost) {
                counts++;
                nums[i] = Integer.MIN_VALUE;
                continue;
            }
            if (nums[i] == Integer.MIN_VALUE) {
                continue;
            }
            //voting system
            if (votes == 0) {
                candidate = nums[i];
                votes = 1;
            } else if (nums[i] == candidate) {
                votes++;
            }
            else if (candidate != nums[i]) {
                votes--;
            }
        }
        return candidate;
    }

    public static void main(String[] args) {
        SolII solII = new SolII();
        System.out.println(solII.majorityElement(new int[]{3,2,3}));
    }
}
