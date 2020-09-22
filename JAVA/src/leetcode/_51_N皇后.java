package leetcode;

import sun.jvm.hotspot.jdi.ArrayReferenceImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: wangdarui
 * @date: 2020/9/22
 */
public class _51_N皇后 {
    public static void main(String[] args) {
        _51_N皇后 a = new _51_N皇后();
        a.solveNQueens(4);
    }

    private List<Integer> cols;
    private List<Integer> pie;
    private List<Integer> na;
    private List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        cols = new ArrayList<>();
        pie = new ArrayList<>();
        na = new ArrayList<>();
        res = new ArrayList<>();
        process(n, 0, 0);
        return res;
    }

    public void process(int n, int row, int col) {
        if (row == n) {
            res.add(generateResult(n));
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

    public List<String> generateResult(int n) {
        List<String> singleRes = new ArrayList<>();
        cols.forEach(i -> {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            singleRes.add(sb.toString());
        });
        return singleRes;
    }
}
