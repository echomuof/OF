package OKOFFER.tree;

import utils.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: wangdarui
 * @created: 2021/2/9
 */
public class _ZUO_二叉树的按层打印与ZigZag打印 {

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
        printLevelZigZag(treeNode1);
    }

    public static void printLevel(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        int level = 1;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            System.out.print("level " + level++ + ": ");
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                System.out.print(cur.val + " ");
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
            System.out.println();
        }
    }

    public static void printLevelZigZag(TreeNode root) {
        if (root == null) return;
        Deque<TreeNode> deque = new LinkedList<>();
        int level = 1;
        deque.offer(root);
        boolean isReverse = false;
        while (!deque.isEmpty()) {
            int size = deque.size();
            if (isReverse)
                System.out.print("Level " + level++ + "form right to left: ");
            else
                System.out.print("Level " + level++ + "form left to right: ");

            LinkedList<Integer> linkedList = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = deque.pollFirst();
                if (cur.left != null) deque.addLast(cur.left);
                if (cur.right != null) deque.addLast(cur.right);
                if (isReverse)
                    linkedList.addFirst(cur.val);
                else
                    linkedList.addLast(cur.val);
            }
            isReverse = !isReverse;
            while (!linkedList.isEmpty()) {
                System.out.print(linkedList.pollFirst()+" ");
            }
            System.out.println();
        }
    }

}
