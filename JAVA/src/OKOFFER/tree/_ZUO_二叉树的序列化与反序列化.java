package OKOFFER.tree;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: wangdarui
 * @created: 2021/2/9
 */
public class _ZUO_二叉树的序列化与反序列化 {

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;
        String str = serialize(treeNode1);
        System.out.println(str);
        TreeNode deserialize = deserialize(str);
        System.out.println();
    }

    public static String serialize(TreeNode root) {
        if (root == null) return "";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        StringBuilder sb = new StringBuilder();
        sb.append(root.val + "#");
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            sb.append((cur.left == null ? "_" : cur.left.val) + "#");
            sb.append((cur.right == null ? "_" : cur.right.val) + "#");
            if (cur.left != null) queue.offer(cur.left);
            if (cur.right != null) queue.offer(cur.right);
        }
        return sb.toString();
    }

    public static TreeNode deserialize(String str) {
        if (str == null || str.length() == 0) return null;
        String[] sArr = str.split("#");
        TreeNode head = new TreeNode(Integer.parseInt(sArr[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(head);
        int i = 1;
        while (!queue.isEmpty() && i < sArr.length) {
            TreeNode cur = queue.poll();
            cur.left = sArr[i].equals("_") ? null : new TreeNode(Integer.parseInt(sArr[i]));
            i++;
            cur.right = sArr[i].equals("_") ? null : new TreeNode(Integer.parseInt(sArr[i]));
            i++;
            if (cur.left != null) queue.offer(cur.left);
            if (cur.right != null) queue.offer(cur.right);
        }
        return head;
    }

}
