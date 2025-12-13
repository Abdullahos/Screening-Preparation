package arrays;

//https://leetcode.com/problems/remove-digit-from-number-to-maximize-result
public class RemoveDigitFromNumberToMaximizeResult {
    public String removeDigit(String number, char digit) {
        String max = "0";

        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) == digit) {
                String current = number.substring(0, i) + number.substring(i + 1);
                if (current.compareTo(max) > 0) {
                    max = current;
                }
            }
        }
        return max;
    }


    class EnhancedSolution {
        public String removeDigit(String number, char digit) {
            int i = 0;
            int digitAsNum = Integer.parseInt(String.valueOf(digit));

            while (i < number.length() && number.indexOf(digit, i) != -1) {

                int idx = number.indexOf(digit, i);

                if (idx + 1 < number.length() && (Integer.parseInt(number.charAt(idx + 1) + "")) > digitAsNum) {
                    return number.substring(0, idx) + number.substring(idx + 1);
                }

                i = idx + 1;
            }

            int idx = number.lastIndexOf(digit);
            return number.substring(0, idx) + number.substring(idx + 1);
        }
    }


}
