package dsa.arraysandhashing;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

public class GroupAnagramsLeetcode {
    public static void main(String[] args) {

        GroupAnagramsLeetcode anagrams = new GroupAnagramsLeetcode();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(anagrams.groupAnagrams(strs));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if (strs.length < 1) {
            return result;
        }
        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {
            char[] wordChar = word.toCharArray();
            Arrays.sort(wordChar);
            String outputStr = new String(wordChar);
            if (map.containsKey(outputStr)) {
                map.get(outputStr).add(word);
            } else {
                List<String> myList = new ArrayList<>();
                myList.add(word);
                map.put(outputStr, myList);
            }
        }
        return new ArrayList<>(map.values());
    }
}
