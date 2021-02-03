package OKOFFER.list;

import utils.ListNode;

/**
 * @author: wangdarui
 * @created: 2021/2/2
 */
public class _ZUO_翻转部分单向链表 {
    public ListNode reverse(ListNode head, int from, int to) {
        int len = 0;
        ListNode node1 = head;
        ListNode fPre = null;
        ListNode tPos = null;
        while (node1 != null) {
            len++;
            fPre = len == from - 1 ? node1 : fPre;
            tPos = len == to + 1 ? node1 : tPos;
            node1 = node1.next;
        }
        if (from > to || from < 1 || to > len) return head;
        ListNode pre = fPre == null ? head : fPre.next;
        ListNode cur = pre.next;
        while (cur != tPos) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        if (fPre != null) {
            fPre.next = node1;
            return head;
        }
        return node1;
    }
}
