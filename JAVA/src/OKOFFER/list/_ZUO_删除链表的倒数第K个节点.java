package OKOFFER.list;

import utils.ListNode;
import utils.Node;

/**
 * @author: wangdarui
 * @created: 2021/2/3
 */
public class _ZUO_删除链表的倒数第K个节点 {

    public ListNode removeLastKthNode(ListNode head, int k) {
        if (head == null || k < 1) return head;
        ListNode cur = head;
        while (cur != null) {
            k--;
            cur = cur.next;
        }
        if (k == 0) head = head.next;
        if (k < 0) {
            cur = head;
            while (++k != 0) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }

    public ListNode removeLastKthNode2(ListNode head, int k) {
        if (head == null || k < 1) return head;
        ListNode ans = new ListNode(0, head);
        ListNode first = head;
        ListNode second = ans;
        for (int i = 0; i < k; i++) {
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
