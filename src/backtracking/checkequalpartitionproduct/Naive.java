package backtracking.checkequalpartitionproduct;

public class Naive {
    //The naive idea is if (prod == target * target) -> then if i found subset == target then I don't need to search for the other half.
  public boolean checkEqualPartitions(int[] nums, long target) {
    long product = 1;
    for (int x : nums) product *= x;    //fixme: overflow easily
    if (product != target * target) return false;

    return isSubset(0, nums, target);
  }

  boolean isSubset(int idx, int[] nums, long target) {
    if (idx == nums.length && target == 1) return true;
    if (idx >= nums.length) return false;

    return isSubset(idx + 1, nums, target / nums[idx]) || isSubset(idx + 1, nums, target);
  }
}
