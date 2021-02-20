package OKOFFER.array;

/**
 * @author: wangdarui
 * @created: 2021/2/15
 */
public class _ZUO_不包含本位置值的累乘数组 {

    public static int[] product1(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        int zeroCount = 0;
        int all = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) all *= nums[i];
            else zeroCount++;
        }
        int[] ans = new int[nums.length];
        if (zeroCount == 0) {
            for (int i = 0; i < nums.length; i++) {
                ans[i] = all / nums[i];
            }
        }
        if (zeroCount == 1) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) ans[i] = all;
            }
        }
        return ans;
    }

    public static int[] product2(int[] nums) {
        if (nums == null || nums.length == 0) return nums;
        int[] ans = new int[nums.length];
        ans[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ans[i] = ans[i - 1] * nums[i];
        }
        int right = 1;
        for (int i = nums.length - 1; i > 0; i--) {
            ans[i] = ans[i - 1] * right;
            right *= ans[i];
        }
        ans[0] = right;
        return ans;
    }

}
