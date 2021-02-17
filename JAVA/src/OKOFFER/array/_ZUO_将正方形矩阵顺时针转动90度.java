package OKOFFER.array;

/**
 * @author: wangdarui
 * @created: 2021/2/13
 */
public class _ZUO_将正方形矩阵顺时针转动90度 {
    public static void rotate(int[][] matrix) {
        int tRaw = 0;
        int tCol = 0;
        int dRaw = matrix.length - 1;
        int dCol = matrix[0].length - 1;
        while (tRaw < dRaw) {
            rotateEdge(matrix, tRaw++, tCol++, dRaw--, dCol--);
        }
    }

    public static void rotateEdge(int[][] m, int tRaw, int tCol, int dRaw, int dCol) {
        int times = dCol - dRaw;
        for (int i = 0; i < times; i++) {
            int tmp = m[tRaw][tCol + i];
            m[tRaw][tCol + i] = m[dRaw - i][tCol];
            m[dRaw - i][tCol] = m[dRaw][dCol - i];
            m[dRaw][dCol - i] = m[tRaw + i][dCol];
            m[tRaw + i][dCol] = tmp;
        }
    }
}
