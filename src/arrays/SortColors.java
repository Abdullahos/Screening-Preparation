package arrays;

import java.util.Arrays;

public class SortColors {
    public void sortColors(int[] nums) {
        int[] freqs = new int[3];
        for (int num : nums) {
            freqs[num]++;
        }

        int nextStart = 0;
        for (int i = 0; i < freqs.length; i++) {
            Arrays.fill(nums, nextStart, nextStart + freqs[i], i);
            nextStart += freqs[i];
        }
    }
}
