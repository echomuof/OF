package 剑指offer;

import java.util.Arrays;

/**
 * @author: wangdarui
 * @created: 2020/10/9
 */
public class _21_调整数组顺序使奇数位于偶数前面 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        exchange(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static int[] exchange(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return nums;
        }
        int p = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1) {
                int tmp = nums[i];
                nums[i] = nums[p];
                nums[p++] = tmp;
            }
        }
        return nums;
    }

}
