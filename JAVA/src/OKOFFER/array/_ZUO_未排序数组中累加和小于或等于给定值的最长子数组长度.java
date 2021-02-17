package OKOFFER.array;

/**
 * @author: wangdarui
 * @created: 2021/2/14
 */
public class _ZUO_未排序数组中累加和小于或等于给定值的最长子数组长度 {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        System.out.println(getMaxLen(nums, 7));
    }

    public static int getMaxLen(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        int l = 0;
        int r = 0;
        int maxLen = 0;
        int sum = 0;
        while (r < nums.length) {
            sum += nums[r];
            while (sum > k) {
                sum -= nums[l++];
            }
            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }
        return maxLen;
    }
}
