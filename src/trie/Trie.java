package trie;

import java.util.*;

public class Trie {
    Character c;
    Map<Character, Trie> children;
    boolean valid;

    public Trie() {
        this.children = new HashMap<>();
    }

    public Trie(char c) {
        this.c = c;
        this.children = new HashMap<>();
    }

    public Trie findChild(char val) {
        return children.get(val);
    }

    public boolean hasChild(char val) {
        return children.containsKey(val);
    }

    public Trie addChild(char val) {
        Trie child = new Trie(val);
        child.valid = true;
        this.children.put(val, child);
        return child;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass())
            return false;
        Trie trie = (Trie) o;
        return Objects.equals(c, trie.c);
    }

    @Override
    public int hashCode() {
        return Objects.hash(c);
    }
}
