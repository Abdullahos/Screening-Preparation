package arrays;

public class MinSumAfterDeletions {
  public long minArraySum(int[] nums, int k) {
    return backtrack(nums, k, 0, 0, 0);
  }

  private long backtrack(int[] nums, int k, int i, long accDel, long sum) {
    if (i == nums.length) {
      return accDel % k == 0 ? sum : Long.MAX_VALUE;
    }

    return Math.min(
        backtrack(nums, k, i + 1, accDel + nums[i], sum),
        accDel % k == 0 ? backtrack(nums, k, i + 1, 0, sum + nums[i]) : Long.MAX_VALUE);
  }

  public static void main(String[] args) {
    MinSumAfterDeletions sol = new MinSumAfterDeletions();
    int[] nums = {3, 1, 4, 1, 5};
    int k = 3;

    System.out.println(sol.minArraySum(nums, k));
  }
}
