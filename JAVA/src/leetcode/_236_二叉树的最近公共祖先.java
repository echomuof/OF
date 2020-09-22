package leetcode;

import utils.TreeNode;

/**
 * @author: wangdarui
 * @created: 2020/9/21
 */
public class _236_二叉树的最近公共祖先 {
    public static void main(String[] args) {

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        process(root, p, q);
        return res;
    }

    private TreeNode res;

    public boolean process(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean lson = process(root.left, p, q);
        boolean rson = process(root.right, p, q);
        if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson))) {
            res = root;
        }
        return lson || rson || root.val == p.val || root.val == q.val;
    }
}
