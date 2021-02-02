package OKOFFER.leetcode;

/**
 * @author: wangdarui
 * @created: 2021/2/1
 */
public class _11_盛水最多的容器 {

    public int maxArea(int[] height) {
        int L = 0;
        int R = height.length - 1;
        int ans = 0;
        while (L < R) {
            int minHeight = height[L] <= height[R] ? height[L++] : height[R--];
            ans = Math.max(ans, minHeight * (R - L + 1));
        }
        return ans;
    }

}
