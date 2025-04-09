package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstringWithoutRepeating(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int longest = 0;
        int l = 0, r = 0;

        while (r < s.length()) {
            char c = s.charAt(r);
            Integer idx = map.get(c);
            if (idx != null && idx >= l) {
                longest = Math.max(longest, r - l);
                l = idx + 1;
            }
            map.put(c, r);
            r++;
        }

        longest = Math.max(longest, r - l);

        return longest;
    }
}
