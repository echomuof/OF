package OKOFFER.array;

import java.util.Arrays;

/**
 * @author: wangdarui
 * @created: 2021/2/15
 */
public class _ZUO_自然数数组的排序 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 5, 3, 4};
        sort1(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sort1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            while (nums[i] != i + 1) {
                int tmp = nums[cur - 1];
                nums[cur - 1] = cur;
                cur = tmp;
            }
        }
    }

    public static void sort2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i + 1) {
                int tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
            }
        }
    }

}
