package stringmanipulation;

/**
 * A string encodes an additive sequence if:
 *         - it consists of ≥ 3 characters (all characters will be digit characters, '0'-'9')
 * - there exists a partitioning of the string into substrings such that any 2 previous substrings sum to the value of the next substring in the partitioning
 * Given a strings, determine whether s is an additive sequence.

 * Input: s = "347"
 * Input: s = "3 4 7 11 18 29"
 * Output: true
 * Input: s = "15051101152"
 * Output: true

 * Input: s = "15141161152"
 * Output: false
 */

public class IsAddable {
    public boolean isAddable(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            String first = s.substring(0, i + 1);
            for (int j = i + first.length(); j < s.length(); j++) {
                String second = s.substring(i + 1, j + 1);
                String rest = s.substring(j + 1);
                long sum = Long.parseLong(first) + Long.parseLong(second);
                if (rest.startsWith(String.valueOf(sum))) {
                    if (sum == Integer.parseInt(rest)) {
                        return true;
                    }
                    boolean addable = isAddable(second + rest);
                    if (addable) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        IsAddable isAddable = new IsAddable();
        System.out.println(isAddable.isAddable("34751220"));//false
        System.out.println(isAddable.isAddable("347")); //true
        System.out.println(isAddable.isAddable("347111829")); //true
        System.out.println(isAddable.isAddable("15051101152")); //true
        System.out.println(isAddable.isAddable("15051101153")); //false
        System.out.println(isAddable.isAddable("15141161152")); //false
    }

}
