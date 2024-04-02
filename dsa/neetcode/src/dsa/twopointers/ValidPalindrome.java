package dsa.twopointers;

/**
 * LEETCODE 125. Valid Palindrome
 * <p>
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters
 * and removing all non-alphanumeric characters, it reads the same forward and backward.
 * Alphanumeric characters include letters and numbers.
 * <p>
 * Given a string s, return true if it is a palindrome, or false otherwise.
 * <p>
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 */
public class ValidPalindrome {
    public static void main(String[] args) {

        String s = "A man, a plan, a canal: Panama";
        String s1 = "0P";
        System.out.println(isPalindrome(s1));
        System.out.println(isPalindrome2(s1));
    }

    public static boolean isPalindrome(String s) {

        StringBuilder in = new StringBuilder();
        StringBuilder output = new StringBuilder();
        String inputString = "";

        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                in.append(s.charAt(i));
            }
        }
        inputString = in.toString();

        for (int i = inputString.length() - 1; i >= 0; i--) {
            output.append(inputString.charAt(i));
        }

        return inputString.equalsIgnoreCase(output.toString());
    }

    /**
     *Space Complexity - O(1)
     * Time Complexity - O(n)
     */
    public static boolean isPalindrome2(String s) {
        String temp = s.trim().toLowerCase().replaceAll("[^a-z0-9]", "");
        int first = 0;
        int last = temp.length() - 1;

        while (first < last) {
            if (temp.charAt(first) == temp.charAt(last)) {
                first++;
                last--;
            } else {
                return false;
            }
        }
        return true;
    }
}
