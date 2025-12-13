package arrays;

import java.util.Objects;

public class Mult2Numbers {
    public String multiply(String num1, String num2) {

        String bigger;
        String smaller;

        if (num1.compareTo(num2) >= 0) {
            bigger = num1;
            smaller = num2;
        } else {
            bigger = num2;
            smaller = num1;
        }

        if (smaller.equals("0")) {
            return smaller;
        }

        String[] subResult = new String[smaller.length()];
        for (int i = smaller.length() - 1; i >= 0; i--) {
            subResult[smaller.length() - i - 1] = multiplyBiggerBySmaller(bigger, smaller.charAt(i)) + "0".repeat(smaller.length() - 1 - i);
        }

        StringBuilder sb = new StringBuilder();
        sum(subResult, sb);

        return sb.toString();
    }


    private String multiplyBiggerBySmaller(String num, char digitChar) {
        StringBuilder res = new StringBuilder();
        int acc = 0;
        int digit = Integer.parseInt(String.valueOf(digitChar));

        for (int i = num.length() - 1; i >= 0; i--) {
            char c = num.charAt(i);
            int n = Integer.parseInt(c + "");
            int m = n * digit + acc;

            if (m > 9) {
                acc = m / 10;
                m -= acc * 10;
            } else {
                acc = 0;
            }

            res.insert(0, m);
        }

        if (acc != 0) {
            res.insert(0, acc);
        }

        return res.toString();
    }

    private void sum(String[] subResult, StringBuilder sb) {
        int w = String.valueOf(Integer.MAX_VALUE).length() - 1;
        boolean anyNonEmpty;
        int sum;
        int carry = 0;

        while (true) {
            anyNonEmpty = false;
            sum = 0;
            for (int i = 0; i < subResult.length; i++) {
                String numString = subResult[i];
                if (numString.isEmpty()) continue;

                anyNonEmpty = true;

                String remainingString = "";
                if (numString.length() > w) {
                    numString = numString.substring(numString.length() - w);
                    remainingString = numString.substring(0, numString.length() - w);

                }

                sum += Integer.parseInt(numString);

                subResult[i] = remainingString;
            }

            sum += carry;
            carry = 0;

            if (!anyNonEmpty && sum == 0) {
                break;
            }

            String sumAsString = String.valueOf(sum);

            if (sumAsString.length() == w + 1) {
                carry = sumAsString.charAt(0);
                sumAsString = sumAsString.substring(1);
            }

            sb.insert(0, sumAsString);
        }
    }

    /** TODO: Try to make this work
     * class Solution {
     *     public String multiply(String num1, String num2) {
     *
     *         String bigger;
     *         String smaller;
     *
     *         if (num1.compareTo(num2) >= 0) {
     *             bigger = num1;
     *             smaller = num2;
     *         } else {
     *             bigger = num2;
     *             smaller = num1;
     *         }
     *
     *         if (smaller.equals("0")) {
     *             return smaller;
     *         }
     *
     *         String[] subResult = new String[smaller.length()];
     *         for (int i = smaller.length() - 1; i >= 0; i--) {
     *             subResult[smaller.length() - i - 1] = multiplyBiggerBySmaller(bigger, smaller.charAt(i)) + "0".repeat(smaller.length() - 1 - i);
     *         }
     *
     *         StringBuilder sb = new StringBuilder();
     *         sum(subResult, sb);
     *
     *         return sb.toString();
     *     }
     *
     *
     *     private String multiplyBiggerBySmaller(String num, char digitChar) {
     *         StringBuilder res = new StringBuilder();
     *         int acc = 0;
     *         int digit = Integer.parseInt(String.valueOf(digitChar));
     *
     *         for (int i = num.length() - 1; i >= 0; i--) {
     *             char c = num.charAt(i);
     *             int n = Integer.parseInt(c + "");
     *             int m = n * digit + acc;
     *
     *             if (m > 9) {
     *                 acc = m / 10;
     *                 m -= acc * 10;
     *             } else {
     *                 acc = 0;
     *             }
     *
     *             res.insert(0, m);
     *         }
     *
     *         if (acc != 0) {
     *             res.insert(0, acc);
     *         }
     *
     *         return res.toString();
     *     }
     *
     *     private void sum(String[] subResult, StringBuilder sb) {
     *         int w = String.valueOf(Integer.MAX_VALUE).length() - 1;
     *         boolean anyNonEmpty = true;
     *         int sum;
     *         StringBuilder carrySb = StringBuilder();
     *
     *         while (true) {
     *             anyNonEmpty = false;
     *             sum = 0;
     *             for (int i = 0; i < subResult.length; i++) {
     *                 String numString = subResult[i];
     *                 if (numString.isEmpty()) continue;
     *
     *                 anyNonEmpty = true;
     *
     *                 String remainingString = "";
     *                 int size = numString.length();
     *
     *                 if (size > w) {
     *                     remainingString = numString.substring(0, size - w);
     *                     numString = numString.substring(size - w);
     *                 }
     *
     *                 sum += Integer.parseInt(numString);
     *                 String sumAsString = String.valueOf(sum);
     *
     *                 //it can overflow on next addition
     *                 if (sumAsString.length() == w + 1) {
     *                     carrySb = Integer.parseInt(carrySb.toString()) + Integer.parseInt(String.valueOf(sumAsString.charAt(0));
     *                     sumAsString = sumAsString.substring(1);
     *                     sum = Integer.parseInt(sumAsString);
     *                 }
     *
     *                 subResult[i] = remainingString;
     *             }
     *
     *
     *             sum += carry;
     *             carry = 0;
     *
     *             if (!anyNonEmpty && sum == 0) {
     *                 break;
     *             }
     *
     *             String sumAsString = String.valueOf(sum);
     *
     *             if (sumAsString.length() == w + 1) {
     *                 carry = sumAsString.charAt(0);
     *                 sumAsString = sumAsString.substring(1);
     *             }
     *
     *             sb.insert(0, sumAsString);
     *         }
     *     }
     * }
     */
}
