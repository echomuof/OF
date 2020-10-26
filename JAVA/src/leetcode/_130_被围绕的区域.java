package leetcode;

/**
 * @author: wangdarui
 * @created: 2020/10/26
 */
public class _130_被围绕的区域 {

    public static void main(String[] args) {
        _130_被围绕的区域 a = new _130_被围绕的区域();

        char[][] board = {
                {'O', 'X', 'X', 'O', 'X'},
                {'X', 'O', 'O', 'X', 'O'},
                {'X', 'O', 'X', 'O', 'X'},
                {'O', 'X', 'O', 'O', 'O'},
                {'X', 'X', 'O', 'X', 'O'}};
        a.solve(board);
    }

    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                boolean isEdge = i == 0 || j == 0 || i == board.length - 1 || j == board[i].length - 1;
                if (isEdge && board[i][j] == 'O') {
                    dfs(board, i, j);
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j]=='O') board[i][j] = 'X';
                else if (board[i][j]=='#') board[i][j] = 'O';
            }
        }
    }

    public void dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] == 'X' || board[i][j] == '#') return;
        board[i][j] = '#';
        dfs(board, i - 1, j);
        dfs(board, i + 1, j);
        dfs(board, i, j - 1);
        dfs(board, i, j + 1);
    }
}
