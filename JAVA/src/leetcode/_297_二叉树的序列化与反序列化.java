package leetcode;

import utils.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: wangdarui
 * @created: 2020/9/21
 */
public class _297_二叉树的序列化与反序列化 {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node1.left = node2;
        // node2.left = node4;
        // node2.right = node5;
        node1.right = node3;
        node3.left = node6;
        node3.right = node7;
        String str = serialize(node1);
        System.out.println(str);
        deserialize("");
    }

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        StringBuilder sb = new StringBuilder();
        sb.append(root.val + "#");
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.pollFirst();
                sb.append((cur.left == null ? "_" : cur.left.val) + "#");
                sb.append((cur.right == null ? "_" : cur.right.val) + "#");
                if (cur.left != null) {
                    queue.addLast(cur.left);
                }
                if (cur.right != null) {
                    queue.addLast(cur.right);
                }
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        String[] arr = data.split("#");
        if (arr.length == 1) {
            return null;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        queue.addLast(root);
        int i = 1;
        while (!queue.isEmpty() && i < arr.length) {
            TreeNode cur = queue.pollFirst();
            cur.left = arr[i].equals("_") ? null : new TreeNode(Integer.parseInt(arr[i]));
            i++;
            cur.right = arr[i].equals("_") ? null : new TreeNode(Integer.parseInt(arr[i]));
            i++;
            if (cur.left != null) {
                queue.addLast(cur.left);
            }
            if (cur.right != null) {
                queue.addLast(cur.right);
            }
        }
        return root;
    }
}
