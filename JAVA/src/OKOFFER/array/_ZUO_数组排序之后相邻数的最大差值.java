package OKOFFER.array;

import java.util.Stack;

/**
 * @author: wangdarui
 * @created: 2021/2/16
 */
public class _ZUO_数组排序之后相邻数的最大差值 {

    public static void main(String[] args) {
        int[] nums = {9, 3, 1, 10};
        System.out.println(maxGap(nums));
    }

    public static int maxGap(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int ans = Integer.MIN_VALUE;
        for (int num : nums) {
            while (!stack.isEmpty() && stack.peek() >= num) {
                Integer pop = stack.pop();
                if (!stack.isEmpty()) {
                    ans = Math.max(ans, pop - stack.peek());
                }
            }
            stack.push(num);
        }
        return ans;
    }
}
