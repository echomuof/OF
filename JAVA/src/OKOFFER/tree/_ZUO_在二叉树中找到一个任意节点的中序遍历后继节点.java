package OKOFFER.tree;

import utils.TreeNode;

/**
 * @author: wangdarui
 * @created: 2021/2/13
 */
public class _ZUO_在二叉树中找到一个任意节点的中序遍历后继节点 {
    static class Node {

        public int value;
        public Node left;
        public Node right;
        public Node parent;

        public Node(int data) {
            this.value = data;
        }

    }

    public Node findNext(Node root) {
        if (root == null) return root;
        if (root.right != null) {
            //中序遍历中，一个节点的后续节点等于其右节点的最左子节点
            return getLeftMost(root);
        } else {
            //如果该节点的右节点为空，则其后续节点等于其父节点
            Node parent = root.parent;
            while (parent != null && parent.left != root) {
                root = parent;
                parent = root.parent;
            }
            return parent;
        }
    }

    public Node getLeftMost(Node root) {
        if (root == null) return root;
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
}
