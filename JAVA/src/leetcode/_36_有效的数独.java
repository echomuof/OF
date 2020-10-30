package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: wangdarui
 * @created: 2020/10/29
 */
public class _36_有效的数独 {

    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Integer>[] rows = new HashMap[9];
        Map<Integer, Integer>[] cols = new HashMap[9];
        Map<Integer, Integer>[] boxes = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<>();
            cols[i] = new HashMap<>();
            boxes[i] = new HashMap<>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char cur = board[i][j];
                if (cur != '.') {
                    int n = (int) cur;
                    int boxIndex = (i / 3) * 3 + j / 3;
                    rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
                    cols[j].put(n, cols[j].getOrDefault(n, 0) + 1);
                    boxes[boxIndex].put(n, boxes[boxIndex].getOrDefault(n, 0) + 1);
                    if (rows[i].get(n) > 1 || cols[j].get(n) > 1 || boxes[boxIndex].get(n) > 1) return false;
                }
            }
        }
        return true;
    }

    public boolean isValidSudoku2(char[][] board) {
        int[][] row = new int[9][10];
        int[][] col = new int[9][10];
        int[][] box = new int[9][10];
        row[0][0] = 0;
        col[0][0] = 0;
        box[0][0] = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                int cur = board[i][j] - '0';
                if (row[i][cur] != 0) return false;
                if (col[j][cur] != 0) return false;
                if (box[(i / 3) * 3 + j / 3][cur] != 0) return false;

                row[i][cur] = 1;
                col[j][cur] = 1;
                box[(i / 3) * 3 + j / 3][cur] = 1;
            }
        }
        return true;
    }
}
