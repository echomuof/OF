package 剑指offer;

/**
 * @author: wangdarui
 * @created: 2020/9/16
 */
public class _4_二维数组中的查找 {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(findNumberIn2DArray(arr, 2));
    }

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int x = 0;
        int y = matrix.length - 1;
        while (x < matrix[0].length && y >= 0) {
            if (target == matrix[y][x]) return true;
            else if (target < matrix[y][x]) y--;
            else x++;
        }
        return false;
    }
}
