package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wangdarui
 * @date: 2020/9/20
 */
public class _589_N叉树的前序遍历 {
    public static void main(String[] args) {

    }

    public static List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        process(root, res);
        return res;
    }

    public static void process(Node root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        for (Node child : root.children) {
            process(child, res);
        }
    }
}
