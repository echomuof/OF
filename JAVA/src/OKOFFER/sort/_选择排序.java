package OKOFFER.sort;

import java.util.Arrays;

/**
 * @author: wangdarui
 * @created: 2021/2/14
 */
public class _选择排序 {

    public static void main(String[] args) {
        int[] nums = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        chooseSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void chooseSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int min = nums[i];
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < min) {
                    min = nums[j];
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int tmp = nums[minIndex];
                nums[minIndex] = nums[i];
                nums[i] = tmp;
            }
        }
    }
}
