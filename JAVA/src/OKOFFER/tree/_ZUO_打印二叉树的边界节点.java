package OKOFFER.tree;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: wangdarui
 * @created: 2021/2/9
 */
public class _ZUO_打印二叉树的边界节点 {

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
        printBoundary(treeNode1);
    }


    public static void printBoundary(TreeNode root) {
        if (root == null) return;
        int height = getHeight(root, 0);
        TreeNode[][] edgeMap = new TreeNode[height][2];
        setEdgeMap(root, edgeMap, 0);
        for (int i = 0; i < height; i++) {
            System.out.print(edgeMap[i][0].val);
        }
        printLeafNotInMap(root, edgeMap, 0);
        for (int i = height - 1; i >= 0; i--) {
            if (edgeMap[i][0] != edgeMap[i][1]) {
                System.out.print(edgeMap[i][1].val);
            }
        }
        System.out.println();
    }

    private static void printLeafNotInMap(TreeNode root, TreeNode[][] edgeMap, int level) {
        if (root == null) return;
        if (root.left == null && root.right == null && root != edgeMap[level][0] && root != edgeMap[level][1]) {
            System.out.print(root.val);
        }
        printLeafNotInMap(root.left, edgeMap, level + 1);
        printLeafNotInMap(root.right, edgeMap, level + 1);
    }

    private static void setEdgeMap(TreeNode root, TreeNode[][] edgeMap, int level) {
        if (root == null) return;
        edgeMap[level][0] = edgeMap[level][0] == null ? root : edgeMap[level][0];
        edgeMap[level][1] = root;
        setEdgeMap(root.left, edgeMap, level + 1);
        setEdgeMap(root.right, edgeMap, level + 1);
    }

    public static int getHeight(TreeNode root, int curLevel) {
        if (root == null) return curLevel;
        return Math.max(getHeight(root.left, curLevel + 1), getHeight(root.right, curLevel + 1));
    }
}
