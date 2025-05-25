package trie;

import java.util.*;

class LongestDictionaryWord {
    public String longestWord(String[] words) {
        Trie trie = new Trie();
        Arrays.sort(words, new Comp());

        String longestWord = "";
        for (String word : words) {
            String w = addWord(trie, word);
            if (w != null && (w.length() > longestWord.length()
                    || (w.length() == longestWord.length() && w.compareTo(longestWord) < 0))) {
                longestWord = word;
            }
        }
        return longestWord;
    }

    public String addWord(Trie trie, String word) {
        if (word == null || word.isEmpty()) {
            return word;
        }
        Trie curr;
        if (!trie.hasChild(word.charAt(0))) {
            if (word.length() > 1) {
                return null;
            }
            Trie child = trie.addChild(word.charAt(0));
        }

        curr = trie.findChild(word.charAt(0));
        for (int i = 1; i < word.length(); i++) {
            if (!curr.valid) {
                return null;
            }
            Trie child = curr.findChild(word.charAt(i));
            if (child == null) {
                if (i != word.length() - 1) {
                    return null;
                }
                curr = curr.addChild(word.charAt(i));
            }
            else {
                curr = child;
            }
        }
        return word;
    }
}

class Comp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int len1 = o1.length();
        int len2 = o2.length();
        if (len1 != len2) {
            return len1 - len2;
        }
        return o1.compareTo(o2);
    }
}

