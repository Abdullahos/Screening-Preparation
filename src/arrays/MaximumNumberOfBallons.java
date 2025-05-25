package arrays;

public class MaximumNumberOfBallons {

    public int maxNumberOfBalloons(String text) {
        int[] freqs = new int[26];
        int[] targetFreq = new int[26];

        for (char c : "balloon".toCharArray()) {
            targetFreq[c - 'a']++;
        }

        for (char c : text.toCharArray()) {
            freqs[c - 'a']++;
        }


        int maxNofBalloons = Integer.MAX_VALUE;

        for (int i = 0; i < targetFreq.length; i++) {
            if (targetFreq[i] == 0) {
                continue;
            }
            maxNofBalloons = Math.min(freqs[i] / targetFreq[i], maxNofBalloons);
            if (freqs[i] == 0) {
                break;
            }
        }

        return maxNofBalloons == Integer.MAX_VALUE ? 0 : maxNofBalloons;

    }
}
