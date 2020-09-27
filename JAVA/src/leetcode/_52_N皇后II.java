package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wangdarui
 * @created: 2020/9/27
 */
public class _52_N皇后II {
    public static void main(String[] args) {
        _52_N皇后II a = new _52_N皇后II();
        System.out.println(a.totalNQueens(4));
    }

    private List<Integer> cols;
    private List<Integer> pie;
    private List<Integer> na;
    private int count;

    public int totalNQueens(int n) {
        cols = new ArrayList<>();
        pie = new ArrayList<>();
        na = new ArrayList<>();
        count = 0;
        process(n, 0, 0);
        return count;
    }

    public void process(int n, int row, int col) {
        if (row == n) {
            count++;
            return;
        }
        for (int curCol = 0; curCol < n; curCol++) {
            if (cols.contains(curCol) || pie.contains(row + curCol) || na.contains(row - curCol)) {
                continue;
            }
            cols.add(curCol);
            pie.add(row + curCol);
            na.add(row - curCol);
            process(n, row + 1, curCol);
            cols.remove(new Integer(curCol));
            pie.remove(new Integer(row + curCol));
            na.remove(new Integer(row - curCol));
        }
    }
}
