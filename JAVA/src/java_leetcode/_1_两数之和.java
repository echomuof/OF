package java_leetcode;

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
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer cur = map.get(target - nums[i]);
            if (cur != null) {
                return new int[]{i, cur};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

}
