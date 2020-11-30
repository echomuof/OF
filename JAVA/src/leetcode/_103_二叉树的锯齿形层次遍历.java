package leetcode;

import utils.ListNode;
import utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: wangdarui
 * @created: 2020/11/30
 */
public class _103_二叉树的锯齿形层次遍历 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        LinkedList<TreeNode> level = new LinkedList<>();
        boolean isReverse = false;
        level.addFirst(root);
        while (!level.isEmpty()) {
            LinkedList<Integer> cur = new LinkedList<>();
            int size = level.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = level.pollFirst();
                if (node.left != null) level.addLast(node.left);
                if (node.right != null) level.addLast(node.right);
                if (isReverse) {
                    cur.addFirst(node.val);
                } else {
                    cur.addLast(node.val);
                }
            }
            ans.add(cur);
            isReverse = !isReverse;
        }
        return ans;
    }
}
