package OKOFFER.list;

import utils.ListNode;

import java.util.List;

/**
 * @author: wangdarui
 * @created: 2021/2/2
 */
public class _ZUO_删除链表的中间节点 {
    public ListNode removeMid(ListNode head) {
        if (head == null || head.next == null) return head;
        if (head.next.next == null) return head.next;
        ListNode pre = head;
        ListNode cur = head.next.next;
        while (cur.next != null && cur.next.next != null) {
            pre = pre.next;
            cur = cur.next.next;
        }
        pre.next = pre.next.next;
        return head;
    }
}
