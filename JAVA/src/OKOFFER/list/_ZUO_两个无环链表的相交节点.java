package OKOFFER.list;

import utils.ListNode;

/**
 * @author: wangdarui
 * @created: 2021/2/4
 */
public class _ZUO_两个无环链表的相交节点 {
    public ListNode intersectNode(ListNode head1, ListNode head2) {
        ListNode cur1 = head1;
        ListNode cur2 = head2;
        int len1 = 0;
        int len2 = 0;
        while (cur1.next != null) {
            len1++;
            cur1 = cur1.next;
        }
        while (cur2.next != null) {
            len2++;
            cur2 = cur2.next;
        }
        if (cur1 != cur2) return null;
        if (len1 > len2) {
            for (int i = 0; i < len1 - len2; i++) {
                head1 = head1.next;
            }
        } else if (len1 < len2) {
            for (int i = 0; i < len2 - len1; i++) {
                head2 = head2.next;
            }
        }
        while (head1 != head2) {
            head1 = head1.next;
            head2 = head2.next;
        }
        return head1;
    }
}
