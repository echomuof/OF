import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: wangdarui
 * @created: 2021/2/3
 */
public class B2 {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {0,1,0},
                {1,0,1},
                {0,1,0}
        };
        solve(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }

    }


    public static int[][] solve(int[][] board) {
        if (board == null || board.length == 0) return null;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                boolean isEdge = i == 0 || j == 0 || i == board.length - 1 || j == board[i].length - 1;
                if (isEdge && board[i][j] == 0) {
                    dfs(board, i, j);
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j]==0) board[i][j] = 1;
                else if (board[i][j]==3) board[i][j] = 0;
            }
        }
        return board;
    }

    public static void dfs(int[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] == 1 || board[i][j] == 3) return;
        board[i][j] = 3;
        dfs(board, i - 1, j);
        dfs(board, i + 1, j);
        dfs(board, i, j - 1);
        dfs(board, i, j + 1);
    }
}
