package slidingwindow;

import java.util.HashMap;
import java.util.Map;

class Permutate {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }

        Map<Character, Integer> f1 = new HashMap<>();
        Map<Character, Integer> f2 = new HashMap<>();

        for (char c : s1.toCharArray()) {
            f1.put(c, f1.getOrDefault(c, 0) + 1);
        }

        int i = 0;

        for (int j = 0; j < s2.length(); j++) {
            char c = s2.charAt(j);

            if (!f1.containsKey(c)) {
                i = j + 1;
                f2.clear();
                continue;
            }

            f2.put(c, f2.getOrDefault(c, 0) + 1);

            while (f2.get(c) > f1.get(c)) {
                char left = s2.charAt(i);
                int f = f2.get(left) - 1;
                if (f == 0) {
                    f2.remove(left);
                } else {
                    f2.put(left, f);
                }
                i++;
            }

            if (j - i + 1 == s1.length() && isPermute(f1, f2)) {
                return true;
            }
        }

        return false;
    }

    private boolean isPermute(Map<Character, Integer> f1, Map<Character, Integer> f2) {
        if (f1.size() != f2.size()) {
            return false;
        }
        for (char k : f1.keySet()) {
            //Tricky part: use equals instead of  ==
            if (f2.get(k) == null || !f1.get(k).equals(f2.get(k))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Permutate perm = new Permutate();
        String s1 = "ab";
        String s2 = "a";
        System.out.println(perm.checkInclusion(s1, s2));
    }
}
