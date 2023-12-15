package dsa.trie.questions;

/**
 * @author vkiprono
 * @created 12/14/23
 */

/**
 * LEETCODE 208. Implement Trie (Prefix Tree)
 * A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store
 * and retrieve keys in a dataset of strings. There are various applications of this data structure,
 * such as autocomplete and spellchecker.
 *
 * Implement the Trie class:
 */
public class Trie {

    Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node current = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (current.children[index] == null) {
                current.children[index] = new Node();
            }
            current = current.children[index];
        }
        current.isLeaf = true;
    }

    public boolean search(String word) {
        Node current = root;

        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';

            if (current.children[index] == null) {
                return false;
            }
            current = current.children[index];
        }
        return current != null && current.isLeaf;
    }

    public boolean startsWith(String prefix) {
        Node temp = root;

        for (int i = 0; i < prefix.length(); i++){
            int index = prefix.charAt(i) - 'a';
            if (temp.children[index] == null){
                temp = null;
                break;
            }
            temp = temp.children[index];
        }
        return temp != null;
    }
}

class Node {
    Node[] children;
    boolean isLeaf;

    public Node() {
        children = new Node[26];
        isLeaf = false;
    }
}
