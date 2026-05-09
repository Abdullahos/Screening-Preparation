package stringmanipulation;

public class AlmostPalindromic {
  //t: O(n^2), s: O(n)
  public int almostPalindromic(String s) {

    int longest = 0;
    int n = s.length();

    for (int i = 0; i < n; i++) {
      if ((n - i) * 2 <= longest) break;

      int same = getLocalLongest(s, i, i, n, false);
      int adj = getLocalLongest(s, i, i + 1, n, false);

      longest = Math.max(longest, Math.max(same, adj));
    }

    return longest;
  }

  private int getLocalLongest(String s, int l, int r, int n, boolean removedOnce) {
    while (l >= 0 && r < n && ((s.charAt(l) == s.charAt(r)) || !removedOnce)) {
      if (s.charAt(l) != s.charAt(r)) {

        int _1 = getLocalLongest(s, l, r + 1, n, true);
        int _2 = getLocalLongest(s, l - 1, r, n, true);

        return Math.max(_1, _2);

      } else {
        l--;
        r++;
      }
    }

    if ((l < 0 ^ r == n) && !removedOnce) {
      return r - l;
    }

    if (l >= r) {
      return 0;
    }

    if (removedOnce) {
      return r - l - 1;
    }

    l++;

    int midIdx = l + (r - l - 1) / 2;

    String sb = s.substring(l, midIdx) + s.substring(midIdx + 1);
    l = 0;
    r = sb.length() - 1;

    while (l < r) {
      if (sb.charAt(l) != sb.charAt(r)) {
        return 0;
      }
      l++;
      r--;
    }

    return sb.length() + 1;
  }

  public static void main(String[] args) {
    AlmostPalindromic ap = new AlmostPalindromic();
    ap.almostPalindromic("aacabdkacaa");
  }
}
