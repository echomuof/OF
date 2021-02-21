package OKOFFER.array;

import java.util.Arrays;

/**
 * @author: wangdarui
 * @created: 2021/2/15
 */
public class _ZUO_不包含本位置值的累乘数组 {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 4};
        int[] ans = product2(nums);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] product1(int[] nums) {
        if (nums == null || nums.length == 0) return nums;
        int[] ans = new int[nums.length];
        int all = 1;
        int zeroCount = 0;
        for (int num : nums) {
            if (num != 0) {
                all *= num;
            } else {
                zeroCount++;
            }
        }
        if (zeroCount == 0) {
            for (int i = 0; i < ans.length; i++) {
                ans[i] = all / nums[i];
            }
        }
        if (zeroCount == 1) {
            for (int i = 0; i < ans.length; i++) {
                if (nums[i] == 0) {
                    ans[i] = all;
                }
            }
        }
        return ans;
    }

    public static int[] product2(int[] nums) {
        if (nums == null || nums.length < 2) {
            return null;
        }
        int[] ans = new int[nums.length];
        ans[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ans[i] = ans[i - 1] * nums[i];
        }
        int right = 1;
        for (int i = nums.length - 1; i > 0; i--) {
            ans[i] = ans[i - 1] * right;
            right *= nums[i];
        }
        ans[0] = right;
        return ans;
    }

}
