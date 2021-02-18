package OKOFFER.stack_queue;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: wangdarui
 * @created: 2021/2/2
 */
public class _leetcode_24_二叉树的中序遍历 {

    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode cur = stack.pop();
            ans.add(cur.val);
            root = cur.right;
        }
        return ans;
    }

}
