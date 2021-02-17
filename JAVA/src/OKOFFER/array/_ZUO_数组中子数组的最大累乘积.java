package OKOFFER.array;

import java.util.Arrays;

/**
 * @author: wangdarui
 * @created: 2021/2/15
 */
public class _ZUO_数组中子数组的最大累乘积 {

    public static int maxProduct(int[] nums) {
        int[] maxNums = Arrays.copyOf(nums, nums.length);
        int[] minNums = Arrays.copyOf(nums, nums.length);
        for (int i = 1; i < nums.length; i++) {
            maxNums[i] = Math.max(nums[i] * maxNums[i - 1], Math.max(nums[i], nums[i] * minNums[i - 1]));
            minNums[i] = Math.min(nums[i] * minNums[i - 1], Math.min(nums[i], nums[i] * maxNums[i - 1]));
        }
        int ans = maxNums[0];
        for (int i = 1; i < maxNums.length; i++) {
            ans = Math.max(ans, maxNums[i]);
        }
        return ans;
    }

}
