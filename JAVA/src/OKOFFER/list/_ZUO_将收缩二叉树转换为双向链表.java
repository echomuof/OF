package OKOFFER.list;

import utils.ListNode;
import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: wangdarui
 * @created: 2021/2/4
 */
public class _ZUO_将收缩二叉树转换为双向链表 {
    public TreeNode convert1(TreeNode head) {
        Queue<TreeNode> queue = new LinkedList<>();
        inOrderToQueue(head, queue);
        if (queue.isEmpty()) return head;
        head = queue.poll();
        TreeNode pre = head;
        pre.left = null;
        TreeNode cur = null;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            pre.right = cur;
            cur.left = pre;
            pre = cur;
        }
        pre.right = null;
        return head;
    }

    public void inOrderToQueue(TreeNode head, Queue<TreeNode> queue) {
        if (head == null) return;
        inOrderToQueue(head.left, queue);
        queue.add(head);
        inOrderToQueue(head.right, queue);
    }
}
