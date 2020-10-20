package leetcode;

/**
 * @author: wangdarui
 * @created: 2020/10/19
 */
public class _62_不同路径 {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 2));
    }

    public static int uniquePaths(int m, int n) {
        return recur(m, n, 0, 0, new int[m][n]);
    }

    public static int recur(int m, int n, int i, int j, int[][] grid) {
        if (i == m || j == n) return 0;
        if (i == m - 1 && j == n - 1) return 1;
        if (grid[i][j] == 0) grid[i][j] = recur(m, n, i + 1, j, grid) + recur(m, n, i, j + 1, grid);
        return grid[i][j];
    }

    public static int uniquePaths2(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int i = 0; i < n; i++) dp[0][i] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
