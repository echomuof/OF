package 剑指offer;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: wangdarui
 * @created: 2020/9/28
 */
public class _32_从上到下打印二叉树 {
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        Deque<TreeNode> queue = new LinkedList<>();
        List<Integer> ansList = new ArrayList<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.pollFirst();
            ansList.add(cur.val);
            if (cur.left != null) queue.addLast(cur.left);
            if (cur.right != null) queue.addLast(cur.right);
        }
        return ansList.stream().mapToInt(Integer::intValue).toArray();
    }
}
