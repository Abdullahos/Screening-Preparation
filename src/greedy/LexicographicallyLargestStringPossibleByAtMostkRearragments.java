package greedy;

public class LexicographicallyLargestStringPossibleByAtMostkRearragments {

    private String construct(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        int accK = 0;
        int[] freqs = new int[26];

        for (char c : s.toCharArray()) {
            freqs[c - 'a']++;
        }
        for (int i = 0; i < sb.length(); i++) {
            if (accK >= k) {
                break;
            }

            char c = sb.charAt(i);
            int idx = getLastNonZeroIdx(freqs, c - 'a' + 1  );
            if (idx == -1) {
                break;
            }

            char cc = (char) (idx + 'a');
            if (c == cc) {
                continue;
            }

            int repIdx = sb.indexOf("" + cc, i + 1);
            
            sb.setCharAt(repIdx, c);
            sb.setCharAt(i, cc);
            accK++;
            freqs[cc- 'a']--;
        }
        return sb.toString();
    }

    private int getLastNonZeroIdx(int[] freqs, int min) {
        for (int i = freqs.length - 1; i >= min; i--) {
            if (freqs[i] > 0) {
                return i;
            }
        }
        return -1;
    }

}
