package 剑指offer;

import com.sun.org.apache.regexp.internal.RE;
import utils.TreeNode;

/**
 * @author: wangdarui
 * @created: 2020/10/9
 */
public class _28_对称的二叉树 {
    public static void main(String[] args) {

    }

    public boolean isSymmetric(TreeNode root) {
        return root == null || recur(root.left, root.right);
    }

    public boolean recur(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null || left.val != right.val) return false;
        return recur(left.left, right.right) && recur(left.right, right.left);
    }
}
