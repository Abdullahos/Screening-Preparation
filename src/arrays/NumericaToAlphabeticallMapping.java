package arrays;

//https://leetcode.com/problems/decrypt-string-from-alphabet-to-integer-mapping/
public class NumericaToAlphabeticallMapping {
    public String freqAlphabets(String s) {
        StringBuilder alphaMappingSb = new StringBuilder();

        int i = 0;
        while (i < s.length()) {
            char c;
            if (i + 2 < s.length() && s.charAt(i + 2) == '#') {
                int num = Integer.parseInt(s.substring(i, i + 2));
                c = (char) ('j' + num - 10);
                i += 3;
            } else {
                c = (char) ('a' + Integer.parseInt(String.valueOf(s.charAt(i))) - 1);
                i++;
            }
            alphaMappingSb.append(c);
        }

        return alphaMappingSb.toString();
    }
}
