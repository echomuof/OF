package OKOFFER.array;

import java.util.Arrays;

/**
 * @author: wangdarui
 * @created: 2021/2/14
 */
public class _ZUO_在数组中找到出现次数大于一半的数 {
    public static int getMoreThenHalf(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public static int getMoreThenHalf2(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int x = 0;
        int score = 0;
        for (int num : nums) {
            if (score == 0) x = num;
            score += num == x ? 1 : -1;
        }
        int count = 0;
        for (int num : nums) {
            if (num == x) count++;
        }
        return count > nums.length / 2 ? x : -1;
    }
}
