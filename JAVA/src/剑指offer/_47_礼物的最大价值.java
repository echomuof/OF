package 剑指offer;

/**
 * @author: wangdarui
 * @created: 2020/10/13
 */
public class _47_礼物的最大价值 {

    public static void main(String[] args) {
        _47_礼物的最大价值 a = new _47_礼物的最大价值();
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println(a.maxValue(grid));
    }

    public int maxValue(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (i == 0 && j == 0) continue;
                if (i==0) grid[i][j] += grid[i][j - 1];
                else if (j==0) grid[i][j] += grid[i - 1][j];
                else grid[i][j] += Math.max(grid[i][j - 1], grid[i - 1][j]);
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }

}
