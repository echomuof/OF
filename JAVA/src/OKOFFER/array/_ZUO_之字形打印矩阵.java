package OKOFFER.array;

/**
 * @author: wangdarui
 * @created: 2021/2/13
 */
public class _ZUO_之字形打印矩阵 {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        printZigZag(matrix);
    }

    public static void printZigZag(int[][] matrix) {
        int tRaw = 0;
        int tCol = 0;
        int dRaw = 0;
        int dCol = 0;
        int endRaw = matrix.length - 1;
        int endCol = matrix[0].length - 1;
        boolean fromUp = false;
        while (tRaw <= endRaw) {
            printLevel(matrix, tRaw, tCol, dRaw, dCol, fromUp);
            tRaw = tCol == endCol ? tRaw + 1 : tRaw;
            tCol = tCol == endCol ? tCol : tCol + 1;
            dCol = dRaw == endRaw ? dCol + 1 : dCol;
            dRaw = dRaw == endRaw ? dRaw : dRaw + 1;
            fromUp = !fromUp;
        }
        System.out.println();
    }

    public static void printLevel(int[][] m, int tRaw, int tCol, int dRaw, int dCol, boolean f) {
        if (f) {
            while (tRaw <= dRaw) {
                System.out.print(m[tRaw++][tCol--] + " ");
            }
        } else {
            while (dRaw >= tRaw) {
                System.out.print(m[dRaw--][dCol++] + " ");
            }
        }
    }
}
