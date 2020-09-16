package java_leetcode;

/**
 * @author: wangdarui
 * @created: 2020/9/16
 */
public class _jo4_二维数组中的查找 {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            if (target < matrix[i][col - 1]) {
                for (int j = col - 1; j > 0; j--) {
                    if ()
                }
            }
        }
    }
}
