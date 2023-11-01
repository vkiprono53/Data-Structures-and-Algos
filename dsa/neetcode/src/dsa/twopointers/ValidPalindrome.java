package dsa.twopointers;

/**
 * LEETCODE 125. Valid Palindrome
 *
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters
 * and removing all non-alphanumeric characters, it reads the same forward and backward.
 * Alphanumeric characters include letters and numbers.
 *
 * Given a string s, return true if it is a palindrome, or false otherwise.
 *
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 *
 */
public class ValidPalindrome {
    public static void main(String[] args) {

        String s = "A man, a plan, a canal: Panama";
        String s1 = "0P";
        System.out.println(isPalindrome(s1));
    }

    public static boolean isPalindrome(String s) {

        StringBuilder in = new StringBuilder();
        StringBuilder output = new StringBuilder();
        String inputString = "";

        for (int i = 0 ; i < s.length(); i++){
            if(Character.isLetterOrDigit(s.charAt(i))){
                in.append(s.charAt(i));
            }
        }
        inputString = in.toString();

        for (int i = inputString.length()-1 ; i >= 0 ; i--){
            output.append(inputString.charAt(i));
        }

        return inputString.equalsIgnoreCase(output.toString());
    }
}
