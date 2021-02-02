package OKOFFER.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: wangdarui
 * @created: 2021/2/1
 */
public class _1_两数之和 {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(nums, 9)));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer cur = map.get(target - nums[i]);
            if (cur == null) {
                map.put(nums[i], i);
                continue;
            }
            return new int[]{i, cur};
        }
        return null;
    }
}
