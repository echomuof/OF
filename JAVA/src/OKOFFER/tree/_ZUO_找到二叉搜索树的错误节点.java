package OKOFFER.tree;

import utils.TreeNode;

import java.util.Stack;

/**
 * @author: wangdarui
 * @created: 2021/2/9
 */
public class _ZUO_找到二叉搜索树的错误节点 {
    public TreeNode[] getErrorNode(TreeNode root) {
        TreeNode[] errors = new TreeNode[2];
        if (root == null) return errors;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode cur = stack.pop();
                if (pre != null && pre.val > cur.val) {
                    errors[0] = errors[0] == null ? pre : errors[0];
                    errors[1] = cur;
                }
                pre = cur;
                root = cur.right;
            }
        }
        return errors;
    }
}
