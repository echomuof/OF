package leetcode;

import java.util.*;

/**
 * @author: wangdarui
 * @date: 2020/9/20
 */
public class _429_N叉树的层序遍历 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<Node> queue = new LinkedList<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node pollNode = queue.pollFirst();
                level.add(pollNode.val);
                if (pollNode.children != null) {
                    for (Node child : pollNode.children) {
                        queue.addLast(child);
                    }
                }
            }
            res.add(level);
        }
        return res;
    }

    public List<List<Integer>> levelOrder2(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        List<Node> levelNodeList = Arrays.asList(root);
        while (!levelNodeList.isEmpty()) {
            List<Node> curLevelNodeList = new ArrayList<>();
            List<Integer> level = new ArrayList<>();
            for (Node node : levelNodeList) {
                curLevelNodeList.addAll(node.children);
                level.add(node.val);
            }
            res.add(level);
            levelNodeList = curLevelNodeList;
        }
        return res;
    }

    public List<List<Integer>> levelOrder3(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        process(root, 0, res);
        return res;
    }

    public void process(Node root, int level, List<List<Integer>> res) {
        if (res.size() <= level) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);
        for (Node child : root.children) {
            process(child, level + 1, res);
        }
    }
}
