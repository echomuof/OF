package OKOFFER.array;

import java.nio.IntBuffer;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: wangdarui
 * @created: 2021/2/14
 */
public class _ZUO_最长的可整合子数组的长度 {
    public static int getLIL(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (set.contains(nums[j])) break;
                set.add(nums[j]);
                max = Math.max(max, nums[j]);
                min = Math.min(min, nums[j]);
                if (max - min == j - i) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }
        return ans;
    }
}
