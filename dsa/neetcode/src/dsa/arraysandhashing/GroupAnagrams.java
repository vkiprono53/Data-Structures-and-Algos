package dsa.arraysandhashing;

import java.util.*;

/**
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 * <p>
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 * <p>
 * Example 1:
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 */
public class GroupAnagrams {
    public static void main(String[] args) {

        String word = "eat";
        char[] charArr = word.toCharArray();
        Arrays.sort(charArr);
        System.out.println(new String(charArr));
        String[] strsArrays = {"eat", "tea", "tan", "ate", "nat", "bat"};


        System.out.println(groupAnagrams1(strsArrays));
        System.out.println(groupAnagrams22(strsArrays));
    }

    /**
     *
     * Solution 1 :
     * Time Complexity - O(nklogk)
     * Space complexity - O(nk)
     * @return
     */
    public static List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();
        //Loop through the array:
        for (String word : strs) {
            char[] charString = word.toCharArray();
            Arrays.sort(charString);
            String outputString = new String(charString);
            if (map.containsKey(outputString)) {
                map.get(outputString).add(word);
            } else {
                List<String> myList = new ArrayList<>();
                 myList.add(word);
                map.put(outputString, myList);
            }
        }

        return new ArrayList<>(map.values());
    }

    public static List<List<String>> groupAnagrams1(String[] strs) {
        if(strs == null || strs.length == 0){
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String word : strs){
            char[] letters = word.toCharArray();
            Arrays.sort(letters);
            String sortedWord = String.valueOf(letters);

            if (map.containsKey(sortedWord)){
                map.get(sortedWord).add(word);
            }
            else {
                List<String> myList = new ArrayList<>();
                myList.add(word);
                map.put(sortedWord, myList);
            }
        }

        return new ArrayList<>(map.values());
    }

    public static List<List<String>> groupAnagrams22(String[] strs) {

        if(strs == null || strs.length == 0)
            return new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();
        for(String s: strs) {

            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String str = String.valueOf(ch);

            if(!map.containsKey(str)) {
                map.put(str, new ArrayList<>());
            }

            map.get(str).add(s);
        }


        return new ArrayList<>(map.values());
    }
}
