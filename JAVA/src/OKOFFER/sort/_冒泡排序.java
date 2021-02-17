package OKOFFER.sort;

import java.util.Arrays;

/**
 * @author: wangdarui
 * @created: 2021/2/14
 */
public class _冒泡排序 {
    public static void main(String[] args) {
        int[] nums = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        popSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void popSort(int[] nums) {
        boolean hasSorted;
        for (int i = 0; i < nums.length - 1; i++) {
            hasSorted = true;
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    hasSorted = false;
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                }
            }
            if (hasSorted) break;
        }
    }
}
