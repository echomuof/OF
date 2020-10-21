package leetcode;

import java.util.Arrays;

/**
 * @author: wangdarui
 * @created: 2020/10/21
 */
public class _152_乘积最大子数组 {

    public int maxProduct(int[] nums) {
        int[] maxNums = Arrays.copyOf(nums, nums.length);
        int[] minNums = Arrays.copyOf(nums, nums.length);
        for (int i = 1; i < nums.length; i++) {
            maxNums[i] = Math.max(maxNums[i - 1] * nums[i], Math.max(nums[i], nums[i] * minNums[i - 1]));
            minNums[i] = Math.min(minNums[i - 1] * nums[i], Math.min(nums[i], nums[i] * maxNums[i - 1]));
        }
        int anx = maxNums[0];
        for (int i = 1; i < maxNums.length; i++) {
            anx = Math.max(anx, maxNums[i]);
        }
        return anx;
    }

}
