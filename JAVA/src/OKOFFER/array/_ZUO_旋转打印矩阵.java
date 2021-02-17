package OKOFFER.array;

/**
 * @author: wangdarui
 * @created: 2021/2/13
 */
public class _ZUO_旋转打印矩阵 {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        spiralOrderPrint(matrix);
    }

    public static void spiralOrderPrint(int[][] matrix) {
        int tRaw = 0;
        int tCol = 0;
        int dRaw = matrix.length - 1;
        int dCol = matrix[0].length - 1;
        while (tRaw <= dRaw && tCol <= dCol) {
            printEdge(matrix, tRaw++, tCol++, dRaw--, dCol--);
        }
    }

    public static void printEdge(int[][] m, int tRaw, int tCol, int dRaw, int dCol) {
        if (tRaw == dRaw) {
            for (int i = tCol; i <= dCol; i++) {
                System.out.print(m[tRaw][i] + " ");
            }
        } else if (tCol == dCol) {
            for (int i = tRaw; i <= dRaw; i++) {
                System.out.print(m[i][tRaw] + " ");
            }
        } else {
            int curRaw = tRaw;
            int curCol = tCol;
            while (curCol != dCol) {
                System.out.print(m[tRaw][curCol++] + " ");
            }
            while (curRaw != dRaw) {
                System.out.print(m[curRaw++][dCol] + " ");
            }
            while (curCol != tCol) {
                System.out.print(m[dRaw][curCol--] + " ");
            }
            while (curRaw != tRaw) {
                System.out.print(m[curRaw--][tCol] + " ");
            }
        }
    }

}
