package arrays;

public class Urify {

    private String urify(String s, int trueLength) {
        int rightIdx = s.length() - 1;
        for (int i = trueLength - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == ' ') {
                s = s.substring(0, rightIdx - 2) + "%20" + s.substring(rightIdx + 1);
                rightIdx -= 3;
            }
            else {
                s = s.substring(0, rightIdx) + c + s.substring(rightIdx + 1);
                rightIdx--;
            }
        }
        return s.substring((s.length() - trueLength) / 2);
    }

    private String urifySb(String s) {
        String trimmed = s.trim();
        StringBuilder sb = new StringBuilder(trimmed);
        int iProxy = 0;
        for (int i = 0; i < trimmed.length(); i++) {
            char c = trimmed.charAt(i);
            if (c == ' ') {
                sb.delete(iProxy, iProxy + 1);
                sb.insert(iProxy, "%20");
                iProxy += 3;
            }
            else {
                iProxy++;
            }
        }
        return sb.toString();
    }

    private String uriFyBuildIn(String s, int trueLength) {
        String urified = s.replaceAll(" ", "%20");
        return urified.substring(0, (s.length() - trueLength) / 2);
    }

    public static void main(String[] args) {
        Urify urify = new Urify();
        System.out.println(urify.urify("Mr John Smith    ", 13));
        System.out.println(urify.urifySb("Mr John Smith    "));
        System.out.println(urify.uriFyBuildIn("Mr John Smith    ", 13));



//        System.out.println(urify.urify("   ", 0));
//        System.out.println(urify.urifySb("   "));






    }

}
