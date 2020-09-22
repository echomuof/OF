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
        return process(root, null, null);
    }

    public boolean process(TreeNode node, Integer lower, Integer upper) {
        if (node == null) {
            return true;
        }
        if (lower != null && node.val <= lower) return false;
        if (upper != null && node.val >= upper) return false;
        if (!process(node.left, lower, node.val)) return false;
        if (!process(node.right, node.val, upper)) return false;
        return true;
    }

}
