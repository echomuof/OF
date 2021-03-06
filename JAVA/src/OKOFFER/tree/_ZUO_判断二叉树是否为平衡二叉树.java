package OKOFFER.tree;

import utils.TreeNode;

/**
 * @author: wangdarui
 * @created: 2021/2/10
 */
public class _ZUO_判断二叉树是否为平衡二叉树 {
    public static boolean isBalance(TreeNode root) {
        return process(root).isBalance;
    }

    public static ReturnType process(TreeNode root) {
        if (root == null) return new ReturnType(true, 0);
        ReturnType lData = process(root.left);
        ReturnType rData = process(root.right);
        int height = Math.max(lData.getHeight(), rData.getHeight()) + 1;
        boolean isBalance = lData.isBalance && rData.isBalance && Math.abs(lData.getHeight() - rData.getHeight()) <= 1;
        return new ReturnType(isBalance, height);
    }

    static class ReturnType {
        private boolean isBalance;

        private int height;

        public ReturnType(boolean isBalance, int height) {
            this.isBalance = isBalance;
            this.height = height;
        }

        public boolean isBalance() {
            return isBalance;
        }

        public void setBalance(boolean balance) {
            isBalance = balance;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }
    }
}
