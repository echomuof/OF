package OKOFFER.list;

import utils.ListNode;

/**
 * @author: wangdarui
 * @created: 2021/2/2
 */
public class _ZUO_打印两个有序链表的公共部分 {
    public void printCommonPart(ListNode head1, ListNode head2) {
        while (head1 != null && head2 != null) {
            if (head1.val > head2.val) {
                head2 = head2.next;
            } else if (head2.val > head1.val) {
                head1 = head1.next;
            } else {
                System.out.println(head1.val + " ");
                head1 = head1.next;
                head2 = head2.next;
            }
        }
    }
}
