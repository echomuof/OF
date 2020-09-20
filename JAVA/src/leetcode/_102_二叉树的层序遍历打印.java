package leetcode;

import utils.TreeNode;

import java.util.*;

/**
 * @author: wangdarui
 * @date: 2020/9/20
 */
public class _102_二叉树的层序遍历打印 {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node1.left = node2;
        node2.left = node4;
        node2.right = node5;
        node1.right = node3;
        node3.left = node6;
        node3.right = node7;
        levelOrder2(node1);
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Map<TreeNode, Integer> map = new HashMap<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        int level = 0;
        map.put(root, 0);
        res.add(new ArrayList<>());
        while (!queue.isEmpty()) {
            TreeNode pollNode = queue.pollFirst();
            if (map.get(pollNode) != level) {
                level++;
                res.add(new ArrayList<>());
                res.get(level).add(pollNode.val);
            } else {
                res.get(level).add(pollNode.val);
            }
            if (pollNode.left != null) {
                queue.addLast(pollNode.left);
                map.put(pollNode.left, level + 1);
            }
            if (pollNode.right != null) {
                queue.addLast(pollNode.right);
                map.put(pollNode.right, level + 1);
            }
        }
        return res;
    }

    public static List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.pollFirst();
                level.add(cur.val);
                if (cur.left != null) {
                    queue.addLast(cur.left);
                }
                if (cur.right != null) {
                    queue.addLast(cur.right);
                }
            }
            res.add(level);
        }
        return res;
    }
}
