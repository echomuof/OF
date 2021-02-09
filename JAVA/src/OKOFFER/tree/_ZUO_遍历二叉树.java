package OKOFFER.tree;

import apple.laf.JRSUIUtils;
import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author: wangdarui
 * @created: 2021/2/9
 */
public class _ZUO_遍历二叉树 {

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
        preOrderRecur(treeNode1);
        System.out.println();
        preOrder(treeNode1);

        inOrderRecur(treeNode1);
        System.out.println();
        inOrder(treeNode1);

        postOrderRecur(treeNode1);
        System.out.println();
        postOrder(treeNode1);

        levelOrder(treeNode1);
    }

    /**
     * 前序递归
     *
     * @param root
     */
    public static void preOrderRecur(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val);
        preOrderRecur(root.left);
        preOrderRecur(root.right);
    }

    /**
     * 中序递归
     *
     * @param root
     */
    public static void inOrderRecur(TreeNode root) {
        if (root == null) return;
        inOrderRecur(root.left);
        System.out.print(root.val);
        inOrderRecur(root.right);
    }

    /**
     * 后序递归
     *
     * @param root
     */
    public static void postOrderRecur(TreeNode root) {
        if (root == null) return;
        postOrderRecur(root.left);
        postOrderRecur(root.right);
        System.out.print(root.val);
    }

    /**
     * 前序非递归
     *
     * @param root
     */
    public static void preOrder(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            System.out.print(cur.val);
            if (cur.right != null) stack.push(cur.right);
            if (cur.left != null) stack.push(cur.left);
        }
        System.out.println();
    }

    /**
     * 中序非递归
     *
     * @param root
     */
    public static void inOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode cur = stack.pop();
            System.out.print(cur.val);
            root = cur.right;
        }
        System.out.println();
    }

    public static void postOrder(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);
        while (!s1.isEmpty()) {
            TreeNode cur = s1.pop();
            s2.push(cur);
            if (cur.left != null) s1.push(cur.left);
            if (cur.right != null) s1.push(cur.right);
        }
        while (!s2.isEmpty())
            System.out.print(s2.pop().val);

        System.out.println();
    }

    public static void levelOrder(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                System.out.print(cur.val);
                if (cur.left!=null) queue.offer(cur.left);
                if (cur.right!=null) queue.offer(cur.right);
            }
        }
        System.out.println();
    }

}
