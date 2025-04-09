package tests.ibm.jul2024;

import java.util.Arrays;
import java.util.Collections;

public class ConstructStringWithMaxLexiNoMoreThanKInRow {

    private String construct(String s, int repeatLimit) {
        int n = 26;
        int[] freqs = new int[n];
        for (char c : s.toCharArray()) {
            freqs[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        while (true) {
            int idx = findIdxOfNotEmpty(freqs, n - 1);
            if (idx == -1) {
                break;
            }
            char c = (char) (idx + 'a');
            if (repeatLimit < freqs[idx]) {
                sb.append(String.valueOf(c).repeat(repeatLimit));
                freqs[idx] -= repeatLimit;
                int idx_2 = findIdxOfNotEmpty(freqs, idx - 1);
                if (idx_2 == -1) {
                    break;
                }
                char c_2 = (char) (idx_2 + 'a');
                sb.append(c_2);
                freqs[idx_2]--;
            } else {
                sb.append(String.valueOf(c).repeat(freqs[idx]));
                freqs[idx] = 0;
            }
        }

        return sb.toString();

    }

    private int findIdxOfNotEmpty(int[] freq, int start) {
        for (int i = start; i >= 0; i--) {
            if (freq[i] > 0) {
                return i;
            }
        }
        return -1;
    }


    public String repeatLimitedString(String s, int repeatLimit) {
        Character[] chars = new Character[s.length()];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = s.charAt(i);
        }

        Arrays.sort(chars, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();


        for (char c : chars) {
            sb.append(c);
        }

        int i = 1;
        int acc = 1;

        while (i < sb.length()) {
            if (sb.charAt(i) == sb.charAt(i - 1) && acc < repeatLimit) {
                i++;
                acc++;
                continue;
            }
            if (sb.charAt(i) != sb.charAt(i - 1)) {
                acc = 1;
            } else if (acc >= repeatLimit) {
                boolean ever = false;
                for (int idx = i + 1; idx < sb.length(); idx++) {
                    if (sb.charAt(idx) != sb.charAt(i)) {
                        sb.insert(i, sb.charAt(idx));
                        sb.deleteCharAt(idx + 1);
                        ever = true;
                        break;
                    }
                }
                if (!ever) {
                    sb.deleteCharAt(i);
                    i--;
                }
            }
            i++;
        }

        return sb.toString();
    }

    public static class Notes {
        /**
         * ✅ First Implementation (Yours — using sorting and StringBuilder manipulation):
         * 🔍 Summary:
         * Converts the string to Character[], sorts in reverse order.
         *
         * Constructs a StringBuilder, then post-processes it to ensure repeat limits are not exceeded.
         *
         * Uses insert() and deleteCharAt() on StringBuilder to rearrange or remove characters.
         *
         * ✅ Pros:
         * Straightforward and intuitive.
         *
         * Leverages built-in sorting and readable StringBuilder operations.
         *
         * ❌ Cons:
         * Time Complexity:
         *
         * Sorting is O(n log n)
         *
         * Modifying StringBuilder using insert() and deleteCharAt() is O(n) per call — potentially O(n²) total in the worst case.
         *
         * Space Complexity: Uses Character[] which consumes more memory than a primitive array.
         *
         * Inserting and deleting from the middle of a StringBuilder repeatedly can be costly.
         *
         * Not ideal for large inputs (close to TLE on edge cases).
         *
         * ✅ Second Implementation (Optimized using frequency array):
         * 🔍 Summary:
         * Counts frequency of each character using a size-26 array.
         *
         * Greedily adds the highest possible character up to repeatLimit.
         *
         * When the limit is hit, adds the next available smaller character to break the sequence.
         *
         * ✅ Pros:
         * Time Complexity:
         *
         * Counting: O(n)
         *
         * Building output: Worst-case linear traversal through 26 characters — so overall O(n).
         *
         * Space Complexity: Constant (O(1)) extra space (just a 26-element array and the output).
         *
         * Much more efficient and scalable, ideal for large strings.
         *
         * No costly insert() or delete() operations.
         *
         * ❌ Cons:
         * Slightly more logic-heavy due to findIdxOfNotEmpty, but still readable.
         *
         * May be harder to write from scratch under time pressure for beginners.
         */
    }


    public static void main(String[] args) {
        ConstructStringWithMaxLexiNoMoreThanKInRow construct = new ConstructStringWithMaxLexiNoMoreThanKInRow();
        System.out.println(construct.construct("babccc", 2));
        System.out.println(construct.construct("babcccccccccc", 2));
    }

}
