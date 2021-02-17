package OKOFFER.array;

/**
 * @author: wangdarui
 * @created: 2021/2/14
 */
public class _leetcode_209_长度最小的子数组 {
    public int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int minLen = Integer.MAX_VALUE;
        int l = 0;
        int r = 0;
        int sum = 0;
        while (r < nums.length) {
            sum += nums[r];
            while (sum >= target) {
                minLen = Math.min(minLen, r - l + 1);
                sum -= nums[l++];
            }
            r++;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
