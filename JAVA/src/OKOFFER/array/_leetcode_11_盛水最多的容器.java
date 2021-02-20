package OKOFFER.array;

/**
 * @author: wangdarui
 * @created: 2021/2/13
 */
public class _leetcode_11_盛水最多的容器 {
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) return 0;
        int ans = 0;
        int l = 0;
        int r = height.length - 1;
        while (l < r) {
            int h = height[l] <= height[r] ? height[l++] : height[r--];
            ans = Math.max(ans, h * (r - l + 1));
        }
        return ans;
    }
}
