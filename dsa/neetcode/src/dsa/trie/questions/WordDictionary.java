package dsa.trie.questions;

/**
 * @author vkiprono
 * @created 12/13/23
 */


/**
 * 211. Design Add and Search Words Data Structure
 * Design a data structure that supports adding new words and finding if a string matches any previously added string.
 *
 * Implement the WordDictionary class:
 *
 *     WordDictionary() Initializes the object.
 *     void addWord(word) Adds word to the data structure, it can be matched later.
 *     bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise.
 *     word may contain dots '.' where dots can be matched with any letter.
 */
public class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        for (int i = 0 ; i < word.length(); i++){
            int index = word.charAt(i) - 'a';

            if (node.children[index] == null){
                node.children[index] = new TrieNode();
            }
            node = node.children[index];

        }
        node.isLeaf = true;
    }

    public boolean search(String word) {

        return searchInNode(word, root);
    }
    private boolean searchInNode(String word, TrieNode node){

        for (int i = 0; i < word.length(); i++){
            char c = word.charAt(i);

            if (c == '.'){
                for (TrieNode child : node.children){
                    if (child != null && searchInNode(word.substring(i+1), child)){
                        return true;
                    }
                }
                return false;
            }
            else {
                int index = c - 'a';
                if (node.children[index] == null){
                    return false;
                }
                node = node.children[index];
            }
        }
        return node.isLeaf;
    }

}
 class TrieNode{
    TrieNode[] children;
    boolean isLeaf;

    public TrieNode(){
        children = new TrieNode[26];
    }
}
