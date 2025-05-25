package stringmanipulation;

public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        String longest = "";
        String[][] dp = new String[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            String _1 = longestPalindromeRec(s, dp, i, i);
            String _2 = longestPalindromeRec(s, dp, i, i + 1);
            if (_1.length() > _2.length()) {
                _2 = _1;
            }
            if (_2.length() > longest.length()) {
                longest = _2;
            }
        }
        return longest;
    }

    public String longestPalindromeRec(String s, String[][] dp, int i, int j) {
        if (i < 0 || j == s.length()) return "";

        if (dp[i][j] != null) {
            return dp[i][j];
        }
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        if ((j == s.length() && i < 0) || i < 0 || j == s.length()) {
            i++;
            j--;
        }
        String palindrome = s.charAt(i) != s.charAt(j) ? s.substring(i + 1, j) : s.substring(i, j + 1);
        dp[i][j] = palindrome;
        return palindrome;
    }

//    simple intuitive
    class Solution {
        String longestSoFar = "";
        public String longestPalindrome(String s) {
            for (int i = 0 ; i < s.length(); i++) {
                if (s.length() - i <= longestSoFar.length() / 2) break;
                if (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1))  helper(s, i, i + 1);
                helper(s, i, i);
            }
            return longestSoFar;
        }

        void helper(String s, int i, int j) {
            do {
                i--;
                j++;
            }
            while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j));
            i++;
            j--;
            if (j - i + 1 > longestSoFar.length()) {
                longestSoFar = s.substring(i, j+1);
            }
        }
    }
    public static void main(String[] args) {
    }

}
