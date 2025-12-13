package backtracking.checkequalpartitionproduct;


public class LogSolutionUsingDP {

  private static final double EPS = 1e-9;

  //enumerating ... the Idea behind it is same as truth table
  public boolean checkEqualPartitions(int[] nums, long target) {
      int n = nums.length;
      double[] logs = new double[n];
      double logTarget = Math.log(target);
      double total = 0;

      for (int i = 0; i < n; i++) {
          logs[i] = Math.log(nums[i]);
          total += logs[i];
      }

      int fullMask = 1 << n;

      for (int mask = 1; mask < fullMask; mask++) {
          double usedSum = 0;
          for (int i = 0; i < n; i++) {
              if ((mask & (1 << i)) != 0) {
                  usedSum += logs[i];
              }
          }

          if (Math.abs(usedSum - logTarget) < EPS) {
                  return true; // found valid partition
          }
      }

      return false;
    }

    public static void main(String[] args) {
        LogSolutionUsingDP solver = new LogSolutionUsingDP();
        int[] nums = {3, 1, 6, 8, 4};
        long target = 24;
        System.out.println(solver.checkEqualPartitions(nums, target)); // expected true
    }
}
