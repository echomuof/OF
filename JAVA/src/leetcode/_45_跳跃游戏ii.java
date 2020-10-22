package leetcode;

/**
 * @author: wangdarui
 * @created: 2020/10/20
 */
public class _45_跳跃游戏ii {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        jump(nums);
    }

    public static int jump(int[] nums) {
        int end = 0;
        int maxPosition = 0;
        int ans = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if (i == end) {
                end = maxPosition;
                ans++;
            }
        }
        return ans;
    }
}
