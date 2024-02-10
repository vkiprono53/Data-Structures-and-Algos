package dsa.arraysandhashing;

import java.util.Map;
import java.util.HashMap;

/**
 * @author vkiprono
 * @created 2/8/24
 */

public class WordsMinDistance {
    public static void main(String[] args) {

        String[] s = {"practice", "makes", "perfect", "coding", "makes"};
        String w1 = "practice";
        String w2 = "coding";
        System.out.println(shortestDistance(s, w1, w2));
        System.out.println(shortestDistance1(s, w1, w2));
    }

    //Using HashMap
    public static int shortestDistance(String[] words, String word1, String word2) {

        Map<String, Integer> myMap = new HashMap<>();
        if (word1.equalsIgnoreCase(word2)) {
            return 0;
        }
        int pos = 0;
        for (String word : words) {
            myMap.put(word, pos);
            pos++;
        }
        if (myMap.containsKey(word1) && myMap.containsKey(word2)) {

            return Math.abs(myMap.get(word1) - myMap.get(word2));
        }
        return -1;

    }

    //Space Complexity - O(n)
    public static int shortestDistance1(String[] words, String word1, String word2) {
        if (word1.equalsIgnoreCase(word2)) {
            return 0;
        }
        int index1 = -1;
        int index2 = -1;

        for (int i = 0; i < words.length; i++) {
            if (words[i].equalsIgnoreCase(word1)) {
                index1 = i;
            }
            if (words[i].equalsIgnoreCase(word2)) {
                index2 = i;
            }
        }
        return Math.abs(index1 - index2);
    }
}
