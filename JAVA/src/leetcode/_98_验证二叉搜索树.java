package leetcode;

import com.sun.jmx.snmp.SnmpNull;
import utils.TreeNode;

/**
 * @author: wangdarui
 * @date: 2020/9/21
 */
public class _98_验证二叉搜索树 {
    public static void main(String[] args) {

    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return process(root, null, null);
    }

    public boolean process(TreeNode root, Integer lower, Integer upper) {
        if (root == null) {
            return true;
        }
        if (lower != null && root.val <= lower) return false;
        if (upper != null && root.val >= upper) return false;
        if (!process(root.left, lower, root.val)) return false;
        if (!process(root.right, root.val, upper)) return false;
        return true;
    }

}
