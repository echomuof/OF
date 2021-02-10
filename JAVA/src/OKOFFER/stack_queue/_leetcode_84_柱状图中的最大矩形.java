package OKOFFER.stack_queue;

import java.util.Stack;

/**
 * @author: wangdarui
 * @created: 2021/2/2
 */
public class _leetcode_84_柱状图中的最大矩形 {

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        int i = largestRectangleArea(heights);
        System.out.println(i);
    }

    public static int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int ans = Integer.MIN_VALUE;
        //以height[i]为高时，找最大宽度，即两边第一个比自己小的之间的长度即为最大宽度
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                ans = Math.max(ans, heights[stack.pop()] * (i - 1 - stack.peek()));
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            ans = Math.max(ans, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        }
        return ans;
    }
}
