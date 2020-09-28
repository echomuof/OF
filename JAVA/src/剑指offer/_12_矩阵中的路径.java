package 剑指offer;

/**
 * @author: wangdarui
 * @created: 2020/9/27
 */
public class _12_矩阵中的路径 {
    public static void main(String[] args) {

    }

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (process(board, i, j, word, 0)) return true;
            }
        }
        return false;
    }

    public boolean process(char[][] board, int row, int col, String word, int idx) {
        if (row >= board.length || row < 0 || col >= board[0].length || col < 0 || board[row][col] != word.charAt(idx)) {
            return false;
        }
        if (idx == word.length() - 1) return true;
        char cur = board[row][col];
        board[row][col] = '#';
        if (process(board, row - 1, col, word, idx + 1)
                || process(board, row + 1, col, word, idx + 1)
                || process(board, row, col - 1, word, idx + 1)
                || process(board, row, col + 1, word, idx + 1)) {
            return true;
        }
        board[row][col] = cur;
        return false;
    }
}
