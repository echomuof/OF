package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: wangdarui
 * @date: 2020/9/19
 */
public class _84_柱状图中的最大矩形 {
    public static void main(String[] args) {
        int[] arr = {6, 7, 5, 2, 4, 5, 9, 3};
        System.out.println(largestRectangleArea(arr));
    }

    /**
     * 单调栈
     * @param heights
     * @return
     */
    public static int largestRectangleArea(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        Deque<Integer> stack = new LinkedList<>();
        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                maxArea = Math.max(maxArea, heights[stack.pop()] * (i - 1 - stack.peek()));
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            maxArea = Math.max(maxArea, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        }
        return maxArea;
    }

    public static int largestRectangleArea2(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            int left = i;
            int right = i;
            while (left > 0 && heights[left - 1] >= heights[i]) {
                left--;
            }
            while (right < heights.length - 1 && heights[right + 1] >= heights[i]) {
                right++;
            }
            maxArea = Math.max(maxArea, heights[i] * (right - left + 1));
        }
        return maxArea;
    }
}
