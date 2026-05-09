package prefixsum;

// https://leetcode.com/contest/weekly-contest-500/problems/count-indices-with-opposite-parity/
class Solution {
  public int[] countOppositeParity(int[] nums) {
    int n = nums.length;
    int[] answer = new int[n];

    int[] odd_prefix = new int[n];

    for (int i = n - 2; i >= 0; i--) {
      odd_prefix[i] = odd_prefix[i + 1] + (nums[i + 1] % 2 != 0 ? 1 : 0);
    }

    for (int i = 0; i < n; i++) {
      if (nums[i] % 2 == 0) {
        answer[i] = odd_prefix[i];
      } else {
        answer[i] = (n - 1 - i) - odd_prefix[i];
      }
    }

    return answer;
  }

  class BruteForce {
    public int[] countOppositeParity(int[] nums) {
      int n = nums.length;
      int[] answer = new int[n];
      int counts;

      for (int i = 0; i < n; i++) {
        boolean isIOdd = nums[i] % 2 != 0;
        counts = 0;

        for (int j = i + 1; j < n; j++) {
          boolean isJOdd = nums[j] % 2 != 0;
          if (isIOdd ^ isJOdd) {
            counts++;
          }
        }

        answer[i] = counts;
      }

      return answer;
    }
  }
}
