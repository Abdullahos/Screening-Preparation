package arrays;

import java.util.*;

public class PasswordVariations {


    //t: O(n ^ 2), s: O(n)
//    private Set<String> getPasswordVariations(String password) {
//        Set<String> set = new HashSet<>();
//        dfs(password, 0, new StringBuilder(password), set);
//
//        return set;
//    }
//
//    private void dfs(String password, int start, StringBuilder sb, Set<String> visted) {
//
//        for (int i = start; i < password.length(); i++) {
//
//            if (i != start) {
//                sb.delete(i, i + 1);
//                sb.insert(start, password.charAt(i));
//
//                if (!sb.toString().equals(password) && !visted.contains(sb.toString())) {
//                    visted.add(sb.toString());
//                }
//
//            }
//
//            dfs(password, i + 1, new StringBuilder(sb), visted);
//        }
//    }


    static class TrieNode {
        TrieNode root;
        Map<Character, TrieNode> children;
        long uniqueWordsCounts;
        boolean isNew;

        public TrieNode() {
            children = new HashMap<>();
            uniqueWordsCounts = 0;
        }

        public void add(StringBuilder word) {
            TrieNode curr = root;

            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                Map<Character, TrieNode> children = curr.children;

                if (children.containsKey(c)) {
                    curr = children.get(c);
                } else {
                    children.put(c, new TrieNode());
                    isNew = true;
                }
                if (isNew) {
                    uniqueWordsCounts++;
                }
            }
        }
    }

    private Long getPasswordVariations2(String password) {
        TrieNode trie = new TrieNode();
        for (int l = 0; l < password.length(); l++) {
            for (int r = l; r < password.length(); r++) {

                StringBuilder sb = new StringBuilder();
                sb.append(password, 0, l);
                sb.append(new StringBuilder(password.substring(l, r + 1)).reverse());
                sb.append(password.substring(r + 1));

                trie.add(sb);
            }
        }

        return trie.uniqueWordsCounts;
    }


    public static void main(String[] args) {
//        PasswordVariations vp1 = new PasswordVariations();
//        System.out.println(vp1.getPasswordVariations("abc"));

//        PasswordVariations vp2 = new PasswordVariations();
//        System.out.println(vp2.getPasswordVariations("abaa"));

        PasswordVariations vp3 = new PasswordVariations();
        System.out.println(vp3.getPasswordVariations2("abcd"));


    }
}
