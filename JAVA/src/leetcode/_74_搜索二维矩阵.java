package leetcode;

/**
 * @author: wangdarui
 * @created: 2020/9/27
 */
public class _74_搜索二维矩阵 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        _74_搜索二维矩阵 a = new _74_搜索二维矩阵();
        System.out.println(a.searchMatrix(matrix, 3));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int x = 0;
        int y = matrix.length - 1;
        while (x < matrix[0].length && y >= 0) {
            if (matrix[y][x] == target) {
                return true;
            } else if (matrix[y][x] < target) {
                x++;
            } else {
                y--;
            }
        }
        return false;
    }
}
