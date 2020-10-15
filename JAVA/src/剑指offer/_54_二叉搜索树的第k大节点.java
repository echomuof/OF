package 剑指offer;

import utils.TreeNode;

/**
 * @author: wangdarui
 * @created: 2020/10/15
 */
public class _54_二叉搜索树的第k大节点 {
    public static void main(String[] args) {

    }

    int k;
    int ans;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode root) {
        if (root==null) return;
        dfs(root.right);
        if (k==0) return;
        if (--k == 0) {
            ans = root.val;
            return;
        }
        dfs(root.left);
    }
}
