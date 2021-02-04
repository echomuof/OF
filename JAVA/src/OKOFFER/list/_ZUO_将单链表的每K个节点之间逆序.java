package OKOFFER.list;

import utils.ListNode;

/**
 * @author: wangdarui
 * @created: 2021/2/4
 */
public class _ZUO_将单链表的每K个节点之间逆序 {

    public ListNode reverseListGroupK(ListNode head, int k) {
        if (head == null || head.next == null || k < 2) return head;
        ListNode newHead = new ListNode(0, head);
        ListNode pre = newHead;
        ListNode end = newHead;
        while (end.next != null) {
            for (int i = 0; i < k; i++) {
                end = end.next;
            }
            ListNode next = end.next;
            ListNode start = pre.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = next;
            pre = start;
            end = start;
        }
        return newHead.next;
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

}
