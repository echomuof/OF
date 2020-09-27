package 剑指offer;

import utils.ListNode;
import utils.TreeNode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author: wangdarui
 * @created: 2020/9/27
 */
public class _7_重建二叉树 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }

    public TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> map) {
        if (preEnd < preStart) {
            return null;
        }
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        if (preStart == preEnd) {
            return root;
        }
        int rootIdx = map.get(rootVal);
        int leftNodes = rootIdx - inStart;
        int rightNodes = inEnd - rootIdx;
        TreeNode left = buildTree(preorder, preStart + 1, preStart + leftNodes, inorder, inStart, rootIdx - 1, map);
        TreeNode right = buildTree(preorder, preEnd - rightNodes + 1, preEnd, inorder, rootIdx + 1, inEnd, map);
        root.left = left;
        root.right = right;
        return root;
    }
}
