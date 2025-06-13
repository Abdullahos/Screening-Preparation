package stack.imp;

import java.util.Stack;

public class ResultingStringAfterRemovingEachAdjChars {

    public String resultingString(String s) {
        if (s.length() == 1) {
            return s;
        }

        char[] chars = s.toCharArray();

        remove(s, chars);

        StringBuilder sb = new StringBuilder();

        for (char c : chars) {
            if (c != '\0') {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    private void remove(String s, char[] chars) {


        Stack<Integer> stk = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (!stk.isEmpty() && shouldRemove(s, stk.peek(), i)) {
                chars[stk.pop()] = '\0';
                chars[i] = '\0';
            } else {
                stk.push(i);
            }
        }

    }

    private boolean shouldRemove(String s, int l, int r) {
        if (l < 0 || r == s.length()) {
            return false;
        }

        char c1 = s.charAt(l);
        char c2 = s.charAt(r);

        return (Math.abs(c1 - c2) == 1 || ((c1 == 'a' && c2 == 'z') || (c1 == 'z' && c2 == 'a')));
    }

}
