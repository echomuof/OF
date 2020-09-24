package leetcode;

/**
 * @author: wangdarui
 * @date: 2020/9/24
 */
public class _200_岛屿数量 {
    public static void main(String[] args) {

    }

    public int numIslands(char[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    boom(i, j, grid);
                    res++;
                }
            }
        }
        return res;
    }

    public void boom(int x, int y, char[][] grid) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == '0') {
            return;
        }
        grid[x][y] = '0';
        boom(x - 1, y, grid);
        boom(x + 1, y, grid);
        boom(x, y - 1, grid);
        boom(x, y + 1, grid);
    }
}
