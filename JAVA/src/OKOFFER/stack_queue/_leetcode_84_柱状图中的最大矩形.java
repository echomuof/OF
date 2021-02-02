package OKOFFER.stack_queue;

import java.util.Stack;

/**
 * @author: wangdarui
 * @created: 2021/2/2
 */
public class _leetcode_84_柱状图中的最大矩形 {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                ans = Math.max(ans, heights[stack.pop()] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            ans = Math.max(ans, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        }
        return ans;
    }
}
