package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wangdarui
 * @date: 2020/9/21
 */
public class _78_子集 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null) {
            return ans;
        }
        process(ans, 0, nums, new ArrayList<>());
        return ans;
    }

    public void process(List<List<Integer>> ans, int n, int[] nums, List<Integer> list) {
        if (n == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }
        process(ans, n + 1, nums, list);
        list.add(nums[n]);
        process(ans, n + 1, nums, list);
        list.remove(list.size() - 1);
    }
}
