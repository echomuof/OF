package java_leetcode;

/**
 * @author: wangdarui
 * @date: 2020/9/14
 */
public class _2_盛水最多的容器 {

    public static void main(String[] args) {
        int[] arr = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(arr));
    }

    public static int maxArea(int[] arr) {
        int maxArea = 0;
        int L = 0;
        int R = arr.length - 1;
        while (L != R) {
            int minHeight = arr[L] <= arr[R] ? arr[L++] : arr[R--];
            maxArea = Math.max(maxArea, minHeight * (R - L + 1));
        }
        return maxArea;
    }


}
