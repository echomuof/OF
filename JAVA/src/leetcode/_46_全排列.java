package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wangdarui
 * @created: 2020/9/21
 */
public class _46_全排列 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null) return ans;
        process(ans, new ArrayList<>(), new int[nums.length], nums);
        return ans;
    }

    public void process(List<List<Integer>> ans, List<Integer> line, int[] hasVisit, int[] nums) {
        if (line.size() == nums.length) {
            ans.add(new ArrayList<>(line));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (hasVisit[i] == 1) continue;
            hasVisit[i] = 1;
            line.add(nums[i]);
            process(ans, line, hasVisit, nums);
            line.remove(line.size() - 1);
            hasVisit[i] = 0;
        }
    }


}
