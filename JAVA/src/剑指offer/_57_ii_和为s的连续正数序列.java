package 剑指offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wangdarui
 * @created: 2020/10/15
 */
public class _57_ii_和为s的连续正数序列 {
    public int[][] findContinuousSequence(int target) {
        int sum = 0;
        int l = 1;
        int r = 1;
        List<int[]> ans = new ArrayList<>();
        while (l <= target / 2) {
            if (sum < target) {
                sum += r;
                r++;
            } else if (sum > target) {
                sum -= l;
                l++;
            } else {
                int[] arr = new int[r - l];
                for (int i = l; i < r; i++) {
                    arr[i - l] = i;
                }
                ans.add(arr);
                sum -= l;
                l++;
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
