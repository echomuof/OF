package OKOFFER.stack_queue;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: wangdarui
 * @created: 2021/2/2
 */
public class _ZUO_生成窗口最大值数组 {

    public int[] windowMaxVal(int[] nums, int k) {
        if (nums == null || nums.length < k || k == 0) return null;
        List<Integer> ans = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.addLast(i);
            if (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            if (i >= k - 1) {
                ans.add(nums[deque.peekFirst()]);
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

}
