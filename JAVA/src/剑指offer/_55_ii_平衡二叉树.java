package 剑指offer;

import utils.TreeNode;

/**
 * @author: wangdarui
 * @created: 2020/10/15
 */
public class _55_ii_平衡二叉树 {
    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return ans;
    }

    boolean ans = true;

    public int dfs(TreeNode root) {
        if (root == null) return 0;
        int l = dfs(root.left);
        int r = dfs(root.right);
        if (Math.abs(l - r) > 1) ans = false;
        return Math.max(l, r) + 1;
    }
}
