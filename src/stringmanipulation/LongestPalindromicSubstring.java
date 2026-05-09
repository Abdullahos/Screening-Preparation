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

    public String longestPalindrome(String s) {
      String longest = "";
      int n = s.length();

      for (int i = 0; i < n; i++) {
        if ((n - i) * 2 <= longest.length()) break;

        String same = fn(s, i, i, n);
        String adj = fn(s, i, i + 1, n);

        String localLongest = same.length() > adj.length() ? same : adj;
        longest = localLongest.length() > longest.length() ? localLongest : longest;
      }

      return longest;
    }

    private String fn(String s, int l, int r, int n) {
      while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
        l--;
        r++;
      }
      return l < r ? s.substring(l + 1, r) : "";
    }
  }

  public static void main(String[] args) {}
}
