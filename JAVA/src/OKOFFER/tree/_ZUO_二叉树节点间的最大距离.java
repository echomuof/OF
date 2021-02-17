package OKOFFER.tree;

import utils.TreeNode;

/**
 * @author: wangdarui
 * @created: 2021/2/13
 */
public class _ZUO_二叉树节点间的最大距离 {

    static class ReturnType {
        public int maxDistance;

        public int height;

        public ReturnType(int maxDistance, int height) {
            this.maxDistance = maxDistance;
            this.height = height;
        }
    }

    public static int getMaxDistance(TreeNode root) {
        return process(root).maxDistance;
    }

    public static ReturnType process(TreeNode root) {
        if (root == null) return new ReturnType(0, 0);
        ReturnType lData = process(root.left);
        ReturnType rData = process(root.right);
        int height = Math.max(lData.height, rData.height) + 1;
        int maxDistance = Math.max(lData.height + rData.height + 1, Math.max(lData.maxDistance, rData.maxDistance));
        return new ReturnType(height, maxDistance);
    }

}
