package java_leetcode;

import java.util.*;

/**
 * @author: wangdarui
 * @date: 2020/9/14
 */
public class _15_三数之和 {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> res = threeSum(nums);
        res.forEach(item -> System.out.println(Arrays.toString(item.toArray())));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int L = i + 1;
            int R = nums.length - 1;
            while (L < R) {
                if (nums[L] + nums[R] + nums[i] == 0) {
                    List<Integer> curRes = new ArrayList<>();
                    curRes.add(nums[i]);
                    curRes.add(nums[L]);
                    curRes.add(nums[R]);
                    res.add(curRes);
                    while (L < R && nums[L] == nums[L + 1]) {
                        L++;
                    }
                    while (L < R && nums[R] == nums[R - 1]) {
                        R--;
                    }
                    L++;
                    R--;
                } else if (nums[L] + nums[R] + nums[i] < 0) {
                    L++;
                } else {
                    R--;
                }
            }
        }
        return res;
    }
}
