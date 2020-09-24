package leetcode;

/**
 * @author: wangdarui
 * @date: 2020/9/24
 */
public class _55_跳跃游戏 {
    public boolean canJump(int[] nums) {
        if (nums == null) {
            return false;
        }
        int end = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] + i >= end) {
                end = i;
            }
        }
        return end == 0;
    }
}
