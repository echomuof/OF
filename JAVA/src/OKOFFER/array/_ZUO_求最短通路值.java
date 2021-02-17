package OKOFFER.array;

/**
 * @author: wangdarui
 * @created: 2021/2/16
 */
public class _ZUO_求最短通路值 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1}
        };
        System.out.println(getMinStep(matrix));
    }
    public static int getMinStep(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return -1;
        return recur(matrix, 0, 0, 1);
    }

    public static int recur(int[][] matrix, int raw, int col, int step) {
        if (raw == matrix.length - 1 && col == matrix[0].length - 1) return step;
        if (raw < 0 || col < 0 || raw >= matrix.length || col >= matrix[raw].length || matrix[raw][col] == 0 || matrix[raw][col] == 3)
            return Integer.MAX_VALUE;
        matrix[raw][col] = 3;
        int left = recur(matrix, raw, col - 1, step + 1);
        int right = recur(matrix, raw, col + 1, step + 1);
        int up = recur(matrix, raw - 1, col, step + 1);
        int down = recur(matrix, raw + 1, col, step + 1);
        matrix[raw][col] = 1;
        return Math.min(Math.min(left, right), Math.min(up, down));
    }
}
