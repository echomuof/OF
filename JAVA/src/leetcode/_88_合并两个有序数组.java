package leetcode;

import java.util.Arrays;

/**
 * @author: wangdarui
 * @created: 2020/9/15
 */
public class _88_合并两个有序数组 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int m = 3;
        int n = 3;
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int[] arr1, int m, int[] arr2, int n) {
        int[] arr1Copy = new int[m];
        System.arraycopy(arr1, 0, arr1Copy, 0, m);
        int p1 = 0;
        int p2 = 0;
        int p = 0;
        while (p1 < m && p2 < n) {
            arr1[p++] = arr1Copy[p1] <= arr2[p2] ? arr1Copy[p1++] : arr2[p2++];
        }
        if (p1 < m) {
            System.arraycopy(arr1Copy, p1, arr1, p1 + p2, m + n - p1 - p2);
        }
        if (p2 < n) {
            System.arraycopy(arr2, p2, arr1, p1 + p2, m + n - p1 - p2);
        }
    }
}
