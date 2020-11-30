package leetcode;

/**
 * @author: wangdarui
 * @created: 2020/11/30
 */
public class _896_单调数列 {

    public boolean isMonotonic(int[] A) {
        return increasing(A) || decreasing(A);
    }

    public boolean increasing(int[] nums) {
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i]>nums[i+1]) return false;
        }
        return true;
    }

    public boolean decreasing(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i]<nums[i+1]) return false;
        }
        return true;
    }
}
