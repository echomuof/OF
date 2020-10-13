package 剑指offer;

import java.util.Arrays;

/**
 * @author: wangdarui
 * @created: 2020/10/13
 */
public class _39_数组中出现次数超过一半的数字 {

    public static void main(String[] args) {

    }

    public static int majorityElement(int[] nums) {
        if (nums == null) {
            return -1;
        }
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
