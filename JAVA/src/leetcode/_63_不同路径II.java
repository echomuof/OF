package leetcode;

/**
 * @author: wangdarui
 * @created: 2020/10/19
 */
public class _63_不同路径II {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }
        return recur(obstacleGrid, new int[obstacleGrid.length][obstacleGrid[0].length], 0, 0);
    }

    public int recur(int[][] obstacleGrid, int[][] grid, int x, int y) {
        if (x >= obstacleGrid[0].length || y >= obstacleGrid.length || obstacleGrid[y][x] == 1) return 0;
        if (x == obstacleGrid[0].length - 1 && y == obstacleGrid.length - 1) return 1;
        if (grid[y][x] == 0)
            grid[y][x] = recur(obstacleGrid, grid, x + 1, y) + recur(obstacleGrid, grid, x, y + 1);
        return grid[y][x];
    }

    public static void main(String[] args) {
        int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(uniquePathsWithObstacles2(obstacleGrid));
    }

    public static int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) return 0;
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = 0; i < obstacleGrid.length && obstacleGrid[i][0] == 0; i++) dp[i][0] = 1;
        for (int i = 0; i < obstacleGrid[0].length && obstacleGrid[0][i] == 0; i++) dp[0][i] = 1;

        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[i].length; j++) {
                if (obstacleGrid[i][j] == 0)
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }
}
