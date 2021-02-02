package OKOFFER.stack_queue;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: wangdarui
 * @created: 2021/2/2
 */
public class _leetcode_103_二叉树的锯齿形层序遍历 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        boolean isReverse = false;
        while (!deque.isEmpty()) {
            int size = deque.size();
            LinkedList<Integer> level = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = deque.pollFirst();
                if (cur.left != null) deque.addLast(cur.left);
                if (cur.right != null) deque.addLast(cur.right);
                if (isReverse) level.addFirst(cur.val);
                else level.addLast(cur.val);
            }
            isReverse = !isReverse;
            ans.add(level);
        }
        return ans;
    }
}
