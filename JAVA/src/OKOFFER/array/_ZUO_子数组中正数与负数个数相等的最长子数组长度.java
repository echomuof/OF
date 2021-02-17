package OKOFFER.array;

/**
 * @author: wangdarui
 * @created: 2021/2/14
 */
public class _ZUO_子数组中正数与负数个数相等的最长子数组长度 {

    public static int getMaxLen(int[] nums) {
        int sum = 0;
        int maxLen = 0;
        int l = 0;
        int r = 0;
        while (r < nums.length) {
            if (sum == 0) {
                maxLen = Math.max(maxLen, r - l + 1);
            } else if (sum < 0) {
                r++;
                if (r == nums.length) break;
                sum += nums[r];
            } else {
                sum -= nums[l++];
            }
        }
        return maxLen;
    }
}
