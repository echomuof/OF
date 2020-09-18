package leetcode;

import java.util.Arrays;

/**
 * @author: wangdarui
 * @date: 2020/9/16
 */
public class _283_移动零 {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};
        moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void moveZeroes(int[] arr) {
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                int tmp = arr[i];
                arr[i] = arr[k];
                arr[k] = tmp;
                k++;
            }
        }
    }

}
