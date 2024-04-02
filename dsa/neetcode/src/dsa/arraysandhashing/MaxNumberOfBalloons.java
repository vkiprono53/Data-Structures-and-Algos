package dsa.arraysandhashing;

import java.util.Map;
import java.util.HashMap;

/**
 * LEETCODE 1189. Maximum Number of Balloons
 * Given a string text, you want to use the characters of text to form as many instances of the word
 * "balloon" as possible.
 * <p>
 * You can use each character in text at most once. Return the maximum number of instances
 * that can be formed.
 * <p>
 * Example
 * Input: text = "loonbalxballpoon"
 * Output: 2
 * <p>
 * Example 3:
 * <p>
 * Input: text = "leetcode"
 * Output: 0
 */
public class MaxNumberOfBalloons {
    public static void main(String[] args) {

        String text = "loonbalxballpoon";
        MaxNumberOfBalloons balloons = new MaxNumberOfBalloons();
        System.out.println(balloons.maxNumberOfBalloons(text));
    }

    public int maxNumberOfBalloons(String text) {

        int[] charCount = new int[26];
        for (int i = 0; i < text.length(); i++) {
            charCount[text.charAt(i) - 'a']++;
        }

        int min = charCount[1];//b
        min = Math.min(min, charCount[0]);//a
        min = Math.min(min, charCount[11] / 2);//l
        min = Math.min(min, charCount[14] / 2); //0
        min = Math.min(min, charCount[13]); //n

        return min;
    }
}
