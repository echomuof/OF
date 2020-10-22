package leetcode;

import java.util.List;

/**
 * @author: wangdarui
 * @created: 2020/10/20
 */
public class _120_三角形最小路径和 {
    public int minimumTotal(List<List<Integer>> triangle) {
        return recur(triangle, new int[triangle.size()][triangle.size()], 0, 0);
    }

    public int recur(List<List<Integer>> triangle, int[][] dp, int depth, int index) {
        if (depth == triangle.size()) return 0;
        if (dp[depth][index] == 0)
            dp[depth][index] = Math.min(recur(triangle, dp, depth + 1, index), recur(triangle, dp, depth + 1, index + 1)) + triangle.get(depth).get(index);
        return dp[depth][index];
    }

    public int minimumTotal2(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}
