package OKOFFER.array;

import java.util.Arrays;

/**
 * @author: wangdarui
 * @created: 2021/2/15
 */
public class _ZUO_数组的partition调整 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 2, 3, 3, 4, 5, 6, 6, 7, 7, 8, 8, 8, 9};
        leftUnique(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void leftUnique(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int l = 0;
        int r = 1;
        while (r < nums.length) {
            if (nums[r++] != nums[l]) {
                int tmp = nums[r - 1];
                nums[r - 1] = nums[l++];
                nums[l] = tmp;
            }
        }
    }

    public static void sort(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        int left = -1;
        int right = nums.length;
        int index = 0;
        while (index < right) {
            if (nums[index] == 0) swap(nums, ++left, index++);
            else if (nums[index] == 2) swap(nums, --right, index);
            else index++;
        }
    }

    public static void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
