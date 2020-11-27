package 算法面试汇总;

import java.util.Arrays;

/**
 * @author: wangdarui
 * @created: 2020/11/26
 */
public class LC多数元素 {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
