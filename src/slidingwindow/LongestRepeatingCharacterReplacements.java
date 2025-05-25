package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacements {


    public int characterReplacement(String s, int k) {
        if (k >= s.length()) {
            return s.length();
        }

        int[] freq = new int[26];

        int longest = 1;
        int mostFrq = 1;
        int l = 0;

        for (int r = 1; r < s.length(); r++) {
            char c = (char) (s.charAt(r) - 'A');
            freq[c]++;

            int f = freq[c];
            mostFrq = Math.max(mostFrq, f);

            while (r - l + 1 - mostFrq > k) {
                freq[s.charAt(l) - 'A']--;
                l++;
            }

            longest = Math.max(longest, r - l + 1);
        }

        return longest;
    }


    //no need as when we shrink the window that's the result of decrementing the most freq even if we didn't do that actuallt
    //[A,A,A,B,B], k = 1
    public int characterReplacement2(String s, int k) {
        if (k >= s.length()) {
            return s.length();
        }

        int longest = 1;
        char mostFreq = s.charAt(0);

        Map<Character, Integer> map = new HashMap<>();

        int l = 0;

        for (int r = 0; r < s.length(); r++) {
            char cur = s.charAt(r);

            map.put(cur, map.getOrDefault(cur, 0) + 1);

            if (cur != mostFreq) {
                mostFreq = getMostFreqChar(map);

                while (r - l + 1 - map.get(mostFreq) > k) {
                    char c = s.charAt(l);
                    int f = map.get(c) - 1;
                    if (f == 0) {
                        map.remove(c);
                    } else {
                        map.put(c, f);
                    }
                    mostFreq = getMostFreqChar(map);
                    l++;
                }

            }

            longest = Math.max(longest, r - l + 1);
        }

        return longest;

    }

    private Character getMostFreqChar(Map<Character, Integer> map) {
        int maxFreq = 0;
        Character mostFreqChar = null;

        for (char c : map.keySet()) {
            int f = map.get(c);
            if (f > maxFreq) {
                mostFreqChar = c;
                maxFreq = f;
            }
        }

        return mostFreqChar;
    }
}
