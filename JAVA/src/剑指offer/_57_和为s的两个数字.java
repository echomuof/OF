package 剑指offer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author: wangdarui
 * @created: 2020/10/15
 */
public class _57_和为s的两个数字 {

    public static void main(String[] args) {
        _57_和为s的两个数字 a = new _57_和为s的两个数字();
        int[] nums = {2, 7, 11, 15};
        a.twoSum(nums, 9);
    }

    public int[] twoSum(int[] nums, int target) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            int cur = target - num;
            if (set.contains(cur)) {
                return new int[]{cur, num};
            }
            set.add(num);
        }
        return new int[]{};
    }

}
