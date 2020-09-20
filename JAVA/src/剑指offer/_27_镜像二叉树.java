package 剑指offer;

import com.sun.jmx.snmp.SnmpNull;
import utils.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: wangdarui
 * @date: 2020/9/20
 */
public class _27_镜像二叉树 {
    public static void main(String[] args) {

    }

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }

    public TreeNode mirrorTree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            if (pop == null) {
                continue;
            }
            TreeNode tmp = pop.left;
            pop.left = pop.right;
            pop.right = tmp;
            stack.push(pop.left);
            stack.push(pop.right);
        }
        return root;
    }
}
