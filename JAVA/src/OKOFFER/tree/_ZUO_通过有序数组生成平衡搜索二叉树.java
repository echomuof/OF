package OKOFFER.tree;

import utils.TreeNode;

/**
 * @author: wangdarui
 * @created: 2021/2/13
 */
public class _ZUO_通过有序数组生成平衡搜索二叉树 {
    public TreeNode generateTree(int[] sortArr) {
        if (sortArr == null || sortArr.length == 0) return null;
        return generate(sortArr, 0, sortArr.length - 1);
    }

    public TreeNode generate(int[] sortArr, int start, int end) {
        if (start > end) return null;
        int mid = start + (end - start) / 2;
        TreeNode head = new TreeNode(sortArr[mid]);
        head.left = generate(sortArr, start, mid - 1);
        head.right = generate(sortArr, mid + 1, end);
        return head;
    }
}
