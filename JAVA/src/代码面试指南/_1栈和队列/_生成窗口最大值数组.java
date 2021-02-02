package 代码面试指南._1栈和队列;

import sun.awt.util.IdentityArrayList;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: wangdarui
 * @created: 2020/11/30
 */
public class _生成窗口最大值数组 {
    public static void main(String[] args) {
        int[] nums = {4, 3, 5, 4, 3, 3, 6, 7};
        int[] ans = getWindowMaxNum(nums, 3);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] getWindowMaxNum(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int[] ans = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.addLast(i);
            if (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            if (i + 1 >= k) {
                ans[i + 1 - k] = nums[deque.peekFirst()];
            }
        }
        return ans;
    }
}
