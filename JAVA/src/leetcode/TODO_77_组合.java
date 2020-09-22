package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wangdarui
 * @created: 2020/9/21
 */
public class TODO_77_组合 {
    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        combine(n, k);
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        process(n, k, res, null);
        return res;
    }

    public static void process(int n, int k, List<List<Integer>> res, List<Integer> cur) {
        if (k == 0) {
            return;
        }
        for (int i = 1; i <= n; i++) {

        }
    }
}
