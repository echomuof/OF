package OKOFFER.tree;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: wangdarui
 * @created: 2021/2/13
 */
public class _ZUO_判断一棵二叉树是否为完全二叉树 {

    public static boolean isCBT(TreeNode root) {
        if (root == null) return true;
        boolean leaf = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            TreeNode l = cur.left;
            TreeNode r = cur.right;
            //如果出现了叶子节点，那么后续的所有节点都必须为叶子节点
            if ((leaf && (l != null || r != null)) || (l == null && r != null)) {
                return false;
            }
            if (l != null) queue.offer(l);
            if (r != null) queue.offer(r);
            else leaf = true;
        }
        return true;
    }

}
