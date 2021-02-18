package OKOFFER.stack_queue;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: wangdarui
 * @created: 2021/2/2
 */
public class _ZUO_单调栈 {

    /**
     * 没有重复的情况
     *
     * @param nums
     * @return
     */
    public int[][] getNearLessNoRepeat(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[][] ans = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                Integer cur = stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek();
                ans[cur][0] = left;
                ans[cur][1] = i;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            Integer cur = stack.pop();
            int left = stack.isEmpty() ? -1 : stack.peek();
            ans[cur][0] = left;
            ans[cur][1] = -1;
        }
        return ans;
    }

    /**
     * 有重复的情况
     *
     * @param nums
     * @return
     */
    public int[][] getNearLess(int[] nums) {
        Stack<List<Integer>> stack = new Stack<>();
        int[][] ans = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek().get(0)] > nums[i]) {
                List<Integer> pop = stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);
                for (Integer popi : pop) {
                    ans[popi][0] = left;
                    ans[popi][1] = i;
                }
            }
            if (!stack.isEmpty() && nums[stack.peek().get(0)] == nums[i]) {
                stack.peek().add(i);
            } else {
                ArrayList<Integer> cur = new ArrayList<>();
                cur.add(i);
                stack.push(cur);
            }
        }
        while (!stack.isEmpty()) {
            List<Integer> pop = stack.pop();
            int left = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);
            for (Integer popi : pop) {
                ans[popi][0] = left;
                ans[popi][1] = -1;
            }
        }
        return ans;
    }

}
