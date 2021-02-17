package OKOFFER.sort;

import java.util.Arrays;

/**
 * @author: wangdarui
 * @created: 2021/2/14
 */
public class _归并排序 {

    public static void main(String[] args) {
        int[] nums = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        mergeSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void mergeSort(int[] nums) {
        process(nums, 0, nums.length - 1);
    }

    public static void process(int[] nums, int L, int R) {
        if (L == R) return;
        int M = L + (R - L) / 2;
        process(nums, L, M);
        process(nums, M + 1, R);
        merge(nums, L, M, R);
    }

    public static void merge(int[] nums, int L, int M, int R) {
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        int[] help = new int[R - L + 1];
        while (p1 <= M && p2 <= R) {
            help[i++] = nums[p1] <= nums[p2] ? nums[p1++] : nums[p2++];
        }
        while (p1 <= M) {
            help[i++] = nums[p1++];
        }
        while (p2 <= R) {
            help[i++] = nums[p2++];
        }
        for (int j = 0; j < help.length; j++) {
            nums[L + j] = help[j];
        }
    }

}
