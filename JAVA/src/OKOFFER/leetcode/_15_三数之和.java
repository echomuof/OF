package OKOFFER.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: wangdarui
 * @created: 2021/2/1
 */
public class _15_三数之和 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length ; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int L = i + 1;
            int R = nums.length - 1;
            while (L < R) {
                int cur = nums[i] + nums[L] + nums[R];
                if (cur == 0) {
                    List<Integer> oneAns = new ArrayList<>();
                    oneAns.add(nums[i]);
                    oneAns.add(nums[L]);
                    oneAns.add(nums[R]);
                    ans.add(oneAns);
                    while (L < R && nums[L] == nums[L + 1]) L++;
                    while (L < R && nums[R] == nums[R - 1]) R--;
                    L++;
                    R--;
                } else if (cur > 0) {
                    R--;
                } else {
                    L++;
                }
            }
        }
        return ans;
    }

}
