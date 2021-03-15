package OKOFFER.array;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author: wangdarui
 * @created: 2021/2/14
 */
public class _ZUO_找到无序数组中最小的k个数 {

    public static void main(String[] args) {
        int[] nums = {9, 7, 5, 3, 1, 2, 4, 8, 6};
        System.out.println(Arrays.toString(topK(nums, 3)));
    }

    public static int[] topK(int[] nums, int k) {
        if (nums == null || nums.length == 0 || nums.length <= k) return nums;
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, (o1, o2) -> o2 - o1);
        for (int i = 0; i < k; i++) {
            queue.add(nums[i]);
        }
        int[] ans = new int[k];
        for (int i = k; i < nums.length; i++) {
            if (nums[i] < queue.peek()) {
                queue.poll();
                queue.add(nums[i]);
            }
        }
        for (int i = k - 1; i >= 0; i--) {
            ans[i] = queue.poll();
        }
        return ans;
    }


}
