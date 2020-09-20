package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: wangdarui
 * @date: 2020/9/19
 */
public class TODO_42_接雨水 {
    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(height));
    }

    public static int trap(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            int lMax = 0;
            int rMax = 0;
            for (int j = i; j >= 0; j--) {
                lMax = Math.max(lMax, height[j]);
            }
            for (int j = i; j < height.length; j++) {
                rMax = Math.max(rMax, height[j]);
            }
            maxArea += Math.min(lMax, rMax) - height[i];
        }
        return maxArea;
    }
}
