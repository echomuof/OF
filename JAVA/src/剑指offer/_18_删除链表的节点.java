package 剑指offer;

import utils.ListNode;

import java.util.List;

/**
 * @author: wangdarui
 * @created: 2020/9/28
 */
public class _18_删除链表的节点 {
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        ListNode cur = new ListNode(-1, head);
        ListNode newHead = cur;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
                return newHead.next;
            }
            cur = cur.next;
        }
        return newHead.next;
    }
}
