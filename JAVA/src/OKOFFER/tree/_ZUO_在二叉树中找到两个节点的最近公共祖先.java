package OKOFFER.tree;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: wangdarui
 * @created: 2021/2/13
 */
public class _ZUO_在二叉树中找到两个节点的最近公共祖先 {

    public static TreeNode lowestAncestor(TreeNode root, TreeNode o1, TreeNode o2) {
        if (root == null || root == o1 || root == o2) {
            return root;
        }
        TreeNode left = lowestAncestor(root.left, o1, o2);
        TreeNode right = lowestAncestor(root.right, o1, o2);
        if (left != null && right != null)
            return root;
        return left == null ? right : left;
    }

    public static TreeNode lowestAncestor2(TreeNode root, TreeNode o1, TreeNode o2) {
        if (root == null) return root;
        Map<TreeNode, TreeNode> map = new HashMap<>();
        setMap(root, map);
        List<TreeNode> o1Parents = new ArrayList<>();
        while (map.containsKey(o1)) {
            o1Parents.add(o1);
            o1 = map.get(o1);
        }
        while (!o1Parents.contains(o2)) {
            o2 = map.get(o2);
        }
        return o2;
    }

    public static void setMap(TreeNode root, Map<TreeNode, TreeNode> map) {
        if (root == null) return;
        if (root.left != null) map.put(root.left, root);
        if (root.right != null) map.put(root.right, root);
        setMap(root.left, map);
        setMap(root.right, map);
    }
}
