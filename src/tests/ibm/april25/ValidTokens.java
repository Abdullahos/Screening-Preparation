package tests.ibm.april25;

import java.util.HashSet;
import java.util.Set;

public class ValidTokens {



    public static int countValidTokens(String tokenString) {
        Set<Character> consonant = new HashSet<>();
        consonant.add('b');
        consonant.add('c');
        consonant.add('d');
        consonant.add('f');
        consonant.add('g');
        consonant.add('h');
        consonant.add('j');
        consonant.add('k');
        consonant.add('l');
        consonant.add('m');
        consonant.add('n');
        consonant.add('p');
        consonant.add('q');
        consonant.add('r');
        consonant.add('s');
        consonant.add('t');
        consonant.add('v');
        consonant.add('w');
        consonant.add('x');
        consonant.add('y');
        consonant.add('z');

        int counts = 0;
        for (String tkn : tokenString.split(" ")) {
            if (isValid(tkn, consonant)) {
                counts++;
            }
        }
        return counts;
    }

    private static boolean isValid(String tkn, Set<Character> consonantSet) {
        if (tkn.length() < 3) {
            return false;
        }

        if (!(tkn.contains("a") || tkn.contains("e") || tkn.contains("i") || tkn.contains("o") || tkn.contains("u") || tkn.contains("A") || tkn.contains("E") || tkn.contains("I") || tkn.contains("O") || tkn.contains("U"))) {
            return false;
        }

        boolean anyConsant = false;
        for (char c : tkn.toCharArray()) {
            if (!(Character.isAlphabetic(c) || Character.isDigit(c))) {
                return false;
            }

            if (!anyConsant && consonantSet.contains(Character.toLowerCase(c))) {
                anyConsant = true;
            }
        }

        return anyConsant;
    }




    public static void main(String[] args) {
        ValidTokens tst = new ValidTokens();
        System.out.println(tst.countValidTokens("ieO MyWBN1 ap PAKkZHGhK78pCE2 O063RmVm6E C0e4RvY6Dve 3Vry2c9yg75i feVaa61vDfArhIYe 7i7pMlO43pVHF TBOL9Qh6ED0N k1kWdud4s7arXbx 7AMyZF90tbATa5e"));
    }

}
