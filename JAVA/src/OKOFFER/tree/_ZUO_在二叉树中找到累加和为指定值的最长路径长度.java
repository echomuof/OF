package OKOFFER.tree;

import utils.TreeNode;

/**
 * @author: wangdarui
 * @created: 2021/2/9
 */
public class _ZUO_在二叉树中找到累加和为指定值的最长路径长度 {

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(-3);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(-9);
        TreeNode treeNode4 = new TreeNode(1);
        TreeNode treeNode5 = new TreeNode(0);
        TreeNode treeNode6 = new TreeNode(1);
        TreeNode treeNode7 = new TreeNode(6);
        TreeNode treeNode8 = new TreeNode(2);
        TreeNode treeNode9 = new TreeNode(1);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode5.left = treeNode6;
        treeNode5.right = treeNode7;
        treeNode3.left = treeNode8;
        treeNode3.right = treeNode9;
        System.out.println(getMaxLenN(treeNode1, 6));
    }

    public static int getMaxLenN(TreeNode root, int n) {
        if (root == null) return 0;
        return recur(root, n, 1);
    }

    public static int recur(TreeNode root, int n, int step) {
        if (root == null) return 0;
        int cur = n - root.val;
        if (cur == 0) return step;
        if (cur < 0) return 0;
        return Math.max(recur(root.left, cur, step + 1), recur(root.right, cur, step + 1));
    }

}
