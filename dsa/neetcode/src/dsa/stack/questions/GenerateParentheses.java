package dsa.stack.questions;

import java.util.List;
import java.util.ArrayList;

/**
 * LLETCODE 22. Generate Parentheses
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * <p>
 * Example 2:
 * <p>
 * Input: n = 1
 * Output: ["()"]
 */
public class GenerateParentheses {
    public static void main(String[] args) {
        GenerateParentheses parentheses = new GenerateParentheses();
        int n = 3;
        System.out.println(parentheses.generateParenthesis(n));
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backTrack(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    private void backTrack(List<String> result, StringBuilder sb, int open, int close, int n) {
        if (open == n && close == n) {
            result.add(sb.toString());
            return;
        }
        if (open < n) {
            sb.append("(");
            backTrack(result, sb, open + 1, close, n);
            sb.setLength(sb.length() - 1);
        }
        if (close < open) {
            sb.append(")");
            backTrack(result, sb, open, close + 1, n);
            sb.setLength(sb.length() - 1);
        }
    }
}
