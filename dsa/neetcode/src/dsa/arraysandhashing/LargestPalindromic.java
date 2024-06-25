package dsa.arraysandhashing;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode 2384. Largest Palindromic Number
 * <p>
 * You are given a string num consisting of digits only.
 * <p>
 * Return the largest palindromic integer (in the form of a string) that can be formed using digits
 * taken from num. It should not contain leading zeroes.
 * <p>
 * Notes:
 * <p>
 * You do not need to use all the digits of num, but you must use at least one digit.
 * The digits can be reordered.
 */
public class LargestPalindromic {
    public static void main(String[] args) {
        LargestPalindromic palindromic = new LargestPalindromic();
        String num = "00000";
        System.out.println(palindromic.largestPalindromic(num));
        //System.out.println(palindromic.largestPalindromic2(num));
    }

    public String largestPalindromic(String num) {

        Map<Integer, Integer> mapCount = new HashMap<>();
        for (char c : num.toCharArray()) {
            mapCount.put(c - '0', mapCount.getOrDefault(c - '0', 0) + 1);
        }

        String center = "";
        StringBuilder half = new StringBuilder();

        for (int digit = 9; digit >= 0; digit--) {

            if (mapCount.containsKey(digit) && mapCount.get(digit) > 1) {
                if (digit != 0 ||
                        (digit == 0 && !half.isEmpty() && half.length() > 0)) {
                    for (int i = 0; i < mapCount.get(digit) / 2; i++) {
                        half.append(digit);
                    }
                    mapCount.put(digit, mapCount.get(digit) % 2);
                }
            }

            if (mapCount.containsKey(digit) && mapCount.get(digit) == 1 && center.isEmpty()) {
                center = String.valueOf(digit);
                mapCount.put(digit, mapCount.get(digit) - 1);
            }

        }
        StringBuilder output = new StringBuilder();

        output.append(half).append(center).append(half.reverse());
        if (output.length() < 1) {
            return "0";
        }
        return output.toString();

    }

}
