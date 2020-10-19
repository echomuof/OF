package leetcode;

/**
 * @author: wangdarui
 * @created: 2020/10/19
 */
public class _300_最长上升子序列 {
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        _300_最长上升子序列 a = new _300_最长上升子序列();
        System.out.println(a.lengthOfLIS(nums));
    }

    public int lengthOfLIS(int[] nums) {
        return process(nums, 1);
    }

    public int process(int[] nums, int i) {
        int cur = 1;
        for (int j = 0; j < i; j++) {
            if (nums[j] < nums[i])
                cur = Math.max(cur, process(nums, j) + 1);
        }
        return cur;
    }
}
