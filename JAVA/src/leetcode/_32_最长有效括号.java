package leetcode;

import java.util.Stack;

/**
 * @author: wangdarui
 * @created: 2020/10/24
 */
public class _32_最长有效括号 {
    public static void main(String[] args) {
        System.out.println(longestValidParentheses(")()())"));
    }

    public static int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) return 0;
        int[] dp = new int[s.length()];
        dp[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            dp[i] = dp[i - 1] + ((s.charAt(i - 1) == '(' && s.charAt(i) == ')') ? 2 : -1);
        }
        return dp[dp.length - 1] * 2;
    }
}
