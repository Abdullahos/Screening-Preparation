package arrays;

//https://leetcode.com/problems/merge-close-characters/
public class MergeCharacters {
    public String mergeCharacters(String s, int k) {
        Integer[] idxs = new Integer[26];

        StringBuilder sb = new StringBuilder(s);

        for (int i = 0; i < sb.length(); i++) {
            Integer idx = idxs[sb.charAt(i) - 'a'];

            if (idx != null && i - idx <= k) {
                sb.deleteCharAt(i);
                i--;
            } else {
                idxs[sb.charAt(i) - 'a'] = i;
            }

        }

        return sb.toString();
    }
}
