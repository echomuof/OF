package OKOFFER.stack_queue;

import java.util.Stack;

/**
 * @author: wangdarui
 * @created: 2021/2/2
 */
public class _ZUO_求最大子矩阵的大小 {

    public int maxMatrixArea(int[][] map) {
        if (map == null || map.length == 0 || map[0].length == 0) return 0;
        int maxArea = Integer.MIN_VALUE;
        int[] height = new int[map[0].length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                height[j] = map[i][j] == 0 ? 0 : height[j] + 1;
            }
            maxArea = Math.max(maxArea, maxAreaFromBottom(height));
        }
        return maxArea;
    }

    public int maxAreaFromBottom(int[] height) {
        if (height == null || height.length == 0) return 0;
        int maxArea = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] >= height[i]) {
                Integer cur = stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek();
                maxArea = Math.max(maxArea, height[cur] * (i - left - 1));
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            Integer cur = stack.pop();
            int left = stack.isEmpty() ? -1 : stack.peek();
            maxArea = Math.max(maxArea, height[cur] * (height.length - left - 1));
        }
        return maxArea;
    }

}
