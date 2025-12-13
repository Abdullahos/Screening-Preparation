package arrays;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class CountMajoritySubarrays {

  // t: O(n^2), s: O(1)
  public int countMajoritySubarrays(int[] nums, int target) {
    int counts = 0, freqs = 0;

    for (int i = 0; i < nums.length; i++) {
      freqs = 0;
      for (int j = i; j < nums.length; j++) {
        freqs += (nums[j] == target) ? 1 : 0;
        counts += (freqs > (j - i + 1) / 2) ? 1 : 0;
      }
    }

    return counts;
  }

    public int countMajoritySubarrays2(int[] nums, int target) {
        int freq = 0;
        int n = nums.length - 1;
        int[] dp = new int[n + 1];

        for (int i = 0; i < n; i++) {
            if (nums[i] == target) freq++;

            int j = 0;
            while (j < i && freq <= j - i + 1) {
                freq -= nums[j] == target ? 1 : 0;
                j++;
            }

            dp[i + 1] = dp[i] + (nums[j] == target ? freq : 0);
        }


        return dp[n];
    }
}
