package stringmanipulation;

public class MinDeletionsToBalance {

    public int minimumDeletions(String s) {
        int n = s.length();
        int[][] prefix_freq_left = new int[2][n];
        int[][] prefix_freq_right = new int[2][n];

        int min_l, min_r;

        prefix_freq_left[s.charAt(0) - 'a'][0] = 1;
        for (int i = 1; i < s.length(); i++) {
            prefix_freq_left[s.charAt(i) - 'a'][i] = 1;
            prefix_freq_left[0][i] += prefix_freq_left[0][i - 1];
            prefix_freq_left[1][i] += prefix_freq_left[1][i - 1];
        }


        if (prefix_freq_left[0][n - 1] == n || prefix_freq_left[1][n - 1] == n) {
            return 0;
        }

        prefix_freq_right[s.charAt(n - 1) - 'a'][n - 1] = 1;
        for (int i = s.length() - 2; i >= 0; i--) {
            prefix_freq_right[s.charAt(i) - 'a'][i]++;
            prefix_freq_right[0][i] += prefix_freq_right[0][i + 1];
            prefix_freq_right[1][i] += prefix_freq_right[1][i + 1];
        }


        int maxDiff = Integer.MIN_VALUE;
        int maxDiffFromLeftWasAt = 0;

        for (int i = 0; i < s.length(); i++) {
            int diff = prefix_freq_left[0][i] - prefix_freq_left[1][i];

            if (diff >= maxDiff && s.charAt(i) == 'a') {
                maxDiffFromLeftWasAt = i;
                maxDiff = diff;
            }
        }

        int a_to_delete = maxDiffFromLeftWasAt < n - 1 ? prefix_freq_left[0][n - 1] - prefix_freq_left[0][maxDiffFromLeftWasAt + 1] : 0;
        int b_to_delete = prefix_freq_left[1][maxDiffFromLeftWasAt];
        min_l = a_to_delete + b_to_delete;

        maxDiff = Integer.MIN_VALUE;
        int maxDiffFromRightWasAt = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            int diff = prefix_freq_right[1][i] - prefix_freq_right[0][i];

            if (diff >= maxDiff && s.charAt(i) == 'b') {
                maxDiffFromRightWasAt = i;
                maxDiff = diff;
            }
        }

        a_to_delete = prefix_freq_right[0][maxDiffFromRightWasAt];
        b_to_delete = maxDiffFromRightWasAt > 0 ? prefix_freq_right[1][0] - prefix_freq_right[1][maxDiffFromRightWasAt - 1] : 0;
        min_r = a_to_delete + b_to_delete;

        return Math.min(min_l, min_r);
    }

}
