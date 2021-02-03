package OKOFFER.list;

import utils.ListNode;

/**
 * @author: wangdarui
 * @created: 2021/2/3
 */
public class _leetcode_24_两两交换链表中的节点 {
    public ListNode swapPairs(ListNode head) {
        ListNode pre = new ListNode(0, head);
        ListNode cur = pre;
        while (cur.next != null && cur.next.next != null) {
            ListNode start = cur.next;
            ListNode end = cur.next.next;
            cur.next = end;
            start.next = end.next;
            end.next = start;
            cur = start;
        }
        return pre.next;
    }
}
