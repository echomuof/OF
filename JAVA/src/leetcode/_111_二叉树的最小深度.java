package leetcode;

import utils.TreeNode;

/**
 * @author: wangdarui
 * @created: 2020/9/21
 */
public class _111_二叉树的最小深度 {
    public static void main(String[] args) {

    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left==null) return minDepth(root.right) + 1;
        if (root.right==null) return minDepth(root.left) + 1;
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
