package OKOFFER.tree;

import utils.TreeNode;

/**
 * @author: wangdarui
 * @created: 2021/2/9
 */
public class _ZUO_找到二叉树中的最大搜索二叉子树 {

    public int getMaxBST(TreeNode root) {
        return process(root).getMaxBSTSize();
    }

    public static ReturnType process(TreeNode root) {
        if (root == null)
            return new ReturnType(null, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        ReturnType lData = process(root.left);
        ReturnType rData = process(root.right);
        int min = Math.min(root.val, Math.min(lData.getMin(), rData.getMin()));
        int max = Math.max(root.val, Math.max(lData.getMax(), rData.getMax()));
        int maxBSTSize = Math.max(lData.getMaxBSTSize(), rData.getMaxBSTSize());
        TreeNode maxBSTHead = lData.getMaxBSTSize() >= rData.getMaxBSTSize() ? lData.getMaxBSTHead() : rData.getMaxBSTHead();
        if (root.left == lData.getMaxBSTHead()
                && root.right == rData.getMaxBSTHead()
                && root.val > lData.getMax()
                && root.val < lData.getMin()
        ) {
            maxBSTSize = lData.getMaxBSTSize() + rData.getMaxBSTSize() + 1;
            maxBSTHead = root;
        }
        return new ReturnType(maxBSTHead, maxBSTSize, min, max);
    }

}

class ReturnType {

    private TreeNode maxBSTHead;

    private int maxBSTSize;

    private int min;

    private int max;

    public ReturnType(TreeNode maxBSTHead, int maxBSTSize, int min, int max) {
        this.maxBSTHead = maxBSTHead;
        this.maxBSTSize = maxBSTSize;
        this.min = min;
        this.max = max;
    }

    public TreeNode getMaxBSTHead() {
        return maxBSTHead;
    }

    public void setMaxBSTHead(TreeNode maxBSTHead) {
        this.maxBSTHead = maxBSTHead;
    }

    public int getMaxBSTSize() {
        return maxBSTSize;
    }

    public void setMaxBSTSize(int maxBSTSize) {
        this.maxBSTSize = maxBSTSize;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }
}
