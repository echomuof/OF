package OKOFFER.list;

import utils.ListNode;

/**
 * @author: wangdarui
 * @created: 2021/2/3
 */
public class _leetcode_25_k个一组反转链表 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode newHead = new ListNode(0, head);
        ListNode pre = newHead;
        ListNode end = newHead;
        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) break;
            ListNode start = pre.next;
            ListNode endPos = end.next;
            end.next = null;
            pre.next = reverseList(start);
            start.next = endPos;
            pre = start;
            end = start;
        }
        return newHead.next;
    }

    public ListNode reverseList(ListNode head) {
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
