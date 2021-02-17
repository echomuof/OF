package OKOFFER.array;

/**
 * @author: wangdarui
 * @created: 2021/2/9
 */
public class _ZUO_未排序正数数组中累加和为给定值的最长子数组长度 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 1, 1};
        System.out.println(getMaxLen(nums, 3));
    }

    public static int getMaxLen(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        int maxLen = 0;
        int l = 0;
        int r = 0;
        int sum = 0;
        while (r < nums.length) {
            if (sum == k) {
                maxLen = Math.max(maxLen, r - l + 1);
                sum -= nums[l++];
            } else if (sum < k) {
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
