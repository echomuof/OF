package OKOFFER.tree;

import utils.TreeNode;

/**
 * @author: wangdarui
 * @created: 2021/2/9
 */
public class _ZUO_判断t1树中是否有与t2树拓扑结构完全相同的子树 {

    /*
     * 获取t1、t2的序列化字符串s1、s2
     * 然后使用KMP判断s1中是否包含s2
     */
    public static boolean contains(TreeNode t1, TreeNode t2) {
        String s1 = serialByPre(t1);
        String s2 = serialByPre(t2);
        return true;
    }

    public static String serialByPre(TreeNode root) {
        if (root == null) return "#!";
        String ans = root.val + "!";
        ans += serialByPre(root.left);
        ans += serialByPre(root.right);
        return ans;
    }

}
