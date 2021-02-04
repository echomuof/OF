package OKOFFER.list;

import utils.ListNode;

/**
 * @author: wangdarui
 * @created: 2021/2/4
 */
public class _ZUO_合并两个有序的单链表 {
    public ListNode merge(ListNode head1, ListNode head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;
        if (head1.val <= head2.val) {
            head1.next = merge(head1.next, head2);
            return head1;
        } else {
            head2.next = merge(head1, head2.next);
            return head2;
        }
    }
}
