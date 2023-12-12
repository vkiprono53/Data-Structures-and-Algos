package dsa.trie;

import java.util.Map;

/**
 * @author vkiprono
 * @created 12/12/23
 */

public class TrieImpl {
    TrieNode root;



    public TrieImpl() {
        this.root = new TrieNode();
    }

    public static void main(String[] args) {
        TrieImpl trie = new TrieImpl();
        trie.insert("and");
        System.out.println(trie.search("ant"));

    }

    /**
     * Insert
     * @param word
     */
    public void insert(String word) {
        Map<Character, TrieNode> children = root.children;

        for (int i = 0; i < word.length(); i++) {
            TrieNode newNode = new TrieNode();
            char c = word.charAt(i);
            if (children.containsKey(c)) {
                newNode = children.get(c);
            } else {
                newNode.c = c;
                children.put(c, newNode);
            }

            children = newNode.children;
            if (i == word.length() - 1) {
                newNode.isLeaf = true;
            }
        }
    }

    /**
     * Search a whole word
     * @param word
     * @return
     */
    public boolean search(String word){
        Map<Character, TrieNode> children = root.children;
        TrieNode node = null;

        for (int i = 0; i < word.length(); i++){
            char c = word.charAt(i);

            if (children.containsKey(c)){
                node = children.get(c);
                children = node.children;
            }
            else{
                node = null;
                break;
            }
        }
        return (node != null && node.isLeaf);
    }

}
