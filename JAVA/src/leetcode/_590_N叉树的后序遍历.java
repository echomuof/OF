package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wangdarui
 * @date: 2020/9/20
 */
public class _590_N叉树的后序遍历 {
    public static void main(String[] args) {

    }

    public static List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        process(root, res);
        return res;
    }

    public static void process(Node root, List<Integer> res) {
        if (root == null) {
            return;
        }
        for (Node child : root.children) {
            process(child, res);
        }
        res.add(root.val);
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
