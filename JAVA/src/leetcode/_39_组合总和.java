package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: wangdarui
 * @created: 2020/11/26
 */
public class _39_组合总和 {

    public static void main(String[] args) {
        _39_组合总和 a = new _39_组合总和();
        int[] candidates = {2, 7, 6, 3, 5, 1};
        List<List<Integer>> lists = a.combinationSum(candidates, 9);
        System.out.println();
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return ans;
        Deque<Integer> cur = new ArrayDeque<>();
        Arrays.sort(candidates);
        recur(candidates, target, 0, cur, ans);
        return ans;
    }

    public void recur(int[] candidates, int target, int idx, Deque<Integer> cur, List<List<Integer>> ans) {
        if (0 == target) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        for (int i = idx; i < candidates.length; i++) {
            if (target - candidates[i] < 0) break;
            cur.addLast(candidates[i]);
            recur(candidates, target - candidates[i], i, cur, ans);
            cur.removeLast();
        }
    }
}
