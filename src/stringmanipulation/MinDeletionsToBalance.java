package stringmanipulation;

import java.util.function.Function;
import java.util.function.ToIntFunction;

public class MinDeletionsToBalance {

    public int minimumDeletions(String s) {
        int min_left = 0;
        int min_right = 0;


        int last_a_Majority_ends_at = getLastAMajorityEndsAt(s, 0, 1, i -> (i < s.length()), 0, (int[] freqs) -> freqs[0] - freqs[1]);

        for (int i = 0; i < s.length(); i++) {
            if ((i <= last_a_Majority_ends_at && s.charAt(i) == 'b') || (i > last_a_Majority_ends_at && s.charAt(i) == 'a')) {
                min_left++;
            }
        }

        int last_b_Majority_ends_at = getLastAMajorityEndsAt(s, s.length() - 1, -1, i -> i >= 0, s.length() - 1, (int[] freqs) -> freqs[1] - freqs[0]);

        for (int i = s.length() - 1; i >= 0; i--) {
            if ((s.charAt(i) == 'a' && i >= last_b_Majority_ends_at) || (i < last_b_Majority_ends_at && s.charAt(i) == 'b')) {
                min_right++;
            }
        }

        return Math.min(min_left, min_right);
    }

    private int getLastAMajorityEndsAt(String s, int start, int step, Function<Integer, Boolean> compFn, int last_a_Majority_ends_at, ToIntFunction<int[]> diffFn) {
        int maxFreqDiff = Integer.MIN_VALUE;
        int[] freqs = new int[2];

        for (int i = start; compFn.apply(i); i += step) {
            char c = s.charAt(i);
            freqs[c - 'a']++;
            int diff = diffFn.applyAsInt(freqs);
            if (diff >= maxFreqDiff) {
                last_a_Majority_ends_at = i;
                maxFreqDiff = diff;
            }
        }
        return last_a_Majority_ends_at;
    }

    public static int diff(int[] array, ToIntFunction<int[]> operation) {
        // Basic error checking
        if (array == null || array.length < 2) {
            throw new IllegalArgumentException("Array must not be null and must have at least 2 elements.");
        }
        return operation.applyAsInt(array);
    }
}
