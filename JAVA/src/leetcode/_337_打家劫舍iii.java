package leetcode;

import utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: wangdarui
 * @created: 2020/10/22
 */
public class _337_打家劫舍iii {
    public int rob(TreeNode root) {
        /*Map<TreeNode, Integer> dp = new HashMap<>();
        return recur(root, dp);*/
        int[] res = recur2(root);
        return Math.max(res[0], res[1]);
    }

    public int recur(TreeNode root, Map<TreeNode, Integer> dp) {
        if (root == null) return 0;
        if (dp.containsKey(root)) return dp.get(root);
        int cur = root.val;
        if (root.left != null) cur += recur(root.left.left, dp) + recur(root.left.right, dp);
        if (root.right != null) cur += recur(root.right.left, dp) + recur(root.right.right, dp);
        int res = Math.max(cur, recur(root.left, dp) + recur(root.right, dp));
        dp.put(root, res);
        return res;
    }

    public int[] recur2(TreeNode root) {
        int[] res = new int[2];
        if (root==null) return res;
        int[] left = recur2(root.left);
        int[] right = recur2(root.right);
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = left[0] + right[0] + root.val;
        return res;
    }
}
