package OKOFFER.tree;

import utils.TreeNode;

/**
 * @author: wangdarui
 * @created: 2021/2/9
 */
public class _ZUO_判断t1树是否包含t2树全部的拓扑结构 {

    public static boolean contains(TreeNode t1, TreeNode t2) {
        if (t2 == null) return true;
        if (t1 == null) return false;
        return check(t1, t2) || contains(t1.left, t2) || contains(t1.right, t2);
    }

    public static boolean check(TreeNode t1, TreeNode t2) {
        if (t2 == null) return true;
        if (t1 == null || t1.val != t2.val) return false;
        return check(t1.left, t2.left) && check(t1.right, t2.right);
    }

}
