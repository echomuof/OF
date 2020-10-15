package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: wangdarui
 * @date: 2020/9/14
 */
public class _1_两数之和 {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums,target)));
    }

    public static int[] twoSum(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int cur = nums[l] + nums[r];
            if (cur==target) return new int[]{nums[l], nums[r]};
            else if (cur<target) l++;
            else r--;
        }
        return new int[0];
    }

}
