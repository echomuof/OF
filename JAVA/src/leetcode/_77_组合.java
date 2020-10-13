package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wangdarui
 * @created: 2020/9/21
 */
public class _77_组合 {
    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        List<List<Integer>> combine = combine(n, k);
        System.out.println();
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        process(res, new ArrayList<>(), n, k, 0);
        return res;
    }

    public static void process(List<List<Integer>> res, List<Integer> line, int n, int k, int start) {
        if (line.size() == k) {
            res.add(new ArrayList<>(line));
            return;
        }
        for (int i = start + 1; i <= n; i++) {
            line.add(i);
            process(res, line, n, k, i);
            line.remove(line.size() - 1);
        }
    }
}
