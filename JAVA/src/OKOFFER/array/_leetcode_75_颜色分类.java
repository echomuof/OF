package OKOFFER.array;

import java.util.Arrays;

/**
 * @author: wangdarui
 * @created: 2021/2/20
 */
public class _leetcode_75_颜色分类 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 0, 0, 0, 2, 1, 1, 2, 0};
        type(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void type(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int left = 0;
        int right = nums.length;
        int i = 0;
        while (i < right) {
            if (nums[i] == 0) {
                swap(nums, i++, left++);
            } else if (nums[i] == 2) {
                swap(nums, i, --right);
            } else {
                i++;
            }
        }
    }

    public static void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
