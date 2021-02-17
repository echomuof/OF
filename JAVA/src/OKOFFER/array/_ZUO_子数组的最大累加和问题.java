package OKOFFER.array;

import com.sun.org.apache.regexp.internal.RE;

/**
 * @author: wangdarui
 * @created: 2021/2/15
 */
public class _ZUO_子数组的最大累加和问题 {

    public static void main(String[] args) {
        int[] nums = {1, -2, 3, 5, -2, 6, -1};
        System.out.println(maxSumArray(nums));
    }

    public static int maxSumArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int ans = Integer.MIN_VALUE;
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            cur += nums[i];
            ans = Math.max(ans, cur);
            cur = Math.max(cur, 0);
        }
            return ans;
    }

}
