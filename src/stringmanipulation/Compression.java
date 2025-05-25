package stringmanipulation;
//Note that sb double its size when it’s full
public class Compression {

    private static String compress(String str) {
        StringBuilder sb = new StringBuilder();

        int i = 0, j = 1;
        while (i < str.length() && j < str.length()) {
            if (str.charAt(i) != str.charAt(j)) {
                sb.append(str.charAt(i)).append(j - i);
                i = j;
            }
            j++;
        }
        if (j > str.length() && i < str.length()) {
            sb.append(str.charAt(i - 1)).append(j - i);
        }

        String compressed = sb.toString();
        return !compressed.isEmpty() && compressed.length() < str.length()? compressed : str;
    }

    public static void main(String[] args) {
        System.out.println(compress("aab"));
        System.out.println(compress("a"));
        System.out.println(compress(""));
        System.out.println(compress(" "));
        System.out.println(compress("aabcccaaa"));
        System.out.println(compress("abcd"));
    }
}
