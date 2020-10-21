package leetcode;

import utils.ListNode;

/**
 * @author: wangdarui
 * @created: 2020/10/21
 */
public class _19_删除链表的倒数第N个节点 {

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

    int n;

    public ListNode recur(ListNode head) {
        if (head.next == null) {
            n--;
            return head;
        }
        ListNode next = recur(head.next);
        head.next = next;
        n--;
        if (n == 0) {
            return next;
        }
        return head;
    }

}
