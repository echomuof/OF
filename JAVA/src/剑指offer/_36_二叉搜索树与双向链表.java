package 剑指offer;

import apple.laf.JRSUIUtils;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import utils.ListNode;
import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: wangdarui
 * @created: 2020/10/12
 */
public class _36_二叉搜索树与双向链表 {
    public static void main(String[] args) {
        TreeNode n4 = new TreeNode(4);
        TreeNode n2 = new TreeNode(2);
        TreeNode n5 = new TreeNode(5);
        TreeNode n1 = new TreeNode(1);
        TreeNode n3 = new TreeNode(3);
        n4.left = n2;
        n4.right = n5;
        n2.left = n1;
        n2.right = n3;

        _36_二叉搜索树与双向链表 a = new _36_二叉搜索树与双向链表();
        TreeNode treeNode = a.treeToDoublyList(n1);
        System.out.println();
    }

    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) {
            return root;
        }
        if (root.left == null && root.right == null) {
            root.left = root;
            root.right = root;
            return root;
        }
        Stack<TreeNode> stack = new Stack<>();
        List<TreeNode> list = new ArrayList<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                list.add(root);
                root = root.right;
            }
        }
        for (int i = 1; i < list.size()-1; i++) {
            TreeNode cur = list.get(i);
            cur.left = list.get(i - 1);
            cur.right = list.get(i + 1);
        }
        list.get(0).right = list.get(1);
        list.get(0).left = list.get(list.size() - 1);
        list.get(list.size() - 1).right = list.get(0);
        list.get(list.size() - 1).left = list.get(list.size() - 2);
        return list.get(0);
    }
}
