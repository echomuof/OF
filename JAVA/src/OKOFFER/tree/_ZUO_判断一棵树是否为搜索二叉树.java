package OKOFFER.tree;

import utils.TreeNode;

import java.util.Stack;

/**
 * @author: wangdarui
 * @created: 2021/2/10
 */
public class _ZUO_判断一棵树是否为搜索二叉树 {

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(5);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(8);
        TreeNode treeNode4 = new TreeNode(2);
        TreeNode treeNode5 = new TreeNode(4);
        TreeNode treeNode6 = new TreeNode(7);
        TreeNode treeNode7 = new TreeNode(9);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;
        System.out.println(checkBST(treeNode1));
    }

    public static boolean checkBST(TreeNode root) {
        TreeNode pre = null;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode cur = stack.pop();
            System.out.println(cur.val);
            if (pre != null && pre.val > cur.val) {
                return false;
            }
            pre = cur;
            root = cur.right;
        }
        return true;
    }

}
