package 代码面试指南._1栈和队列;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: wangdarui
 * @created: 2020/11/30
 */
public class _单调栈结构 {
    public static void main(String[] args) {

    }

    public int[][] getNearLessNoRepeat(int[] nums) {
        int[][] ans = new int[nums.length][2];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                Integer pop = stack.pop();
                ans[pop][0] = stack.isEmpty() ? -1 : stack.peek();
                ans[pop][1] = nums[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            Integer pop = stack.pop();
            ans[pop][0] = stack.isEmpty() ? -1 : stack.peek();
            ans[pop][1] = -1;
        }
        return ans;
    }

    public int[][] getNearLessRepeat(int[] nums) {
        int[][] ans = new int[nums.length][2];
        Stack<List<Integer>> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek().get(0)] > nums[i]) {
                List<Integer> pop = stack.pop();
                ans[i][0] = stack.isEmpty() ? -1 : pop.get(0);
                ans[i][1] = i;
            }
            if (!stack.isEmpty() && nums[i] == nums[stack.peek().get(0)]) {
                stack.peek().add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                stack.push(list);
            }
        }
        while (!stack.isEmpty()) {
            List<Integer> pop = stack.pop();
            for (Integer popi : pop) {
                ans[popi][0] = stack.isEmpty() ? -1 : stack.peek().get(0);
                ans[popi][1] = -1;
            }
        }
        return ans;
    }
}
