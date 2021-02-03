package OKOFFER.stack_queue;

import java.util.Stack;

/**
 * @author: wangdarui
 * @created: 2021/2/2
 */
public class _leetcode_42_接雨水 {

    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        int current = 0;
        while (current < height.length) {
            while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
                int h = height[stack.pop()];
                if (stack.isEmpty()) break;
                int distance = current - stack.peek() - 1;
                int min = Math.min(height[stack.peek()], height[current]);
                ans += distance * (min - h);
            }
            stack.push(current);
            current++;
        }
        return ans;
    }

}



