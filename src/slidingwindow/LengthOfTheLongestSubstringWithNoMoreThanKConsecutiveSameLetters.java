package slidingwindow;

import java.util.Arrays;
import java.util.Collections;

public class LengthOfTheLongestSubstringWithNoMoreThanKConsecutiveSameLetters {

    public int lengthOfLongestSubstring(String s, int k) {
        int n = s.length();
        if (n == 0 || n == 1) {
            return n;
        }
        int maxLength = 1;
        int l = 0, r = 1;
        int chances = 0;
        while (r < n) {
            if (s.charAt(r) == s.charAt(r - 1) && chances < k) {
                chances++;
            } else if (s.charAt(r) != s.charAt(r - 1)) {
                chances = 0;
            } else {
                maxLength = Math.max(maxLength, r - l);
                l = r - k - 1;
                chances--;
            }
            r++;
        }
        maxLength = Math.max(maxLength, r - l);
        return maxLength;
    }

    public static void main(String[] args) {
        LengthOfTheLongestSubstringWithNoMoreThanKConsecutiveSameLetters l = new LengthOfTheLongestSubstringWithNoMoreThanKConsecutiveSameLetters();
        System.out.println(l.lengthOfLongestSubstring("aabaaaaaba", 3));

//        System.out.println(l.lengthOfLongestSubstring("abcdefg"));
//
//        System.out.println(l.lengthOfLongestSubstring("aaaaaaaa"));
//
//        System.out.println(l.lengthOfLongestSubstring("babcabcbb"));
//
//        System.out.println(l.lengthOfLongestSubstring("babcabcbbabcdefghijklmnopqrstuvwxyz"));
//
//        System.out.println(l.lengthOfLongestSubstring("a"));
//
//        System.out.println(l.lengthOfLongestSubstring("ac"));
//
//        System.out.println(l.lengthOfLongestSubstring("abc"));
//
//        System.out.println(l.lengthOfLongestSubstring(""));
    }

}
