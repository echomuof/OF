package leetcode;

import utils.TreeNode;

/**
 * @author: wangdarui
 * @created: 2020/9/21
 */
public class _226_翻转二叉树 {
    public static void main(String[] args) {

    }

    public TreeNode invertTree(TreeNode root) {
        process(root);
        return root;
    }

    public void process(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        process(root.left);
        process(root.right);
    }
}
