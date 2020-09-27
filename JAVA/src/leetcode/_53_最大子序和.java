package leetcode;

/**
 * @author: wangdarui
 * @created: 2020/9/27
 */
public class _53_最大子序和 {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        int head = 0;
        for (int num : nums) {
            head = Math.max(head + num, num);
            max = Math.max(max, head);
        }
        return max;
    }
}
