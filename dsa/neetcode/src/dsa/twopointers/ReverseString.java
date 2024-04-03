package dsa.twopointers;

/**
 * LEETCODE 344. Reverse String
 * <p>
 * Write a function that reverses a string. The input string is given as an array of characters s.
 * <p>
 * You must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 * Example 1:
 * <p>
 * Input: s = ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 */
public class ReverseString {
    public static void main(String[] args) {

        ReverseString reverseString = new ReverseString();
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        reverseString.reverseString(s);
    }

    /**
     * Using Two pointer
     * Space Complexity- (1)
     * Time Complexity - O(1)
     */
    public void reverseString(char[] s) {
        int first = 0;
        int last = s.length - 1;

        while (first < last) {
            char temp = s[first];
            s[first] = s[last];
            s[last] = temp;
            first++;
            last--;
        }
    }

    /**
     * Time Complexity - O(n)
     * Space Complexity - O(1)
     */
    public void reverseString1(char[] s) {
        StringBuilder output = new StringBuilder();
        for (int i = s.length - 1; i >= 0; i--) {
            output.append(s[i]);
        }
        for (int i = 0; i < s.length; i++) {
            s[i] = output.charAt(i);
        }
    }


}
