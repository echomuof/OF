package OKOFFER.sort;

import java.util.Arrays;

/**
 * @author: wangdarui
 * @created: 2021/2/14
 */
public class _插入排序 {
    public static void main(String[] args) {
        int[] nums = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        insetSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void insetSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int j = i;
            while (j > 0 && nums[j] < nums[j - 1]) {
                int tmp = nums[j];
                nums[j] = nums[j - 1];
                nums[j - 1] = tmp;
                j--;
            }
        }
    }
}
