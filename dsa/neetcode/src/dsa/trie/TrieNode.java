package dsa.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * @author vkiprono
 * @created 12/12/23
 */

public class TrieNode {
    public boolean isLeaf;
    public char c;
    public Map<Character, TrieNode> children = new HashMap<>();

    public TrieNode() {
    }

    public TrieNode(char c) {
        this.c = c;
    }
}
