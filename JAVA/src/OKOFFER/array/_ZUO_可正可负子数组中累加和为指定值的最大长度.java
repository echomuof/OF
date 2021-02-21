package OKOFFER.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: wangdarui
 * @created: 2021/2/14
 */
public class _ZUO_可正可负子数组中累加和为指定值的最大长度 {

    public static int getMaxLen(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int maxLen = 0;
        int sum = 0;
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int target = sum - k;
            if (map.containsKey(target)) {
                maxLen = Math.max(maxLen, i - map.get(target) + 1);
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return maxLen;
    }
}
