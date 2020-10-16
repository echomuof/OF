package 剑指offer;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: wangdarui
 * @created: 2020/10/15
 */
public class _59_i_滑动窗口的最大值 {
    public static void main(String[] args) {
        int[] arr = {1, 3, 1, 2, 0, 5};
        System.out.println(Arrays.toString(maxSlidingWindow(arr, 3)));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        Deque<Integer> queue = new LinkedList<>();
        int[] ans = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && nums[i] > nums[queue.peekLast()]) {
                queue.pollLast();
            }
            queue.addLast(i);
            if (queue.peekFirst() <= i - k) {
                queue.pollFirst();
            }
            if (i + 1 >= k) ans[i - k + 1] = nums[queue.peekFirst()];
        }
        return ans;
    }
}
