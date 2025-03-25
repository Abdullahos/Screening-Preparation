package arrays;

public class PalindromePermutation {

    private static boolean isPalindromePermutation(String str) {
        str = str.toLowerCase();
        int[] freq = new int[26];

        for (int i = 0; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i))) {
                freq[str.charAt(i) - 'a']++;
            }
        }

        boolean alreadyOdd = false;
        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 != 0) {
                if (alreadyOdd) {
                    return false;
                }
                alreadyOdd = true;
            }
        }

        return true;

    }

    public static void main(String[] args) {
        System.out.println(isPalindromePermutation("tactcoapapa")); //odd
        System.out.println(isPalindromePermutation("tactcooapapa")); //even

        System.out.println(isPalindromePermutation("taco cat"));    //space
        System.out.println(isPalindromePermutation("taco.cat"));    //special character

        System.out.println(isPalindromePermutation("tacoccat"));    //more that one odd

    }

}
