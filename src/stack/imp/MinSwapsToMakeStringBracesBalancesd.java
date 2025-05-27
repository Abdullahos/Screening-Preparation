package stack.imp;

import java.util.Stack;

public class MinSwapsToMakeStringBracesBalancesd {

    //t: O(n^2), s: O(n)
    class First {
        public int minSwaps(String s) {
            StringBuilder sb = new StringBuilder(s);
            int numOfSwaps = 0;
            int r = sb.length() - 1;

            Stack<Character> open_stk = new Stack<>();

            for (int i = 0; i < sb.length(); i++) {
                char c = sb.charAt(i);

                if (c == ']' && open_stk.isEmpty()) {

                    int idx = getWronglyOpening(sb, r, i);
                    sb.setCharAt(i, sb.charAt(idx));
                    sb.setCharAt(idx, c);

                    open_stk.push('[');

                    numOfSwaps++;

                    r = idx - 1;

                } else if (c == '[') {
                    open_stk.push(c);
                } else {
                    open_stk.pop();
                }
            }

            return numOfSwaps;

        }

        private int getWronglyOpening(StringBuilder sb, int r, int l) {
            Stack<Character> stk = new Stack<>();

            for (int i = r; i > l; i--) {
                char c = sb.charAt(i);
                if (c == '[' && stk.isEmpty()) {
                    return i;
                }
                if (c == '[' && !stk.isEmpty()) {
                    stk.pop();
                }
                else if (c == ']') {
                    stk.push(c);
                }
            }

            return -1;
        }
    }

    //t: O(n), s: O(n)
    class Second {
        public int minSwaps(String s) {
            int numOfSwaps = 0;

            Stack<Character> open_stk = new Stack<>();

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if (c == ']' && open_stk.isEmpty()) {
                    open_stk.push('[');
                    numOfSwaps++;
                } else if (c == '[') {
                    open_stk.push(c);
                } else {
                    open_stk.pop();
                }
            }

            return numOfSwaps;

        }
    }

    //t: O(n), s: O(1)
    static class Third {
        public int minSwaps(String s) {
            int numOfSwaps = 0;
            int openingN = 0;

            for (char c : s.toCharArray()) {
                if (c == ']' && openingN == 0) {
                    openingN++;
                    numOfSwaps++;
                } else if (c == '[') {
                    openingN++;
                } else {
                    openingN--;
                }
            }

            return numOfSwaps;

        }
    }

}
