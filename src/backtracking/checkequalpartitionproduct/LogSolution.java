package backtracking.checkequalpartitionproduct;

public class LogSolution {
    private static final double EPS = 1e-9;

    public boolean checkEqualPartitions(int[] nums, long target) {
        if (target <= 0)
            return false; // logs undefined for <= 0

        double totalLog = 0.0;
        double logTarget = Math.log(target);
        double[] logs = new double[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0)
                return false;
            logs[i] = Math.log(nums[i]);
            totalLog += logs[i];
        }

        return backtrack(logs, logTarget, totalLog, 0, 0.0);
    }

    private boolean backtrack(double[] logs, double logTarget, double totalLog, int start, double accLog) {
        if (Math.abs(accLog - logTarget) < EPS) {
            if (Math.abs((totalLog - accLog) - logTarget) < EPS) {
                return true;
            }
        }

        if (start == logs.length) {
            return false;
        }

        if (backtrack(logs, logTarget, totalLog, start + 1, accLog + logs[start])) {
            return true;
        }

        return backtrack(logs, logTarget, totalLog, start + 1, accLog);
    }
}
