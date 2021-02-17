package OKOFFER.tree;

import utils.TreeNode;

/**
 * @author: wangdarui
 * @created: 2021/2/10
 */
public class _ZUO_根据后序数组重建搜索二叉树 {

    public static TreeNode postArray2BST(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        boolean isPost = isPost(arr, 0, arr.length - 1);
        if (!isPost) return null;
        return post2BST(arr, 0, arr.length - 1);
    }

    public static boolean isPost(int[] arr, int start, int end) {
        if (start == end) return true;
        int less = -1;
        int more = end;
        for (int i = start; i < end; i++) {
            if (arr[i] < arr[end]) less = i;
            else more = more == end ? i : more;
        }
        if (less == -1 || more == end) {
            return isPost(arr, start, end - 1);
        }
        if (less != more - 1) {
            return false;
        }
        return isPost(arr, start, less) && isPost(arr, more, end - 1);
    }

    public static TreeNode post2BST(int[] arr, int start, int end) {
        if (start > end) return null;
        TreeNode head = new TreeNode(arr[end]);
        int less = -1;
        int more = end;
        for (int i = start; i < end; i++) {
            if (arr[i] < arr[end]) {
                less = i;
            } else {
                more = more == end ? i : more;
            }
        }
        head.left = post2BST(arr, start, less);
        head.right = post2BST(arr, more, end - 1);
        return head;
    }

}
