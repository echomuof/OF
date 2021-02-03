package OKOFFER.list;

import utils.ListNode;

/**
 * @author: wangdarui
 * @created: 2021/2/2
 */
public class _ZUO_删除链表倒数第K个节点 {
    public ListNode removeK(ListNode head, int K) {
        if (head == null || K < 1) return head;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            K--;
        }
        if (K == 0) {
            head = head.next;
        }
        if (K < 0) {
            cur = head;
            while (++K != 0) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ans = new ListNode(0, head);
        ListNode first = head;
        ListNode second = ans;
        for (int i = 0; i < n; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return ans.next;
    }
}
