package stringmanipulation;

public class OneWay {

    //t: (n), s O(1)
    private boolean oneWay(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();

        if (Math.abs(l1 - l2) > 1) {
            return false;
        }

        int i = 0;
        int j = 0;

        boolean edited = false;

        while (i < l1 && j < l2) {
            if (s1.charAt(i) != s2.charAt(j)) {
                if (edited) {
                    return false;
                }
                edited = true;

                if (i + 1 < l1 && s1.charAt(i + 1) == s2.charAt(j)) {
                    i++;
                }
                else if (j + 1 < l2 && s2.charAt(j + 1) == s1.charAt(i)) {
                    j++;
                }
            }
            i++;
            j++;
        }
        return true;
    }
    
    public static void main(String[] args) {
        OneWay oneWay = new OneWay();

        System.out.println(oneWay.oneWay("pale", "ple"));

        System.out.println(oneWay.oneWay("pales", "pale"));

        System.out.println(oneWay.oneWay("pale", "bale"));

        System.out.println(oneWay.oneWay("pale", "bake"));

        System.out.println(oneWay.oneWay("", ""));

        System.out.println(oneWay.oneWay(" ", ""));

        System.out.println(oneWay.oneWay("", " "));

        System.out.println(oneWay.oneWay(" ", " "));

    }

}
