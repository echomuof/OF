package OKOFFER.array;

import java.util.Arrays;

/**
 * @author: wangdarui
 * @created: 2021/2/15
 */
public class _ZUO_数组中子数组的最大累乘积 {

    public static int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] maxDP = Arrays.copyOf(nums, nums.length);
        int[] minDP = Arrays.copyOf(nums, nums.length);
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            maxDP[i] = Math.max(nums[i] * maxDP[i - 1], Math.max(nums[i], nums[i] * minDP[i - 1]));
            minDP[i] = Math.min(nums[i] * minDP[i - 1], Math.min(nums[i], nums[i] * maxDP[i - 1]));
        }
        for (int cur : maxDP) {
            ans = Math.max(ans, cur);
        }
        return ans;
    }

}
