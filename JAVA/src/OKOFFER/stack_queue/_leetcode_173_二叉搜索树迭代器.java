package OKOFFER.stack_queue;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author: wangdarui
 * @created: 2021/2/2
 */
public class _leetcode_173_二叉搜索树迭代器 {
}

class BSTIterator {

    private Queue<Integer> queue;

    public BSTIterator(TreeNode root) {
        queue = new LinkedList();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            queue.add(root.val);
            root = root.right;
        }
    }

    public int next() {
        return queue.isEmpty() ? -1 : queue.poll();
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }
}
