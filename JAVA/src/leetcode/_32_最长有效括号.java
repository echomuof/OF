package leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author: wangdarui
 * @created: 2020/10/24
 */
public class _32_最长有效括号 {
    public static void main(String[] args) {
        System.out.println(longestValidParentheses("()(()"));
    }

    public static int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) return 0;
        int[] dp = new int[s.length()];
        Deque<Integer> deque = new LinkedList<>();
        deque.offerLast(0);
        for (int i = 1; i < s.length(); i++) {
            char cur = s.charAt(i);
            dp[i] = dp[i - 1];
            if (!deque.isEmpty() && cur == ')' && s.charAt(deque.peekLast()) == '(') {
                deque.pollLast();
                dp[i] += 2;
            } else {
                deque.offerLast(i);
            }
        }
        int max = Integer.MIN_VALUE;
        int step = 0;
        for (int i = 0; i < dp.length; i++) {
            Integer pollFirst = deque.pollFirst();
            if (!deque.isEmpty() && pollFirst != deque.peekFirst() - 1) {
                step += 2;
            } else {
                deque.offerFirst(pollFirst);
            }
            dp[i] -= step;
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
