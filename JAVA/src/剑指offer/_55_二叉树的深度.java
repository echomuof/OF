package 剑指offer;

import utils.TreeNode;

/**
 * @author: wangdarui
 * @created: 2020/10/15
 */
public class _55_二叉树的深度 {
    public int maxDepth(TreeNode root) {
        if (root==null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
