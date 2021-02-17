package OKOFFER.array;

/**
 * @author: wangdarui
 * @created: 2021/2/14
 */
public class _ZUO_在行列都排好序的矩阵中找指定数 {

    public static boolean checkIn(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int raw = matrix.length - 1;
        int col = 0;
        while (raw >= 0 && col < matrix[raw].length) {
            if (matrix[raw][col] > target) {
                col++;
            } else if (matrix[raw][col] < target) {
                raw--;
            } else {
                return true;
            }
        }
        return false;
    }

}
