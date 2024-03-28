package dsa.arraysandhashing;

public class LongestCommonPrefix {
    public static void main(String[] args) {

        LongestCommonPrefix commonPrefix = new LongestCommonPrefix();
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(commonPrefix.longestCommonPrefix(strs));

    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }
}
